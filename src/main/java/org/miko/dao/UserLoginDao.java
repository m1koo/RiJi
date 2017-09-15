package org.miko.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserLoginDao {


    String searchUserByType(@Param("type") String type,@Param("account") String account);

    void insertUserLoginMsg(@Param("type") String type
            , @Param("account") String account);
}
