package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.DaoBean.DaoArticleBean;
import org.miko.entity.DaoBean.DaoArticleSharedBean;
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

public class ArticleDaoTest {

    //注入Dao实现类依赖
    @Resource
    private ArticleShareDao dao;

    @Resource
    private ArticleDao articleDao;

    @Test
    public void insertArticle() {
        DaoArticleBean article = new DaoArticleBean();
        article.setEditTime(111);
        article.setOutVisible(false);
        article.setArticleId("fadf");
        article.setContent("哈发发的");
        article.setLocation("11");

        article.setDay(1);
        article.setMonth(1);
        article.setYear(20189);
        article.setUserId("fasdfdasfa");
        articleDao.insertArticle(article);
    }

    @Test
    public void searchArticle() throws Exception {

        List<String> articleShares = articleDao.searchAllArticleIds("AN123");

        for(String a:articleShares){
            System.out.println(a);
        }
    }


    @Test
    public void insert() throws Exception {

        DaoArticleSharedBean articleShare = new DaoArticleSharedBean();
        articleShare.setArticleId("aafddfgadaaff");
        articleShare.setUserId("eee");
        articleShare.setShareTime(11111111);
        articleShare.setTitle("gjjjjjjjjege");

        dao.insertArticleShare(articleShare);
    }

    @Test
    /**测试当搜索不到时返回null*/
    public void search() throws Exception {
        String articleId = "aaaa";
        DaoArticleSharedBean a = dao.searchByArticleId(articleId);
        System.out.println(a.toString());
    }

    @Test
    /**测试当搜索不到时返回null*/
    public void searchu() throws Exception {
        String userId = "eee";
        List<DaoArticleSharedBean> a = dao.searchArticlesByUser(userId);
        System.out.println(a.toString());
    }
}