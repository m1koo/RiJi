package org.miko.controller;

import org.miko.dto.LoginExcution;
import org.miko.dto.Result;
import org.miko.service.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Scanner;

/**
 * Created by Miko on 2017/3/21.
 */

@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("loginService")
    UserLoginService service;

    @ResponseBody
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    LoginExcution login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        LoginExcution loginExcution = service.login(userName, password);

        return loginExcution;
    }

    @ResponseBody
    @RequestMapping(value = "/phone_login",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    LoginExcution phoneLogin(@RequestParam("phone") String phone) {
        LoginExcution loginExcution = service.login(phone);
        return loginExcution;
    }


}
