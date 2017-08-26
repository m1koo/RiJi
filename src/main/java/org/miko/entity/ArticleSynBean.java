package org.miko.entity;

import java.util.ArrayList;

/**
 * Created by Miko on 2017/8/26.
 */
public class ArticleSynBean {
    ArrayList<Article> downloadArticles;
    ArrayList<String> prepareUploadArticleIds;

    public ArrayList<Article> getDownloadArticles() {
        return downloadArticles;
    }

    public void setDownloadArticles(ArrayList<Article> downloadArticles) {
        this.downloadArticles = downloadArticles;
    }

    public ArrayList<String> getPrepareUploadArticleIds() {
        return prepareUploadArticleIds;
    }

    public void setPrepareUploadArticleIds(ArrayList<String> prepareUploadArticleIds) {
        this.prepareUploadArticleIds = prepareUploadArticleIds;
    }
}
