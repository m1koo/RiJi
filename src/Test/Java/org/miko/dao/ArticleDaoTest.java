package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.Article;
import org.miko.entity.ArticleShare;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

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
    public void insertArticle(){
        Article article = new Article();
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
//
//        List<ArticleShare> articleShares = dao.searchArticlesByTime("eee",1111112,5);
//
//        for(ArticleShare a:articleShares){
//            System.out.println(a);
//        }
    }


    @Test
    public void insert() throws Exception {

        ArticleShare articleShare = new ArticleShare();
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
        ArticleShare a = dao.searchByArticleId(articleId);
        System.out.println(a.toString());
    }

    @Test
    /**测试当搜索不到时返回null*/
    public void searchu() throws Exception {
        String userId = "eee";
        List<ArticleShare> a = dao.searchArticlesByUser(userId);
        System.out.println(a.toString());
    }
}