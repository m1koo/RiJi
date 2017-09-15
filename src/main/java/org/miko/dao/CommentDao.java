package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.DaoBean.DaoCommentBean;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface CommentDao {
    List<DaoCommentBean> searchByArticleId(@Param("articleId") String articleId);
    void insertComment(DaoCommentBean comment);
    List<DaoCommentBean> searchByUserId(@Param("userId") String userId);
//    void updateArticle(Article article);
}
