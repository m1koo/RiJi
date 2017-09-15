package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.DaoBean.DaoUserLastRefreshBean;

/**
 * Created by Miko on 2017/3/7.
 */
public interface UserPushArticlesDao {

    DaoUserLastRefreshBean getUserPushArticles(@Param("userId") String userId);

    void updateUserPushArticles(@Param("userId") String userId, @Param("lastTime") long lastTime);

    void insertUserPushArticle(@Param("userId") String userId, @Param("lastTime") long lastTime);
}
