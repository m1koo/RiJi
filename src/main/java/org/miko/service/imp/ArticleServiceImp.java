package org.miko.service.imp;

import org.miko.dao.ArticleDao;
import org.miko.dao.ArticleShareDao;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;
import org.miko.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Miko on 2017/3/7.
 */
@Service("articleService")
public class ArticleServiceImp implements ArticleService {


    @Autowired
    ArticleDao articleDao;

    @Autowired
    ArticleShareDao articleShareDao;


    public String insertArticle(Article article) {
        articleDao.insertArticle(article);
        return "success";
    }

    public String insertArticleShare(ArticleShare articleShare) {
        articleShareDao.insertArticleShare(articleShare);

        return "success";
    }


    public Article searchArticle(String articleId) {
        Article article = articleDao.searchArticle(articleId);
        return article;
    }
}
