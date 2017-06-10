package org.miko.controller;

import org.miko.dto.LoginExcution;
import org.miko.entity.UserLoginMsg;
import org.miko.enums.LoginStateEnum;
import org.miko.service.UserLoginService;
import org.miko.service.UserRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Miko on 2017/3/21.
 */

@Controller
public class RegisterController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("registerService")
    UserRegisterService service;

    @ResponseBody
    @RequestMapping(value = "/check_phone",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    boolean isPhoneRegisted(@RequestParam("phone") String phone) {

        UserLoginMsg userLoginMsg = service.searchUserByPhone(phone);
        if (userLoginMsg == null) {
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    LoginExcution register(@RequestParam("phone") String phone,
                           @RequestParam("nick_name") String nickName,
                           @RequestParam("password") String password) {
        return service.register(phone, nickName, password);
    }


    @ResponseBody
    @RequestMapping(value = "/modify_pass",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    LoginExcution modify(@RequestParam("phone") String phone,
                         @RequestParam("password") String password) {
        LoginExcution loginExcution = service.modifyPass(phone, password);
        return loginExcution;
    }

}
