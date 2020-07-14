package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件随机读写
 *
 * 程序可以直接跳到文件的任意地方来读写文件。
 */
public class FileClas_10 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\txt.txt");
        testRandomAccessFileRead(file);
        testRandomAccessFileWriter(file);
    }

    public static void testRandomAccessFileRead(File file) {
        //参数一是文件的访问路径，或File对象。
        //参数2 ： r:以只读方式打开
        //        rw:打开以便读取和写入
        //        rwd：打开以便读取和写入，同步文件内容的更新
        //        rws：打开以便读取和写入，同步文件内容和元数据的更新
        //  最常用的是r 和 rw
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");

            raf.seek(5); //设置文件内容的起始点（字节）

            byte[] b = new byte[128];
            int len = 0;

            while ((len = raf.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testRandomAccessFileWriter(File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            /**
             *  raf.seek(0); 从头写
             *  raf.seek(raf.length()); 从尾写
             *
             *  如果从中间写，会替换掉文件的原内容。
             */

            raf.seek(raf.length());
            raf.write("任某人到此一游".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
