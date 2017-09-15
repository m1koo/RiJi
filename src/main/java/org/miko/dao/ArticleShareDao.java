package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.DaoBean.DaoArticleSharedBean;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleShareDao {

    DaoArticleSharedBean searchByArticleId(@Param("articleId") String articleId);

    List<DaoArticleSharedBean> searchArticlesByUser(@Param("userId") String userId);

    void insertArticleShare(DaoArticleSharedBean articleShare);

    List<DaoArticleSharedBean> getUnPushArticlesByTime(@Param("lastTime") long lastTime, @Param("maxNum") int maxNum);

    List<DaoArticleSharedBean> getUnPushArticlesByFilter(@Param("userId") String userId
            , @Param("maxNum") int maxNum);

}
