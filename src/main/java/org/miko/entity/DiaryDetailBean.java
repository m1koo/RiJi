package org.miko.entity;

/**
 * Created by Miko on 2017/2/12.
 */

public class DiaryDetailBean {
    private String id;
    private int year;
    private int month;
    private int day;
    private long date;
    private String location;
    private String diaryJson;

    private boolean completeFlag;

    public boolean isCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(boolean completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDiaryJson() {
        return diaryJson;
    }

    public void setDiaryJson(String diaryJson) {
        this.diaryJson = diaryJson;
    }
}
