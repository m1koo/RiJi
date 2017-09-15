package org.miko.service;


import org.miko.dto.LoginExcution;
import org.miko.entity.UserLoginMsgBean;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserRegisterService {

    UserLoginMsgBean searchUserByPhone(String phone);
    LoginExcution register(String phone, String nickName, String password);
    public LoginExcution modifyPass(String phone,String password);

}
