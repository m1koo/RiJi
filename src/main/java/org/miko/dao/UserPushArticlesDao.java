package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.Article;
import org.miko.entity.UserPushArticles;

/**
 * Created by Miko on 2017/3/7.
 */
public interface UserPushArticlesDao {
    UserPushArticles getUserPushArticles(@Param("userId") String userId);

}
