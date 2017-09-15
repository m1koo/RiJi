package org.miko.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserMsgDao {
    void insertNickName(@Param("userId") long userId
            , @Param("nickName") String nickName);
}
