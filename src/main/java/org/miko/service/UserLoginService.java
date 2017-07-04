package org.miko.service;

import org.miko.dto.LoginExcution;
import org.miko.dto.RegisterExcution;
import org.miko.dto.Result;
import org.miko.entity.UserLoginMsg;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserLoginService {
    /**根据不同的账号查找id*/
    String getIdByAccount(String type,String account);
    /**添加新的id并返回id*/
    String addIdByAccount(String type,String account);
}
