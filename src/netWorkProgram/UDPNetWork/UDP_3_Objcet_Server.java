package netWorkProgram.UDPNetWork;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 */
public class UDP_3_Objcet_Server {

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
        //顺序与写入时一致。
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        Person p = (Person) ois.readObject();
        double a = ois.readDouble();
        int b = ois.readInt();
        String c = ois.readUTF();
        char d = ois.readChar();
        boolean e = ois.readBoolean();
        System.out.println(p.name + " + " +  p.age);
        System.out.println(a + "--" + b + "--"+ c + "--" + d + "--" + e);

        //5.释放资源
        server.close();
        ois.close();
    }
}
