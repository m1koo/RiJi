package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.Article;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    private ArticleDao dao;

    @Test
    public void insert() throws Exception {
        Article article = new Article();
        article.setCompleteFlag(true);
        article.setEditTime(2213414);
        article.setYear(2014);
        article.setMonth(12);
        article.setDay(30);
        article.setUserId("AN123");
        article.setArticleId("AN123_rq33131141");
        article.setLocation("123");
        article.setOutVisible(true);
        article.setContent("fafadfdafd");
        dao.insertArticle(article);
    }

    @Test
    /**测试当搜索不到时返回null*/
    public void search() throws Exception {
        String articleId = "AN123_rq331341";
        Article a = dao.searchArticle(articleId);
        System.out.println(a.toString());
    }
}