package jdbc.nettalk;

import jdbc.JdbcConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);

        Socket socket = null;
        boolean isRunning = true;

        System.out.println("服务器已启动。");
        while (isRunning) {
            socket = server.accept();
            Channel c = new Channel(socket);
            System.out.println("一个客户建立了链接.");
            all.add(c);
            new Thread(c).start();
        }

        socket.close();
        server.close();
    }

    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket socket;
        private boolean isRunning = true;
        private int uid;
        private String userName;
        private String password;


        public Channel(Socket socket) {
            this.socket = socket;
            try {
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
            return msg;
        }

        void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        void sendOthers(String msg){
            for(Channel other : all){
                if (other != this) {
                    other.send(msg);
                }
            }
        }

        void release(){
            try {
                isRunning = false;
                socket.close();
                dis.close();
                dos.close();
                all.remove(this);
                sendOthers(userName + " 离开了群聊。");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean startReceive(){
            try {
                userName = dis.readUTF();
                password = dis.readUTF();
                SignIn si = new SignIn(userName, password);
                int id = si.judgeSignIn();
                if(id == -1){
                    dos.writeBoolean(false);
                    return false;
                }
                dos.writeBoolean(true);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
            return true;
        }

        @Override
        public void run() {
            //初始化用户id和信息
            if(! startReceive()){
                return;
            }

            System.out.println("（系统消息）" + userName + " 进入了群聊。");
            sendOthers("（系统消息）" + userName + " 进入了群聊。");
            Connection conn = JdbcConnection.getConnection();
            String msg;
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement("INSERT INTO message(uid,message,mtime) VALUES(?,?,?)");
                ps.setInt(1,uid);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                while (isRunning) {  //接收客户发送的消息。
                    msg = receive();
                    System.out.println(userName + ":" + msg);

                    if(msg.startsWith("@")){ //私聊和群聊
                        int split = msg.indexOf(':');
                        for(Channel c : all){
                            if (c.userName.equals(msg.substring(1, split))){
                                c.send(userName + "悄悄对你说：" + msg.substring(split));
                            }
                        }
                    }else {
                        sendOthers(userName + "：" + msg);
                    }

                    //写入数据库
                    try {
                        ps.setString(2,msg);
                        ps.setString(3,sdf.format(new Date()));
                        ps.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
