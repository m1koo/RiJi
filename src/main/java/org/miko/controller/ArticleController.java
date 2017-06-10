package org.miko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;


@Controller
public class ArticleController {

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("a") String json) throws IOException, URISyntaxException {

        URL is = this.getClass().getClassLoader().getResource("a.xml");
        return txt2String(is);
    }

    public String txt2String(URL is) throws IOException, URISyntaxException {
        if(is == null){
            System.out.println("fadsfadfdafadsfad");
        }
        StringBuilder result = new StringBuilder();
        String line = null;
        BufferedReader reader = new BufferedReader(new FileReader(new File(is.toURI())));
        while ((line = reader.readLine())!=null) {
            result.append(line);
        }
        return result.toString();
    }
}
