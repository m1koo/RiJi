package org.miko.service;

import org.miko.entity.DaoBean.DaoCommentBean;
import org.miko.entity.DtoBean.DtoCommentBean;

import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
public interface CommentService {

    List<DaoCommentBean> getUserAllComment(String userId);

    String insertComment(DaoCommentBean comment);

    List<DtoCommentBean> getArticleAllComment(String articleId);
}
