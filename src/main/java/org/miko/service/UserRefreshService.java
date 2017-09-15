package org.miko.service;

/**
 * Created by Miko on 2017/3/7.
 */
public interface UserRefreshService {

    String insertArticle(String userId, String articleId);

    void updateLastPushTime(String userId,long time);
}
