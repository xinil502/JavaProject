package netWorkProgram.TCPNetWork;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_1_Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());


        //dos.writeUTF("发送测试信息。");
        dos.writeUTF(br.readLine());



        dos.close();
        dis.close();
        br.close();
        socket.close();
    }
}
