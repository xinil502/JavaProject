package netWorkProgram.UDPNetWork;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 *
 * 将基本数据类型转为字节数组
 */
public class UDP_2_Type_Client {
    public static void main(String[] args) throws Exception{
        System.out.println("客户端启动中。");
//        1.使用DatagramSocket指定端口，创建发送端。
        DatagramSocket client = new DatagramSocket(8888);

//        2.准备数据，一定要转成字节数组。
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeDouble(3.1415926);
        dos.writeInt(18);
        dos.writeUTF("UTF字符串");
        dos.writeChar('L');
        dos.writeBoolean(true);
        dos.flush();
        byte[] datas = baos.toByteArray();

//        3.封装成DatagramPacket包裹，需制定目的地。
        //本地接收端和发送端端口不能重复
        InetSocketAddress adress = new InetSocketAddress("localhost", 9999);
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, adress);

//        4.发送包裹 send(DatagramPacket p)。
        client.send(packet);

//        5.释放资源。
        client.close();
        dos.close();
        baos.close();
    }
}
