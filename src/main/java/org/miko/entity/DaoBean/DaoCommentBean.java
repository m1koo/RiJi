package org.miko.entity.DaoBean;

/**
 * Created by Miko on 2017/9/14.
 */
public class DaoCommentBean {
    private String articleId;
    private String userId;
    private long commentTime;
    private String commentStr;

    @Override
    public String toString() {
        return "Comment{" +
                "articleId='" + articleId + '\'' +
                ", userId='" + userId + '\'' +
                ", commentTime=" + commentTime +
                ", commentStr='" + commentStr + '\'' +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentStr() {
        return commentStr;
    }

    public void setCommentStr(String commentStr) {
        this.commentStr = commentStr;
    }
}
