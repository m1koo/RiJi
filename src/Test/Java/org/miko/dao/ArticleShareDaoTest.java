package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.miko.entity.DaoBean.DaoArticleSharedBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by Miko on 2017/8/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class ArticleShareDaoTest {

    //注入Dao实现类依赖
    @Resource
    private ArticleShareDao dao;


    @Test
    public void searchArticle() throws Exception {

        List<DaoArticleSharedBean> userPushArticles = dao.getUnPushArticlesByFilter("miko",5);

        System.out.print(userPushArticles);
    }

}