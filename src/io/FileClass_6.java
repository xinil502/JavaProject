package io;

import java.io.*;

/**
 * 标准输入和输出流
 *
 */
public class FileClass_6 {
    public static void main(String[] args) {
//        testSysytemIn();
        writeToTxt(new File("C:\\Users\\admin\\Desktop\\txt.txt"));
    }

    public static void testSysytemIn(){
        //创建一个接收键盘输入数据的输入流
        InputStreamReader isr = new InputStreamReader(System.in); //输入流

        //把输入流放到缓冲流里
        BufferedReader br = new BufferedReader(isr);
        
        String str = "";
        try {
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToTxt(File file){
        try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String s = "";

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            while((s = br.readLine()) != null){
                if(s.equals("over")){ //读到over结束
                    break;
                }
                bw.write(s + "\n");
            }
            bw.flush();

            bw.close();
            br.close();
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
