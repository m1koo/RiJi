package org.miko.entity.DtoBean;

import org.miko.entity.DtoBean.DtoArticleSharedBriefBean;

import java.util.ArrayList;

/**
 * Created by Miko on 2017/8/19.
 */
public class DtoArticleSharedBriefList {
    private ArrayList<DtoArticleSharedBriefBean> articleWorldBriefs;

    @Override
    public String toString() {
        return "ArticleWorldBriefs{" +
                "articleWorldBriefs=" + articleWorldBriefs +
                '}';
    }

    public ArrayList<DtoArticleSharedBriefBean> getArticleWorldBriefs() {
        return articleWorldBriefs;
    }

    public void setArticleWorldBriefs(ArrayList<DtoArticleSharedBriefBean> articleWorldBriefs) {
        this.articleWorldBriefs = articleWorldBriefs;
    }
}
