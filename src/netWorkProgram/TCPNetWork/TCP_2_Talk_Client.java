package netWorkProgram.TCPNetWork;

import java.io.*;
import java.net.Socket;

/**
 * 客户端，实现一个客户可以正常收发信息。
 */
public class TCP_2_Talk_Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String s = br.readLine();
        new Thread(new Send(socket, s)).start();
        new Thread(new Receive(socket)).start();
    }
}

class Send implements Runnable {
    private BufferedReader br;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning = true;
    private String userName;

    public Send(Socket socket, String userName) {
        this.client = socket;
        this.userName = userName;
        this.br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            relese();
        }
    }

    /**
     * 从控制台读取输入信息
     * @return
     */
    String getMsg(){
        String msg = "";
        try {
            msg = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            relese();
        }
        return msg;
    }

    /**
     * 发送信息
     * @param msg
     */
    void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            relese();
        }
    }

    void relese(){
        try {
            client.close();
            client.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
        }
    }

    @Override
    public void run() {
        send(userName);
        while(isRunning){
            String msg = getMsg();
            send(msg);
        }
    }
}

class Receive implements Runnable{
    private DataInputStream dos;
    private Socket client;
    private boolean isRunning = true;

    public Receive(Socket client) {
        this.client = client;
        try {
            this.dos = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            e.printStackTrace();
        }
    }

    String recive(){
        String mag = "";
        try {
            mag =  dos.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
        }
        return mag;
    }


    @Override
    public void run() {
        String msg = null;
        while(isRunning){
            msg = recive();
            if(!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }
}
