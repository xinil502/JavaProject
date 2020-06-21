package learnJava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 异常处理Exception
 */
public class Project_27 {
    public static void main(String[] args) {
        FileReader reader = null;
        try{
            reader = new FileReader("C:\\Users\\admin\\Desktop\\a.txt"); //未找到，直接跳到catch，后面不会执行

            char c = (char)reader.read();
            System.out.println(c);
        }catch( FileNotFoundException e){ //如果细分的话，子类要写在父类前
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{ //继续处理
            try{
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
