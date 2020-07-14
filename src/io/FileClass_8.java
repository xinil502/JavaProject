package io;

import java.io.*;

/**
 * 数据流 ： 基本数据类型的读写
 */
public class FileClass_8 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\txt.txt");
        testDataOutputStream(file);
        testDataInputStream(file);
    }

    /**
     * 数据输出流
     *
     * 用数据输出流写的奥文件中的基本数据类型的数据，是乱码的，不能直接辨认出来。
     * 需要数据的输入流来读取。
     * @param file
     */
    public static void testDataOutputStream(File file){
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            out.writeChar('R');
            out.writeDouble(3.666d);

            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据输入流
     *
     * 用数据输入流读取 数据输出流写到文件中的数据时，
     * 要保证使用和当时写的数据类型一致的数据类型来读取。
     * @param file
     */
    public static void testDataInputStream(File file){
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            char a = in.readChar();
            double d = in.readDouble();

            System.out.println(a);
            System.out.println(d);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
