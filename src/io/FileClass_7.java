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
        byte[] src = testByteArrayOutputStream("abcdefg");
    }

    /**
     * 1.从内存中获取字节数组进行操作**（计算，写入文件）
     *
     *
     * 跟 FileInputStream一样，构造时用数据源做参数(文件路径 / 此处为字节数组)
     * 使用while((len=in.read(temp))!=-1){
     *     //使用读取到的数据。
     * }
     */
    public static void testByteArrayInputStream(String s){
        byte[] src = s.getBytes(); //输入的字节数组

        try {
            InputStream is = new ByteArrayInputStream(src);
            byte[] flush = new byte[10]; //缓冲容器
            int len = -1;
            while((len = is.read(flush)) != -1){
                System.out.println(new String(flush, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将程序运行中获取的信息写到到内存的字节数组中，暂时储存。
     *
     */
    public static byte[] testByteArrayOutputStream(String s){
        byte[] src = s.getBytes();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(src, 0, src.length);

        return src;
    }
}
