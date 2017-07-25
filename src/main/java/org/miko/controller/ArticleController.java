package org.miko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;


@Controller
public class ArticleController {

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile[] myfiles, HttpServletRequest request) throws IOException {

        for(MultipartFile f:myfiles){
            System.out.println("new File");

            System.out.println(f.getName());
        }

        System.out.println(myfiles.length);
        System.out.println(request.getParameter("contentJson"));

        return "success";
    }

}
