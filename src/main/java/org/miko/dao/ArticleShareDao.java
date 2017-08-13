package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleShareDao {

    ArticleShare searchByArticleId(@Param("articleId") String articleId);

    List<ArticleShare> searchArticlesByUser(@Param("userId") String userId);

    void insertArticleShare(ArticleShare articleShare);
}
