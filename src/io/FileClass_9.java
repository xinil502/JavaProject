package io;

import java.io.*;

/**
 * 对象流
 *
 * 1.硬盘存储的基础是二进制，那就需要把对象转化为二进制的字节流，把这个流保存到电脑上。
 * 读取时，需要把流转化为对象。
 * 2.写入IO流 ： 序列化
 * 从IO流恢复过来： 反序列化
 * 序列化与反序列化都是对象的属性，不包括static
 * 若被static修饰为静态，或被transien修饰 ,则不能进行序列化与反序列化。
 *
 * 3.可序列化的对象必须实现 Serializable 或 Externalizable 两个接口之一
 * 4.序列化与反序列化的对象要严格一致，所有类的属性都要一致。
 */
public class FileClass_9 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\txt.txt");
        Person p = new Person();
        p.name = "张三";
        p.age = 18;
        testSerialize(file, p);
    }
    /**
     * 对象序列化
     */
    public static void testSerialize(File file, Object obj){
        try {
            //定义对象输出流，把对象序列化之后的流放到指定的文件中。
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(obj);
            out.flush();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象反序列化回
     */
    public static void testDeserialize(File file, Object obj){

        try {
            //创建对象输入流，从指定的文件中把对象序列化之后的流读取出来。
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            Object o = in.readObject();
            Person p = (Person)o;
            System.out.println("name:" + p.name + "  age:" + p.age);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 可序列化与反序列化的对象。
 *
 */
class Person implements Serializable{
    /**
     * 序列化版本标识符的静态变量
     * 用来表明类的不同版本的兼容性
     */
    private static final long serialVersionUID = 1L;

    String name = "abc";
    int age = 100;
}