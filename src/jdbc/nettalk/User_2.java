package jdbc.nettalk;

import java.net.Socket;
import java.util.Scanner;

public class User_2 {
    public static void main(String[] args) throws Exception{
        String[] u = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        u[0] = sc.next();
        System.out.print("请输入密码：");
        u[1] = sc.next();
        Socket socket = new Socket("127.0.0.1", 9999);
        new Thread(new Send(socket, u[0], u[1])).start();
        new Thread(new Receive(socket)).start();
    }
}