package org.miko.service;

import org.miko.dto.LoginExcution;
import org.miko.dto.RegisterExcution;
import org.miko.dto.Result;
import org.miko.entity.UserLoginMsg;

/**
 * Created by Miko on 2017/3/6.
 */
public interface UserLoginService {
    UserLoginMsg findUserById(long id);
    LoginExcution login(String phone);

    LoginExcution login(String userName, String password);
}
