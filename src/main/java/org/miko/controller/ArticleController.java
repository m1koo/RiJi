package org.miko.controller;

import com.google.gson.Gson;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.io.FileUtils;
import org.miko.entity.ArticleCotent.ContentJson;
import org.miko.entity.ArticleCotent.Element;
import org.miko.entity.DaoBean.DaoArticleBean;
import org.miko.entity.DaoBean.DaoArticleSharedBean;
import org.miko.entity.DaoBean.DaoCommentBean;
import org.miko.entity.DtoBean.*;
import org.miko.enums.ElementTypeEnum;
import org.miko.service.ArticleService;
import org.miko.service.CommentService;
import org.miko.service.UserRefreshService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


@Controller
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    @Qualifier("commentService")
    CommentService commentService;


    @Autowired
    @Qualifier("articleService")
    ArticleService service;


    @Autowired
    @Qualifier("userRefreshService")
    UserRefreshService userRefreshService;


    @RequestMapping(value = "/add_comment", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String addComment(HttpServletRequest request) throws IOException {

        String articleId = request.getParameter("articleId");

        String userId = request.getParameter("userId");

        String commentStr = request.getParameter("commentStr");

        DaoCommentBean comment = new DaoCommentBean();
        comment.setArticleId(articleId);
        comment.setCommentStr(commentStr);
        comment.setUserId(userId);

        commentService.insertComment(comment);

        return "success";
    }

    @RequestMapping(value = "/get_article_comments",
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getArticleComments(HttpServletRequest request) throws IOException {

        String articleId = request.getParameter("articleId");

        List<DtoCommentBean> comments = commentService.getArticleAllComment(articleId);

        DtoCommentList commentList = new DtoCommentList();

        commentList.setCommentList(comments);

        return new Gson().toJson(commentList);
    }

    @RequestMapping(value = "/mylove", method = RequestMethod.GET)
    public String list(Model model) {
        return "mylove";
    }

    @RequestMapping(value = "/get_article", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getArticle(HttpServletRequest request) throws IOException {

        String articleId = request.getParameter("articleId");

        DaoArticleBean article = service.searchArticle(articleId);

        String a = new Gson().toJson(article);

        return a;

    }

    @RequestMapping(value = "/syn")
    @ResponseBody
    public String syn(HttpServletRequest request) throws IOException {


        /**获s取diary整体的Json*/
        String articles = request.getParameter("articles");

        String userId = request.getParameter("userId");

        String[] articleArray = articles.split(" ");

        List<String> localArticles = new ArrayList<String>();

        localArticles.addAll(Arrays.asList(articleArray));

        List<String> localArticlesTemp = new ArrayList<String>();

        localArticlesTemp.addAll(localArticles);

        List<String> serviceArticles = service.getUserAllArticles(userId);

        /**差集*/
        localArticles.removeAll(serviceArticles);

        serviceArticles.removeAll(localArticlesTemp);

        DtoArticleSynBean articleSynBean = new DtoArticleSynBean();

        articleSynBean.setPrepareDownloadArticleIds(serviceArticles);

        articleSynBean.setPrepareUploadArticleIds(localArticles);

        String returnStr = new Gson().toJson(articleSynBean);

        logger.info(returnStr);

        return returnStr;
    }

    @RequestMapping(value = "/share")
    @ResponseBody
    public String share(@RequestParam("articleId") String id, @RequestParam("title") String title) {
        DaoArticleBean article = service.searchArticle(id);
        if (article == null) {
            return "NoArticle";
        } else {
            DaoArticleSharedBean articleShare = new DaoArticleSharedBean();
            articleShare.setTitle(title);
            articleShare.setUserId(id.split("_")[0]);
            articleShare.setArticleId(id);
            articleShare.setShareTime(new Date().getTime());
            service.insertArticleShare(articleShare);
            return "Success";
        }
    }


    @RequestMapping(value = "/push_articles", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String push(@RequestParam("userId") String userId,
                       @RequestParam("isRefresh") boolean isRefresh) throws UnsupportedEncodingException {

        List<DaoArticleSharedBean> articleShares;
        /***/

        if (isRefresh) {
            articleShares = service.getRefreshArticles(userId, 5);
            System.out.println("articleShares  " + articleShares.toString());

        } else {
            articleShares = service.getNewestArticles(userId, 5);
        }

        /**推送列表插入*/
        if (articleShares != null) {
            for (DaoArticleSharedBean articleShare : articleShares) {
                userRefreshService.insertArticle(userId, articleShare.getArticleId());
            }
            /**更新用户推送信息*/
            if (articleShares.size() > 0)
                userRefreshService.updateLastPushTime(userId, articleShares.get(0).getShareTime());
        }

        ArrayList<DtoArticleSharedBriefBean> articleWorldBriefs = new ArrayList<DtoArticleSharedBriefBean>();
        for (DaoArticleSharedBean articleShare : articleShares) {

            DtoArticleSharedBriefBean brief = new DtoArticleSharedBriefBean();

            String articleId = articleShare.getArticleId();

            /**作者的id*/
            String authorId = articleShare.getUserId();

            DaoArticleBean article = service.searchArticle(articleId);

            String authorName = "miko";

            /**获取的是分享的时间而不是文章编辑的时间*/
            long shareTime = articleShare.getShareTime();

            String contentDecode = article.getContent();

            String title = articleShare.getTitle();

            String decodeTitle = EmojiParser.parseToUnicode(title);
            brief.setArticleId(articleId);
            brief.setShareTime(shareTime);
            brief.setUserId(authorId);
            brief.setTitle(decodeTitle);
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
        DtoArticleSharedBriefList articles = new DtoArticleSharedBriefList();
        articles.setArticleWorldBriefs(articleWorldBriefs);
        String returnStr = new Gson().toJson(articles);

        return returnStr;

    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] myfiles,
                         HttpServletRequest request) throws IOException {

        /**获s取diary整体的Json*/
        String diaryJson = request.getParameter("diaryJson");

        System.out.println(diaryJson);

        String title = request.getParameter("title");
        /**转化为obj*/
        DaoArticleBean diaryObj = new Gson().fromJson(diaryJson, DaoArticleBean.class);

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

            oldFile.createNewFile();

            FileUtils.writeByteArrayToFile(oldFile, f.getBytes());

        }

        /**将Diary的整体OBJ  DiaryJson -> Article -> db */
        service.insertArticle(diaryObj);
        if (title != null && !title.equals("")) {
            share(id, title);
            return "no synchronize upload success";
        }
        return "upload success";
    }
}
