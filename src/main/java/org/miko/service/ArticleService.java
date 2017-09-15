package org.miko.service;

import org.miko.entity.DaoBean.DaoArticleBean;
import org.miko.entity.DaoBean.DaoArticleSharedBean;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleService {

    List<String> getUserAllArticles(String userId);

    String insertArticle(DaoArticleBean article);

    String insertArticleShare(DaoArticleSharedBean articleShare);

    DaoArticleBean searchArticle(String articleId);

    List<DaoArticleSharedBean> getNewestArticles(String userId, int maxNum);

    List<DaoArticleSharedBean> getRefreshArticles(String userId, int maxNum);

}
