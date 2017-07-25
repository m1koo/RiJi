package org.miko.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Miko on 2017/7/25.
 */
public class Utils {
    public static void copyFile(File oldfile, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldfile); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }
}
