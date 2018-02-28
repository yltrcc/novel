package top.ttxxly.novel.utils;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

/**
 * 文件工具类，
 *      getFileContent 获取文件数据
 *      setFileContent 写入数据到文件中
 * Created by Administrator on 2/27/2018.
 * @author ttxxly
 *
 */

public class FileUtils {

    //打开指定文件，读取其数据，返回字符串对象
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

    //向指定的文件中写入指定的数据
    public static void setFileContent(String filename, String message, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(filename, MODE_PRIVATE);//获得FileOutputStream
            //将要写入的字符串转换为byte数组
            byte[] bytes = message.getBytes();
            fos.write(bytes);//将byte数组写入文件
            fos.close();//关闭文件输出流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
