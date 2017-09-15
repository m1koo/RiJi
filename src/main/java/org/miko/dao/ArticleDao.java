package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.DaoBean.DaoArticleBean;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleDao {
    DaoArticleBean searchArticle(@Param("articleId") String articleId);
    void insertArticle(DaoArticleBean article);
    List<String> searchAllArticleIds(@Param("userId") String userId);
//    void updateArticle(Article article);
}
