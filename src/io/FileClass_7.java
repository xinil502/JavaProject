package io;

import java.io.*;

/**
 * 字节数组流
 *
 * 与内存交互，数组不要太大，gc关闭，不需要手动关闭，手动关闭也没有任何影响
 *
 * 1.创建源
 * 2.选择流
 * 3.读写操作
 * 4.释放资源(可有可无)
 */
public class FileClass_7 {
    public static void main(String[] args) {
        testByteArrayInputStream("This is a sentence.");
    }

    public static void testByteArrayInputStream(String s){
        byte[] src = s.getBytes();

        InputStream is = null;

        try {
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[10]; //缓冲容器
            int len = -1;
            while((len = is.read(flush)) != -1){
                System.out.println(new String(flush, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testByteArrayOutputStream(String s){
        byte[] src = s.getBytes();

        ByteArrayOutputStream baos = null;

        baos = new ByteArrayOutputStream();
        baos.write(src, 0, src.length);
    }
}
