package org.miko.service;

import org.miko.dto.Result;
import org.miko.dto.UploadExcution;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleService {

    List<String> getUserAllArticles(String userId);

    String insertArticle(Article article);

    String insertArticleShare(ArticleShare articleShare);

    Article searchArticle(String articleId);

    List<ArticleShare> getNewestArticles(String userId,int maxNum);

    List<ArticleShare> getRefreshArticles(String userId,int maxNum);

}
