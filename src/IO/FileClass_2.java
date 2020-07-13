package IO;

/**
 * 文件字节流 输入输出，文件复制
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileClass_2 {
    public static void main(String[] args) {
//        testInputStream(); //文件字节输入流
//        testOutputStream();  //文件字节输出流
        copyFile(new File("C:\\Users\\admin\\Desktop\\1S@%I2@S(CKYLJX7(MQ]83B.png"), new File("C:\\Users\\admin\\Desktop\\1.png"));
    }

    public static void testInputStream(){  //文件字节输入流
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\admin\\Desktop\\txt.txt");
            byte[] b = new byte[100]; //设置一个byte数组接收读取的文件的内容

            int len = 0;//设置一个读取数据的长度
            //in.read(b);   返回值：读取数据长度。
            // 如果读取到最后一个数据，还会往后读一个，并返回-1.
            len = in.read(b);
            System.out.println(new String(b,0, len) + ":" + len);


            in.close(); //流在使用完毕后要关闭
        }catch( Exception e){
            e.printStackTrace();
        }
    }

    public static void testOutputStream(){
        try {
            FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\txt.txt");
            String str = "abcdefg";
            out.write(str.getBytes());  //传为byte数组传入, 把数据写到内存中。
            out.flush(); //把内存中的数据刷写到硬盘上
            out.close(); //关闭流

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void copyFile(File file1, File file2){//复制文件
        if(file1.isDirectory() || file2.isDirectory()){
            return;
        }
        try{
            FileInputStream in = new FileInputStream(file1);
            FileOutputStream out = new FileOutputStream(file2);
            byte[] b = new byte[100]; //用于存储数据
            int len;

            if(!file2.exists()) {
                file2.createNewFile();
            }
            while((len = in.read(b)) != -1){//读取到数组中
                out.write(b,0,len);  //写入内存
            }

            out.flush(); //刷新到硬盘
            out.close();
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
