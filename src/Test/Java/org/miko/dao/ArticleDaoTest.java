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

    @Test
    public void insert() throws Exception {

        ArticleShare articleShare = new ArticleShare();
        articleShare.setArticleId("aaaaff");
        articleShare.setUserId("eee");
        articleShare.setShareTime(1111111);
        articleShare.setTitle("gege");

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