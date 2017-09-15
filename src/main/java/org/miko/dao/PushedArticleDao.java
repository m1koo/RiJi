package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.DaoBean.DaoRefreshArticlesBean;

import java.util.List;

/**
 * Created by Miko on 2017/8/18.
 */
public interface PushedArticleDao {
    List<DaoRefreshArticlesBean> searchByUser(String userId);

    void insertPushedArticle(@Param("userId") String userId,
                             @Param("articleId") String articleId);

}
