package org.miko.service.imp;

import org.miko.Config.Config;
import org.miko.dao.UserLoginDao;
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

    public String getIdByAccount(String type, String account) {
        String id = userLoginDao.searchUserByType(type, account);
        if (id == null) {
            id = Config.anAccount;
        }
        return id;
    }

    public String addIdByAccount(String type, String account) {
        userLoginDao.insertUserLoginMsg(type, account);
        String id = userLoginDao.searchUserByType(type, account);
        return id;
    }
}
