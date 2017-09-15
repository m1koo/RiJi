package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.DaoBean.DaoCommentBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Miko on 2017/7/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class CommentDaoTest {

    //注入Dao实现类依赖
    @Resource
    private org.miko.dao.CommentDao dao;

    @Test
    public void insertArticle() {

        DaoCommentBean comment = new DaoCommentBean();
        comment.setUserId("miko");
        comment.setArticleId("article");
        comment.setCommentTime(12213);
        comment.setCommentStr("fdfasfdsf");
        dao.insertComment(comment);
    }

    @Test
    public void searchArticle() throws Exception {

        List<DaoCommentBean> articleShares = dao.searchByUserId("miko");

        for(DaoCommentBean a:articleShares){
            System.out.println(a);
        }
    }


    @Test
    /**测试当搜索不到时返回null*/
    public void searchu() throws Exception {
        String articleId = "article";
        List<DaoCommentBean> a = dao.searchByArticleId(articleId);
        System.out.println(a.toString());
    }
}