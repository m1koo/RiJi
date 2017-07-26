package org.miko.controller;

import ch.qos.logback.core.util.FileUtil;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
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
        DiaryDetailBean diaryObj = new Gson().fromJson(diaryJson, DiaryDetailBean.class);

        String id = diaryObj.getId();
        int day = diaryObj.getDay();
        int month = diaryObj.getMonth();
        int year = diaryObj.getYear();
        String location = diaryObj.getLocation();
        long date = diaryObj.getDate();
        String contentJson = diaryObj.getDiaryJson();

        /**创建根目录*/
        String rootPath = "/home/miko/meiriji/" + id + "/";
        File dir = new File(rootPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (MultipartFile f : myfiles) {
            File oldFile = new File(rootPath + f.getOriginalFilename());

            FileUtils.writeByteArrayToFile(oldFile, f.getBytes());

            System.out.println(f.getOriginalFilename());
        }

        System.out.println(myfiles.length);
        return "success";
    }

}
