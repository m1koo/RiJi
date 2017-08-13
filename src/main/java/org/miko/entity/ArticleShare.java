package org.miko.entity;

/**
 * Created by Miko on 2017/3/7.
 */
public class ArticleShare {
    private String userId;
    private String articleId;
    private long shareTime;
    private String title;

    @Override
    public String toString() {
        return "ArticleShare{" +
                "userId='" + userId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", shareTime=" + shareTime +
                ", title='" + title + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public long getShareTime() {
        return shareTime;
    }

    public void setShareTime(long shareTime) {
        this.shareTime = shareTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
