package netWorkProgram.TCPNetWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 聊天室：服务器
 * 收发信息。
 */

public class TCP_2_Talk_Chat {
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
        private String userName;

        public Channel(Socket socket) {
            this.socket = socket;
            try {
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                relese();
            }
        }

        String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                relese();
            }
            return msg;
        }

        void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
                relese();
            }
        }

        void sendOthers(String msg){
            for(Channel other : all){
                if (other != this) {
                    other.send(msg);
                }
            }
        }

        void relese(){
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

        @Override
        public void run() {
            userName = receive();
            String msg;
            sendOthers("（系统消息）" + userName + " 进入了群聊。");
            while (isRunning) {
                msg = receive();
                System.out.println(msg);

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
            }
        }
    }

}


