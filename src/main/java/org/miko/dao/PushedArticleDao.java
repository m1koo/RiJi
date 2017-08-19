package org.miko.dao;

import org.miko.entity.PushedArticle;

import java.util.List;

/**
 * Created by Miko on 2017/8/18.
 */
public interface PushedArticleDao {
    List<PushedArticle> searchByUser(String userId);
}
