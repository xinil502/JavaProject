package io;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * IO + Properties 的联合应用
 *
 * 非常好的设计理念：
 *      经常改的数据，可以单独写到一个文件中，使用程序动态读取。
 *      以后只改文件，不需要重新改动代码，编译代码，重启服务器.
 *      类似于以上的文件被称为配置文件。
 *      且当文件内容是
 *          key1=value
 *          key2=value
 *      被称为属性配置文件。
 *      通常推荐以.properties结尾。
 */
public class Project_10 {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("src/io/test_10.properties");

        //Properties 是一个Map集合，key和value都是String类型的。
        Properties pro = new Properties();

        //使用流作为一个管道，将文件内容load加载到Map中。
        pro.load(fis);

        String name = pro.getProperty("name");
        String password = pro.getProperty("password");
        System.out.println("name = " + name + "    password = " + password);
    }
}
