package org.miko.service.imp;

import org.miko.dao.UserLoginDao;
import org.miko.dto.LoginExcution;
import org.miko.dto.RegisterExcution;
import org.miko.dto.Result;
import org.miko.entity.UserLoginMsg;
import org.miko.enums.LoginStateEnum;
import org.miko.enums.RegisterStateEnum;
import org.miko.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Miko on 2017/3/6.
 */
@Service("loginService")
public class UserLoginServiceImp implements UserLoginService {

    @Autowired
    UserLoginDao userLoginDao;

    public UserLoginMsg findUserById(long id) {
        return userLoginDao.searchUserById(id);
    }

    /**
     * 用于混淆md5
     */
    private final String slat = "rewrljlsfjkaetb" +
            ",jdauef)(**)^$#@@!!#%%63sdfad,%^$^&^*&*jsfahsdfafhadsfadksf";

    private String getMd5(long userId) {
        String base = userId + "/" + slat;
        String md5 = org.springframework.util.DigestUtils
                .md5DigestAsHex(base.getBytes());
        return md5;
    }

    public LoginExcution login(String phone) {
        LoginExcution loginExcution;

        UserLoginMsg userLoginMsg = null;
        userLoginMsg = userLoginDao.searchUserByPhone(phone);

        loginExcution = new LoginExcution(LoginStateEnum.SUCCESS.getState(),
                LoginStateEnum.SUCCESS.getStateInfo(), getMd5(userLoginMsg.getUserId()));
        return loginExcution;
    }

    public LoginExcution login(String userName, String password) {
        LoginExcution loginExcution;

        UserLoginMsg userLoginMsg = null;
        if (userName.length() == 11) {
            userLoginMsg = userLoginDao.searchUserByPhone(userName);
        }
        if (userLoginMsg == null) {
            loginExcution = new LoginExcution(LoginStateEnum.NO_USER.getState(),
                    LoginStateEnum.NO_USER.getStateInfo());
            return loginExcution;
        } else {
            //登录成功
            if (userLoginMsg.getPassword().equals(password)) {
                loginExcution = new LoginExcution(LoginStateEnum.SUCCESS.getState(),
                        LoginStateEnum.SUCCESS.getStateInfo(), getMd5(userLoginMsg.getUserId()));
                return loginExcution;
            } else {
                loginExcution = new LoginExcution(LoginStateEnum.ERROR_PASSWORD.getState(),
                        LoginStateEnum.ERROR_PASSWORD.getStateInfo());
                return loginExcution;
            }
        }
    }
}
