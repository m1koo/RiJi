package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.ArticleShare;
import org.miko.entity.PushedArticle;
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

public class ArticlePushDaoTest {

    //注入Dao实现类依赖
    @Resource
    private PushedArticleDao dao;


    @Test
    public void searchArticle() throws Exception {

        List<PushedArticle> article = dao.searchByUser("miko");

        for (PushedArticle a : article) {
            System.out.println(a);
        }
    }
}