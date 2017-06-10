package org.miko.entity;

import java.util.Date;

/**
 * Created by Miko on 2017/3/7.
 */
public class Article {
    private long userId;
    private String content;
    private long editTime;
    private long lastEditTime;
    private boolean outVisible;

    /**数据库搜索结果中只有一个editTime字段*/
    public Article(Long userId, String content, Long editTime, Boolean outVisible) {
        this.userId = userId;
        this.content = content;
        this.editTime = editTime;
        this.outVisible = outVisible;
    }

    public Article(long userId, String content, long editTime
            , long lastEditTime, boolean outVisible) {
        this.userId = userId;
        this.content = content;
        this.editTime = editTime;
        this.lastEditTime = lastEditTime;
        this.outVisible = outVisible;
    }

    @Override
    public String toString() {
        return "Article{" +
                "userId=" + userId +
                ", content='" + content + '\'' +
                ", editTime=" + editTime +
                ", lastEditTime=" + lastEditTime +
                ", outVisible=" + outVisible +
                '}';
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getEditTime() {
        return editTime;
    }

    public void setEditTime(long editTime) {
        this.editTime = editTime;
    }

    public long getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(long lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public boolean isOutVisible() {
        return outVisible;
    }

    public void setOutVisible(boolean outVisible) {
        this.outVisible = outVisible;
    }
}
