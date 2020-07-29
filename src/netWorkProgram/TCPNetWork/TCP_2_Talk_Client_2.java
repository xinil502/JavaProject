package netWorkProgram.TCPNetWork;

import java.io.*;
import java.net.Socket;

/**
 * 客户端，实现一个客户可以正常收发信息。
 */
public class TCP_2_Talk_Client_2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String s = br.readLine();
        new Thread(new Send(socket, s)).start();
        new Thread(new Receive(socket)).start();
    }
}
