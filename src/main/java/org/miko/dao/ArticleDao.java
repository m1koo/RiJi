package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.Article;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleDao {
    Article searchArticle(@Param("userId") long userId,@Param("editTime") long editTime);
    void insertArticle(Article article);
    void updateArticle(Article article);
    void updatePermission(@Param("userId") long userId,@Param("editTime") long editTime
            ,@Param("outVisible") boolean outVisible);
}
