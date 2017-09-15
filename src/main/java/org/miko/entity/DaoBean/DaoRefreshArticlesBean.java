package org.miko.entity.DaoBean;

/**
 * Created by Miko on 2017/8/17.
 */
public class DaoRefreshArticlesBean {

    @Override
    public String toString() {
        return "PushedArticle{" +
                "userId='" + userId + '\'' +
                ", articleId='" + articleId + '\'' +
                '}';
    }

    private String userId;
    private String articleId;

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
}
