package org.miko.entity;

import java.util.List;

/**
 * Created by Miko on 2017/8/17.
 */
public class UserPushArticles {

    private String userId;
    private long lastTime;
    private List<PushedArticle> pushedArticles;

    public List<PushedArticle> getPushedArticles() {
        return pushedArticles;
    }

    @Override
    public String toString() {
        return "UserPushArticles{" +
                "userId='" + userId + '\'' +
                ", lastTime=" + lastTime +
                ", pushedArticles=" + pushedArticles +
                '}';
    }

    public void setPushedArticles(List<PushedArticle> pushedArticles) {
        this.pushedArticles = pushedArticles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }
}
