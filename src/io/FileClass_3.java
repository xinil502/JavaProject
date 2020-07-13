package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileClass_3 {
    public static void main(String[] args) {
//        testFileReader(new File("C:\\Users\\admin\\Desktop\\txt.txt"));
        testFileWriter("testFileWiter", new File("C:\\Users\\admin\\Desktop\\testFileWriter.txt"));
//        copyFile(new File("C:\\Users\\admin\\Desktop\\txt.txt"), new File("C:\\Users\\admin\\Desktop\\1.txt"));
    }

    public static void testFileReader(File file){ //文件字符输入流
        try{
            FileReader fr = new FileReader(file); //创建字符输入流对象
            char[] c = new char[100]; //创建临时存放数据的字符数组

            int len = 0;
            while ((len = fr.read(c)) != -1){
                System.out.println(new String(c, 0, len));
            }

            fr.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testFileWriter(String s, File file){ //文件字符输出流
        try{
            FileWriter fw = new FileWriter(file);

            fw.write(s);  //写到内存
            fw.flush(); //刷到硬盘
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void copyFile(File file1, File file2){//复制文件

        try{
            FileReader fr = new FileReader(file1);
            FileWriter fw = new FileWriter(file2);
            char[] c = new char[100];
            int len;
            while((len = fr.read(c)) != -1){
                fw.write(c, 0, len);
            }
            fw.flush();
            fw.close();
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
