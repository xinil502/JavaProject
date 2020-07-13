package io;

import java.io.*;

/**
 * 缓存字节流(基于内存)
 *
 * 文件流的读写速度相对较慢，受到硬盘读写速度的制约
 * 为了能提供快速读写速度，一定程度上绕过硬盘的限制，java提供了缓冲流。
 *
 * 缓冲流就是先把数据缓冲在内存里，在内存中去做io操作，基于内存的io操作大概能比基于硬
 * 盘的io操作快75000多倍。
 */
public class FileClass_4 {
    public static void main(String[] args) {
//        testBufferdInputStream(new File("C:\\Users\\admin\\Desktop\\txt.txt"));
//        testBufferedOutputStream("testBufferedOutputStream", new File("C:\\Users\\admin\\Desktop\\txt.txt"));
        copyFile(new File("C:\\Users\\admin\\Desktop\\txt.txt"),new File("C:\\Users\\admin\\Desktop\\newTxt.txt"));
    }

    /**
     * 缓冲字节输入流
     */
    public static void testBufferdInputStream(File file) {

        try {
            FileInputStream in = new FileInputStream(file);//文件字节输入流对象
            BufferedInputStream bis = new BufferedInputStream(in); //需要引用InputStream或其子类对象
            byte[] b = new byte[100];
            int len;

            while((len = bis.read(b)) != -1){
                System.out.println(new String(b, 0, len));
            }

            bis.close(); //关闭流： 先开后关
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲字节输出流
     */
    public static void testBufferedOutputStream(String s, File file){
        try {
            FileOutputStream out = new FileOutputStream(file);//创建字节流输出对象
            BufferedOutputStream bos = new BufferedOutputStream(out); //引用字节输出流对象

            bos.write(s.getBytes());
            bos.flush();
            bos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲流实现文件复制
     */
    public static void copyFile(File file1, File file2){
        try {
            FileInputStream fin = new FileInputStream(file1);
            BufferedInputStream bis = new BufferedInputStream(fin);
            FileOutputStream fos = new FileOutputStream(file2);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] b = new byte[100];
            int len;

            while((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
            bos.flush();

            bos.close();
            fos.close();
            bis.close();
            fin.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
