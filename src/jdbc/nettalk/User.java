package jdbc.nettalk;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端，实现一个客户可以正常收发信息。
 */
public class User {
    public static void main(String[] args) throws Exception{
        String[] u = new String[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        u[0] = sc.next();
        System.out.print("请输入密码：");
        u[1] = sc.next();
        Socket socket = new Socket("192.168.0.3", 9999);
        new Thread(new Send(socket, u[0], u[1])).start();
        new Thread(new Receive(socket)).start();
    }
}

class Send implements Runnable {
    private BufferedReader br;
    private DataOutputStream dos;
    private Socket client;
    static boolean isRunning = true;
    private String userName;
    private String password;

    public Send(Socket socket, String name, String password) {

        this.client = socket;
        this.userName = name;
        this.password = password;
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
            System.out.print("请输入消息：");
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

    void startSend(){
        try {
            dos.writeUTF(userName);
            dos.writeUTF(password);
            System.out.println("正在验证密码，请稍等。");
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
            relese();
        }
    }


    @Override
    public void run() {
        startSend();
        while(isRunning){
            String msg = getMsg();
            send(msg);
        }
    }
}

class Receive implements Runnable{
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning = true;

    public Receive(Socket client) {
        this.client = client;
        try {
            this.dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            e.printStackTrace();
        }
    }

    String recive(){
        String mag = "";
        try {
            mag =  dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning = false;
        }
        return mag;
    }

    void startRecive(){
        try {
            if(!dis.readBoolean()){
                isRunning = false;
                Send.isRunning = false;
                System.out.println("密码错误！");
            }else{
                System.out.println("密码正确。");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        startRecive();
        String msg;
        while(isRunning){
            msg = recive();
            if(!msg.equals("")) {
                System.out.println(msg);
            }
        }
    }
}

