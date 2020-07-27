package netWorkProgram.UDPNetWork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 *
 * 1.使用DatagramSocket指定端口，创建发送端。
 * 2.准备数据，一定要转成字节数组。
 * 3.封装成DatagramPacket包裹，需制定目的地。
 * 4.发送包裹 send(DatagramPacket p)。
 * 5.释放资源。
 */
public class UDP_1_Client {
    public static void main(String[] args) throws Exception{
        System.out.println("发送方启动中。");
//        1.使用DatagramSocket指定端口，创建发送端。
        DatagramSocket client = new DatagramSocket(8888);

//        2.准备数据，一定要转成字节数组。
        String data = "这就是数据";
        byte[] datas = data.getBytes();

//        3.封装成DatagramPacket包裹，需制定目的地。
        //本地接收端和发送端端口不能重复
        InetSocketAddress adress = new InetSocketAddress("localhost", 9999);
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, adress);

//        4.发送包裹 send(DatagramPacket p)。
        client.send(packet);

//        5.释放资源。
        client.close();
    }
}
