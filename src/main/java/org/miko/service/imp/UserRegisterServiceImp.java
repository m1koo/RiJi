package org.miko.service.imp;

import org.miko.dao.UserLoginDao;
import org.miko.dao.UserMsgDao;
import org.miko.dto.LoginExcution;
import org.miko.dto.RegisterExcution;
import org.miko.entity.UserLoginMsg;
import org.miko.enums.LoginStateEnum;
import org.miko.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Miko on 2017/3/6.
 */
@Service("registerService")
public class UserRegisterServiceImp implements UserRegisterService {

    @Autowired
    UserLoginDao userLoginDao;
    @Autowired
    UserMsgDao userMsgDao;


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


    public UserLoginMsg searchUserByPhone(String phone) {
        return userLoginDao.searchUserByPhone(phone);
    }

    public LoginExcution register(String phone, String nickName, String password) {
        userLoginDao.insertUserLoginMsg(phone, password);

        //找到id
        UserLoginMsg userLoginMsg = userLoginDao.searchUserByPhone(phone);

        userMsgDao.insertNickName(userLoginMsg.getUserId(), nickName);

        return new LoginExcution(LoginStateEnum.SUCCESS.getState(),
                LoginStateEnum.SUCCESS.getStateInfo(), getMd5(userLoginMsg.getUserId()));
    }

    public LoginExcution modifyPass(String phone, String password) {
        long id = userLoginDao.searchUserByPhone(phone).getUserId();
        userLoginDao.updatePassword(id, password);
        return new LoginExcution(LoginStateEnum.SUCCESS.getState(),
                LoginStateEnum.SUCCESS.getStateInfo(), getMd5(id));
    }
}