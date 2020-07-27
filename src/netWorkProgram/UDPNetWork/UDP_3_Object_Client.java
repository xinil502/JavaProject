package netWorkProgram.UDPNetWork;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 */
public class UDP_3_Object_Client {
    public static void main(String[] args) throws Exception{
        System.out.println("客户端启动中。");
//        1.使用DatagramSocket指定端口，创建发送端。
        DatagramSocket client = new DatagramSocket(8888);

//        2.准备数据，一定要转成字节数组。
        //用字节数组流，建缓冲字节流，再建立对象流，用对象流操作后，用字节流转为字节数组。
        //基本数据类型是对象，对象也是对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        Person p = new Person();
        p.name = "person对象的name变量";
        p.age = 18;
        oos.writeObject(p);
        oos.writeDouble(3.1415926);
        oos.writeInt(18);
        oos.writeUTF("UTF字符串");
        oos.writeChar('L');
        oos.writeBoolean(true);
        oos.flush();

        byte[] datas = baos.toByteArray();

//        3.封装成DatagramPacket包裹，需制定目的地。
        //本地接收端和发送端端口不能重复
        InetSocketAddress adress = new InetSocketAddress("localhost", 9999);
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, adress);

//        4.发送包裹 send(DatagramPacket p)。
        client.send(packet);

//        5.释放资源。
        client.close();
        oos.close();
        baos.close();
    }
}


/**
 * 可序列化与反序列化的对象。
 *
 */
class Person implements Serializable {
    /**
     * 序列化版本标识符的静态变量
     * 用来表明类的不同版本的兼容性
     */
    private static final long serialVersionUID = 1L;

    String name = "abc";
    int age = 100;
}