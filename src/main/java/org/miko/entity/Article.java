package org.miko.entity;

import java.util.Date;

/**
 * Created by Miko on 2017/3/7.
 */
public class Article {
    private String userId;
    private String articleId;
    private int year;
    private int month;
    private int day;
    private long editTime;
    private String location;
    private String content;
    private boolean outVisible;
    private boolean completeFlag;


    public long getEditTime() {
        return editTime;
    }

    public void setEditTime(long editTime) {
        this.editTime = editTime;
    }

    public boolean isOutVisible() {
        return outVisible;
    }

    public void setOutVisible(boolean outVisible) {
        this.outVisible = outVisible;
    }

    public boolean isCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(boolean completeFlag) {
        this.completeFlag = completeFlag;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "Article{" +
                "userId='" + userId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", editTime=" + editTime +
                ", location='" + location + '\'' +
                ", content='" + content + '\'' +
                ", outVisible=" + outVisible +
                ", completeFlag=" + completeFlag +
                '}';
    }
}
