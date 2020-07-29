package netWorkProgram.TCPNetWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_1_Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);

        Socket clienntSocket = ss.accept();

        DataInputStream dis = new DataInputStream(clienntSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clienntSocket.getOutputStream());

        String str = dis.readUTF();
        System.out.println(str);

        dis.close();
        dos.close();
        clienntSocket.close();
        ss.close();
    }
}
