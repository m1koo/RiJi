package org.miko.dao;

import org.apache.ibatis.annotations.Param;
import org.miko.entity.UserLoginMsg;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserLoginDao {
    UserLoginMsg searchUserById(long userId);

    UserLoginMsg searchUserByPhone(String phone);

    void updatePassword(@Param("userId") long userId,@Param("password") String password);

    void insertUserLoginMsg(@Param("phone") String phone
            , @Param("password") String password);
}
