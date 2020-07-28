package netWorkProgram.UDPNetWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 客户端--在线咨询
 */
public class UDP_4_Talk_Client {
    public static void main(String[] args) {
        Thread threadSend = new Thread(new Client_Send(8899, "169.254.136.141", 9999));
        Thread threadRecive = new Thread(new Client_Receive(8888));

        threadRecive.start();
        threadSend.start();
    }
}

class Client_Send implements Runnable{
    DatagramSocket send;

    InetSocketAddress address;
    public Client_Send(int port, String host, int toPort) {
        try {
            this.send = new DatagramSocket(port);
            this.address = new InetSocketAddress(host, toPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        try {
            System.out.println("客户端发送端启动中。");
//        1.使用DatagramSocket指定端口，创建发送端。

            while (true) {
    //        2.准备数据，一定要转成字节数组。
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String data = br.readLine();
                byte[] datas = data.getBytes();

    //        3.封装成DatagramPacket包裹，需制定目的地。
                //本地接收端和发送端端口不能重复
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, address);

    //        4.发送包裹 send(DatagramPacket p)。
                send.send(packet);
                if(data.length() > 3 && data.substring(0, 4).equals("quit")){
                    System.out.println("发送端已关闭。");
                    break;
                }
            }

//        5.释放资源。
            send.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client_Receive implements Runnable{
    DatagramSocket socket;

    public Client_Receive(int port) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            System.out.println("客户端接收端启动中。");

            while(true){
                byte[] receive = new byte[1024*60];
                DatagramPacket packet = new DatagramPacket(receive, 0, receive.length);

                socket.receive(packet);

                byte[] datas = packet.getData();
                String s = new String(datas, 0, datas.length);
                if(s.substring(0, 4).equals("quit")){
                    System.out.println("对方已终止发送，接收端已关闭。");
                    break;
                }
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}