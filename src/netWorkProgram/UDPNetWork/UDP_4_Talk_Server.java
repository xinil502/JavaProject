package netWorkProgram.UDPNetWork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 服务端--在线咨询
 */
public class UDP_4_Talk_Server {
    public static void main(String[] args){
        Thread threadSend = new Thread(new Server_Send(9988, "169.254.136.141", 8888));
        Thread threadRecive = new Thread(new Server_Receive(9999));

        threadRecive.start();
        threadSend.start();
    }
}

class Server_Send implements Runnable{

    DatagramSocket send;

    InetSocketAddress address;
    public Server_Send(int port, String host, int toPort) {
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
            System.out.println("服务器发送端启动中。");


            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                byte[] datas = s.getBytes();

                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, address);

                send.send(packet);
                if(s.length() > 3 && s.substring(0, 4).equals("quit")){
                    System.out.println("发送端已关闭。");
                    break;
                }
            }
            send.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Server_Receive implements Runnable{
    DatagramSocket receive;

    public Server_Receive(int port) {
        try {
            this.receive = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        try {
            System.out.println("服务器接收端启动中。");
            while (true) {
                // 2.准备容器，封装成DatagramPacket包裹。
                byte[] container = new byte[1024*60]; //最多60k
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                // 3.阻塞式接收包裹 receive(DatagramPacket p)。
                receive.receive(packet);

                // 4.分析数据
                byte[] datas = packet.getData();
                int length = datas.length; //或者  int length = packet.getLength();
                String s = new String(datas, 0, datas.length);
                if(s.substring(0, 4).equals("quit")){
                    System.out.println("对方已终止发送，接收端已关闭。");
                    break;
                }
                System.out.println(s);
            }

            //5.释放资源
            receive.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}