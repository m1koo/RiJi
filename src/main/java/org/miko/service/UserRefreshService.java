package org.miko.service;

import org.miko.entity.Article;
import org.miko.entity.ArticleShare;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface UserRefreshService {

    String insertArticle(String userId, String articleId);

    void updateLastPushTime(String userId,long time);
}
