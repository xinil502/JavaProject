package netWorkProgram.netWork1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP通信的客户端实现
 *
 * 向服务器发送请求，给服务器发送数据，读取服务器回写的数据
 *
 * 表示客户端的类：java.net.Socket
 *          此类实现客户端套接字，套接字是包含IP地址和端口号的网络单位。
 *
 * 构造方法：Socket(String host, int port)创建一个流套接字，并将其连接到指定主机上的指定端口号。
 *          参数：
 *              String host: 服务器主机的名称/服务器的IP地址。
 *              int post: 服务器的端口号。
 * 成员方法：
 *          OutputStream getOutputStream()  返回此套接字的输出流。
 *          InputStream getInputStream()   返回此套接字的输入流。
 *          void close()  关闭此套接字。
 *
 * 实现步骤：
 *          1.创建一个客户端对象Socket, 构造方法绑定服务器的IP地址和端口号
 *          2.使用Socket对象中的getOutputStream()获取网络字节输出流对象OutputStream(不是自己创建的，是通过SOcket获取的)
 *          3.使用网络字节输出流对象OutputStream对象中的write方法，给服务器发送数据。
 *          4.使用Socket对象中的getInputStream()获取网络字节输入流对象InputStream(不是自己创建的，是通过SOcket获取的)
 *          5.使用网络字节输出流对象InputStream对象中的read方法，接受服务器回写的数据。
 *          6.释放资源(Socket)
 *
 * 注意事项：
 *          1.客户端和服务器端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象。
 *          2.当我们创建客户端对象Socket的时候，就会去请求服务器进行三次握手建立连接通路。
 *            这是如果服务器没有启动，就会抛出异常，
 *            如果服务器已经启动，那么就可以进行交互了。
 */

public class NetWork_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8765);
        OutputStream os = socket.getOutputStream();
       //发送至服务器
        os.write("你好服务器".getBytes());

        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len;

        //读取服务器回写数据
        len = is.read(b);
        System.out.println(new String(b, 0, len));

        socket.close();
    }
}
