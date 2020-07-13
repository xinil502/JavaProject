package IO;

/**
 * 文件字节流
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileClass_2 {
    public static void main(String[] args) {
//        testInputStream();
        testOutputStream();

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
}
