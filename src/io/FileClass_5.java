package io;

import java.io.*;

/**
 * 转换流
 *
 * 1. 其是字符流和字节流之间的桥梁
 * 2. 可对读取到的字节数据经过指定编码转换成字符
 * 3. 可对读取到的字符数据经过指定编码转换成字节
 */
public class FileClass_5 {
    public static void main(String[] args) {
        //所有的文件都是有编码格式的
        //对于我们来说，txt和java文件一般来讲有
        // ISO8859-1,西欧编码，时纯英文编码，不适应汉字
        // utf-8,和GBK，这两编码是适用于中文和英文，
        // 我们一般使用utf-8
//        testInputStreamReader(new File("C:\\Users\\admin\\Desktop\\txt.txt"));
        testOutputStreamReader("88888", new File("C:\\Users\\admin\\Desktop\\txt.txt"));
    }

    /**
     * 转换输入流
     * InputStreamReader
     */
    public static void testInputStreamReader(File file){
        try {
            FileInputStream fis = new FileInputStream(file);

            //把字节流转换为字符流  字节流对象 编码
            InputStreamReader in = new InputStreamReader(fis, "utf-8");

            char[] c = new char[100];
            int len = 0;

            while((len = in.read(c)) != -1){
                System.out.println(new String(c, 0, len));
            }

            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 转换输出流
     * InputStreamReader
     */
    public static void testOutputStreamReader(String s, File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);

            //把字节流转换为字符流  字节流对象 编码
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");

            osw.write(s);
            osw.flush();

            osw.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
