package org.miko.controller;

import com.google.gson.Gson;
import org.miko.Utils.Utils;
import org.miko.entity.DiaryDetailBean;
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

        String diaryJson = request.getParameter("diaryJson");

        DiaryDetailBean diaryBean = new Gson().fromJson(diaryJson,DiaryDetailBean.class);

        System.out.print(diaryBean.getId());
        for(MultipartFile f:myfiles){

            File dir = new File("/home/riji");
            if(!dir.exists()){
                dir.mkdirs();
            }

//            Utils.copyFile(,"/home/riji");

            System.out.println(f.getOriginalFilename());
        }


        System.out.println(myfiles.length);
        System.out.println(request.getParameter("contentJson"));

        return "success";
    }

}
