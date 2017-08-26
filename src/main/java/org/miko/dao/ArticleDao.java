package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.Article;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleDao {
    Article searchArticle(@Param("articleId") String articleId);
    void insertArticle(Article article);
    List<String> searchAllArticleIds(@Param("userId") String userId);
//    void updateArticle(Article article);
}
