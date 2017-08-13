package org.miko.controller;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;
import org.miko.service.ArticleService;
import org.miko.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;


@Controller
public class ArticleController {


    @Autowired
    @Qualifier("articleService")
    ArticleService service;


    @RequestMapping(value = "/share")
    @ResponseBody
    public String share(@RequestParam("articleId") String id, @RequestParam("title") String title) {
        Article article = service.searchArticle(id);
        if (article == null) {
            return "NoArticle";
        } else {
            ArticleShare articleShare = new ArticleShare();
            articleShare.setTitle(title);
            articleShare.setUserId(id.split("_")[0]);
            articleShare.setArticleId(id);
            articleShare.setShareTime(new Date().getTime());
            service.insertArticleShare(articleShare);
            return "Success";
        }
    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] myfiles,
                         @RequestParam(value = "isShare", required = false) boolean isShare,
                         @RequestParam(value = "title", required = false) String title,
                         HttpServletRequest request) throws IOException {

        /**获s取diary整体的Json*/
        String diaryJson = request.getParameter("diaryJson");
        /**转化为obj*/
        Article diaryObj = new Gson().fromJson(diaryJson, Article.class);

        /**获取文章的id*/
        String id = diaryObj.getArticleId();

        /**创建根目录*/
        String rootPath = "/home/miko/meiriji/" + id + "/";
        File dir = new File(rootPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        /**遍历所有的file，复制到文件夹中*/
        for (MultipartFile f : myfiles) {
            File oldFile = new File(rootPath + f.getOriginalFilename());

            System.out.print(rootPath + f.getOriginalFilename());

            oldFile.createNewFile();

            FileUtils.writeByteArrayToFile(oldFile, f.getBytes());

            System.out.println(f.getOriginalFilename());
        }

        /**将Diary的整体OBJ  DiaryJson -> Article -> db */
        service.insertArticle(diaryObj);
        if (isShare) {
            share(id, title);
            return "no synchronize upload success";
        }
        return "upload success";
    }
}
