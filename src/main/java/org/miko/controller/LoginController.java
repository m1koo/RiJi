package org.miko.controller;

import com.google.gson.Gson;
import com.sun.tools.corba.se.idl.StringGen;
import org.miko.Config.Config;
import org.miko.dto.LoginExcution;
import org.miko.dto.Result;
import org.miko.enums.LoginStateEnum;
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
            method = RequestMethod.POST)
    String loginByAccount(@RequestParam("type") String type,
                                 @RequestParam("account") String account) {

        String id = service.getIdByAccount(type, account);

        int loginState = LoginStateEnum.ID_HAD_CREATE.getState();

        if (id.equals(Config.anAccount)) {
            id = service.addIdByAccount(type, account);
            loginState = LoginStateEnum.CREATE_NEW_ID.getState();
        }

        LoginExcution e = new LoginExcution(id, loginState);

        return new Gson().toJson(e);
    }
}
