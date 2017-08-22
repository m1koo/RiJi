package org.miko.service.imp;

import org.miko.dao.PushedArticleDao;
import org.miko.dao.UserPushArticlesDao;
import org.miko.entity.UserPushArticles;
import org.miko.service.UserRefreshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Miko on 2017/8/21.
 */
@Service("userRefreshService")

public class UserRefreshServiceImp implements UserRefreshService {

    @Autowired
    PushedArticleDao dao;

    @Autowired
    UserPushArticlesDao userPushArticlesDao;

    public String insertArticle(String userId, String articleId) {
        dao.insertPushedArticle(userId, articleId);
        return "success";
    }

    public void updateLastPushTime(String userId, long time) {
        UserPushArticles userPushArticles = userPushArticlesDao.getUserPushArticles(userId);
        if (userPushArticles == null) {
            userPushArticlesDao.insertUserPushArticle(userId, time);
        } else {
            if (userPushArticles.getLastTime() < time)
                userPushArticlesDao.updateUserPushArticles(userId, time);
        }
    }


}
