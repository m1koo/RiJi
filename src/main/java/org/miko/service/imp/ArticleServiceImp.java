package org.miko.service.imp;

import com.vdurmont.emoji.EmojiParser;
import org.miko.dao.ArticleDao;
import org.miko.dao.ArticleShareDao;
import org.miko.dao.PushedArticleDao;
import org.miko.dao.UserPushArticlesDao;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;
import org.miko.entity.UserPushArticles;
import org.miko.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
@Service("articleService")
public class ArticleServiceImp implements ArticleService {


    @Autowired
    ArticleDao articleDao;

    @Autowired
    ArticleShareDao articleShareDao;


    @Autowired
    PushedArticleDao pushedArticleDao;

    @Autowired
    UserPushArticlesDao userPushArticlesDao;


    public String insertArticleShare(ArticleShare articleShare) {
        articleShareDao.insertArticleShare(articleShare);


        String unEncodeContent = articleShare.getTitle();

        System.out.println(unEncodeContent);
        String encodeContent = EmojiParser.parseToAliases(unEncodeContent);

        articleShare.setTitle(encodeContent);

        return "success";
    }

    public List<String> getUserAllArticles(String userId) {
        return articleDao.searchAllArticleIds(userId);
    }

    /**
     * myslsql不支持emoji 使用转码
     */
    public String insertArticle(Article article) {

        String unEncodeContent = article.getContent();
        String encodeContent = EmojiParser.parseToAliases(unEncodeContent);
        article.setContent(encodeContent);

        articleDao.insertArticle(article);

        return "success";
    }


    public Article searchArticle(String articleId) {
        Article article = articleDao.searchArticle(articleId);

        if (article == null) {
            return null;
        }
        String unDecodeContent = article.getContent();
        String decodeContent = EmojiParser.parseToUnicode(unDecodeContent);
        article.setContent(decodeContent);
        return article;
    }

    /**
     * 1.用户第一次获取推送
     * 2.用户正常打开自动刷新文章
     */
    public List<ArticleShare> getNewestArticles(String userId, int maxNum) {
        UserPushArticles userPushArticlesInfo = userPushArticlesDao
                .getUserPushArticles(userId);
        /**如果为null则说明为新用户还未曾推送，则直接推送指定数目的文章*/
        List<ArticleShare> articleShareList = null;
        if (userPushArticlesInfo == null) {
            articleShareList = articleShareDao.getUnPushArticlesByTime(0, maxNum);
        } else {
            articleShareList = articleShareDao.getUnPushArticlesByTime(userPushArticlesInfo.getLastTime(),
                    maxNum);
        }

        return articleShareList;
    }

    public List<ArticleShare> getRefreshArticles(String userId, int maxNum) {

        UserPushArticles userPushArticlesInfo = userPushArticlesDao
                .getUserPushArticles(userId);

        ArrayList<ArticleShare> result = (ArrayList<ArticleShare>) articleShareDao
                .getUnPushArticlesByTime(userPushArticlesInfo.getLastTime(), maxNum);
        /**如果新文章的数目不足，通过filter获取，并添加至中*/
        if (result.size() < maxNum) {
            ArrayList<ArticleShare> r = (ArrayList<ArticleShare>) articleShareDao.getUnPushArticlesByFilter(userId,
                    maxNum - result.size());
            result.addAll(r);
        }

        return result;
    }

}
