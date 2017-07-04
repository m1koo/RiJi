package org.miko.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Miko on 2017/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class UserLoginDaoTest {

    //注入Dao实现类依赖
    @Resource
    private UserLoginDao dao;

    @Test
    public void insert() throws Exception {
        String type = "phone";
        String account = "17811";
        dao.insertUserLoginMsg(type,account);
    }

    @Test
    /**测试当搜索不到时返回null*/
    public void search() throws Exception {
        String type = "phone";
        String account = "17fdfa8";
        String id = dao.searchUserByType(type,account);
        System.out.println("iddddd test "+id);
    }
}