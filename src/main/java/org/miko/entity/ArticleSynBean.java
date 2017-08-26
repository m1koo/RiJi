package org.miko.entity;

import java.util.ArrayList;

/**
 * Created by Miko on 2017/8/26.
 */
public class ArticleSynBean {
    ArrayList<String> prepareDownloadArticleIds;
    ArrayList<String> prepareUploadArticleIds;

    public ArrayList<String> getPrepareDownloadArticleIds() {
        return prepareDownloadArticleIds;
    }

    public void setPrepareDownloadArticleIds(ArrayList<String> prepareDownloadArticleIds) {
        this.prepareDownloadArticleIds = prepareDownloadArticleIds;
    }

    public ArrayList<String> getPrepareUploadArticleIds() {
        return prepareUploadArticleIds;
    }

    public void setPrepareUploadArticleIds(ArrayList<String> prepareUploadArticleIds) {
        this.prepareUploadArticleIds = prepareUploadArticleIds;
    }
}
