package com.ttxxly.novel.utils;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

/**
 * 文件工具类，
 * getFileContent 获取文件数据
 * setFileContent 写入数据到文件中
 * Created by Administrator on 2/27/2018.
 *
 * @author ttxxly
 */

public class FileUtils {

    /**
     * 获取 /data/data/包名/files 下的指定文件的数据
     *
     * @param fileName 文件名
     * @param context  Context 对象
     * @return 可能数据为空，需要判空处理。
     */
    public static String getFileContent(String fileName, Context context) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append('\n');
                }
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向指定文件中写入数据
     *
     * @param filename 文件名
     * @param message  要写入的数据
     * @param context  Context 对象
     */
    public static void setFileContent(String filename, String message, Context context) {
        try {
            //获得FileOutputStream
            FileOutputStream fos = context.openFileOutput(filename, MODE_PRIVATE);
            //将要写入的字符串转换为byte数组
            byte[] bytes = message.getBytes();
            //将byte数组写入文件
            fos.write(bytes);
            //关闭文件输出流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
