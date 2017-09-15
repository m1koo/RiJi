package org.miko.service.imp;

import org.miko.entity.DaoBean.DaoCommentBean;
import org.miko.entity.DtoBean.DtoCommentBean;
import org.miko.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miko on 2017/3/7.
 */
@Service("commentService")
public class CommentServiceImp implements CommentService {


    @Autowired
    org.miko.dao.CommentDao dao;


    public List<DaoCommentBean> getUserAllComment(String userId) {
        return dao.searchByUserId(userId);
    }

    public String insertComment(DaoCommentBean comment) {
        dao.insertComment(comment);
        return "success";
    }

    public List<DtoCommentBean> getArticleAllComment(String articleId) {
        List<DaoCommentBean> daoCommentBeanList = dao.searchByArticleId(articleId);

        List<DtoCommentBean> dtoCommentBeanList = new ArrayList<DtoCommentBean>();

        for (DaoCommentBean daoCommentBean : daoCommentBeanList) {
            DtoCommentBean dtoCommentBean = new DtoCommentBean();

            dtoCommentBean.setUserId(daoCommentBean.getUserId());
            dtoCommentBean.setCommentStr(daoCommentBean.getCommentStr());
            dtoCommentBean.setCommentTime(daoCommentBean.getCommentTime());
            dtoCommentBean.setArticleId(daoCommentBean.getArticleId());

            //todo 获取用户名
            dtoCommentBean.setUserName("miko");
            dtoCommentBeanList.add(dtoCommentBean);
        }


        return dtoCommentBeanList;
    }
}
