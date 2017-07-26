package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.Article;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleDao {
    Article searchArticle(@Param("articleId") String articleId);
    void insertArticle(Article article);
//    void updateArticle(Article article);
}
