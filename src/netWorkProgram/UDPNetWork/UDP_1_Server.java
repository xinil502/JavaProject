package netWorkProgram.UDPNetWork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 *
 * 1.使用DatagramSocket指定端口，创建接收端。
 * 2.准备容器，封装成DatagramPacket包裹。
 * 3.阻塞式接收包裹 receive(DatagramPacket p)。
 * 4.分析数据
 *      byte[] = getData()
 *      getLength()
 * 5.释放资源
 */
public class UDP_1_Server {
    public static void main(String[] args) throws Exception{
        System.out.println("接收端启动中。");
        // 1.使用DatagramSocket指定端口，创建接收端。
        DatagramSocket server = new DatagramSocket(9999);

        // 2.准备容器，封装成DatagramPacket包裹。
        byte[] container = new byte[1024*60]; //最多60k
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        // 3.阻塞式接收包裹 receive(DatagramPacket p)。
        server.receive(packet);

        // 4.分析数据
        byte[] datas = packet.getData();
        int length = datas.length; //或者  int length = packet.getLength();
        System.out.println(new String(datas, 0, datas.length));

        //5.释放资源
        server.close();
    }
}
