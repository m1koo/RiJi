package org.miko.service;


import org.miko.dto.LoginExcution;
import org.miko.entity.UserLoginMsg;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserRegisterService {

    UserLoginMsg searchUserByPhone(String phone);
    LoginExcution register(String phone, String nickName, String password);
    public LoginExcution modifyPass(String phone,String password);

}
