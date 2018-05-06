package com.ttxxly.reader.utils;


import android.content.Context;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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


    public static String getCharset(String fileName) {
        BufferedInputStream bis = null;
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            bis = new BufferedInputStream(new FileInputStream(fileName));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.mark(0);
            if (!checked) {
                while ((read = bis.read()) != -1) {
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80 - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return charset;
    }

    public static String getCharset1(String fileName) throws IOException {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();

        String code;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }

    public static void saveWifiTxt(String src, String desc) {
        byte[] LINE_END = "\n".getBytes();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(src), getCharset(src));
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fout = new FileOutputStream(desc, true);
            String temp;
            while ((temp = br.readLine()) != null) {
                byte[] bytes = temp.getBytes();
                fout.write(bytes);
                fout.write(LINE_END);
            }
            br.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
