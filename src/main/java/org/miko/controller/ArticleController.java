package org.miko.controller;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.miko.entity.*;
import org.miko.enums.ElementTypeEnum;
import org.miko.service.ArticleService;
import org.miko.service.UserLoginService;
import org.miko.service.UserRefreshService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    @Qualifier("articleService")
    ArticleService service;

    @Autowired
    @Qualifier("userRefreshService")
    UserRefreshService userRefreshService;

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


    @RequestMapping(value = "/push_articles")
    @ResponseBody
    public String push(@RequestParam("userId") String userId,
                       @RequestParam("isRefresh") boolean isRefresh) throws UnsupportedEncodingException {

        List<ArticleShare> articleShares;

        if (isRefresh) {
            articleShares = service.getRefreshArticles(userId, 5);
        } else {
            articleShares = service.getNewestArticles(userId, 5);
        }

        /**推送列表插入*/
        if (articleShares != null) {
            for (ArticleShare articleShare : articleShares) {
                userRefreshService.insertArticle(userId, articleShare.getArticleId());
            }
            /**更新用户推送信息*/
            if (articleShares.size() > 0)
                userRefreshService.updateLastPushTime(userId, articleShares.get(0).getShareTime());
        }

        ArrayList<ArticleWorldBrief> articleWorldBriefs = new ArrayList<ArticleWorldBrief>();
        for (ArticleShare articleShare : articleShares) {

            ArticleWorldBrief brief = new ArticleWorldBrief();

            String articleId = articleShare.getArticleId();

            /**作者的id*/
            String authorId = articleShare.getUserId();

            Article article = service.searchArticle(articleId);

            String authorName = "miko";

            /**获取的是分享的时间而不是文章编辑的时间*/
            long shareTime = articleShare.getShareTime();

            String content = article.getContent();

            String contentDecode = null;
            try {
                contentDecode = URLDecoder.decode(content, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                contentDecode = "服务器解码失败";
            }
            logger.info(contentDecode);
            String title = articleShare.getTitle();

            brief.setArticleId(articleId);
            brief.setShareTime(shareTime);
            brief.setUserId(authorId);
            brief.setTitle(title);
            brief.setUserName(authorName);

            /**内容分析*/
            ContentJson contentJsonBean = new Gson().fromJson(contentDecode, ContentJson.class);

            StringBuilder sb = new StringBuilder();

            StringBuilder previewPaths = new StringBuilder();

            for (Element e : contentJsonBean.getElementList()) {
                if (e.getElementType() == ElementTypeEnum.TEXT.getState()) {
                    sb.append(e.getContent());
                } else if (e.getElementType() == ElementTypeEnum.IMAGE.getState()) {
                    previewPaths.append("image_" + e.getIndex() + " ");

                } else if (e.getElementType() == ElementTypeEnum.GIF.getState()) {
                    previewPaths.append("gif_" + e.getIndex() + " ");

                } else if (e.getElementType() == ElementTypeEnum.VIDEO.getState()) {
                    previewPaths.append("video_" + e.getIndex() + " ");
                }
            }

            brief.setContent(sb.toString());
            brief.setPreviewPaths(previewPaths.toString());
            articleWorldBriefs.add(brief);
        }
        ArticleWorldBriefs articles = new ArticleWorldBriefs();
        articles.setArticleWorldBriefs(articleWorldBriefs);
        String returnStr = new Gson().toJson(articles);

        logger.info("returnStr: "+returnStr);

        String returnStrEncode = URLEncoder.encode(returnStr, "UTF-8");


        System.out.println("?????");
        System.out.println(returnStr);

        return returnStrEncode;

    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] myfiles,
                         HttpServletRequest request) throws IOException {

        request.setCharacterEncoding("UTF-8");

        /**获s取diary整体的Json*/
        String diaryJson = request.getParameter("diaryJson");

        logger.info("diaryJsonPost", diaryJson);
        String title = request.getParameter("title");
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
        if (title != null && !title.equals("")) {
            System.out.println(title);
            share(id, title);
            return "no synchronize upload success";
        }
        return "upload success";
    }
}
