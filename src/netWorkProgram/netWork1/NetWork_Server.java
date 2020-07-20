package netWorkProgram.netWork1;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信的服务器端
 *
 * 接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 *
 * 表示服务器的类：
 *              java.net.ServerSocket: 此类实现服务器套接字
 *
 * 构造方法：
 *              ServerSocket(int port) 创建绑定到特定端口的服务器套接字。
 *
 * 服务器必须明确一件事情，是那个客户端请求的服务器，
 * 所以可以使用accept方法，获取到请求的客户端对象Socket
 * 成员方法：
 *              Socket accept() 侦听并接受到此套接字的连接。
 *
 * 服务器的实现步骤：
 *              1.创建服务器ServerSocket对象，和系统要指定的端口号。
 *              2.使用ServerSocket对象中的accept方法，获取到请求的客户端对象Socket
 *              3.使用Socket对象中的getInputStream()获取网络字节输入流对象InputStream
 *              4.使用网络字节输入流对象InputStream中的read方法，读取客户端发送的数据。
 *              5.使用Socket对象中的getOutputStream()获取网络字节输出流对象OutputStream。
 *              6.使用网络字节输出流对象OutputStream对象中的write方法，给客户端回写数据。
 *              7.释放资源(Socket, ServerSocket)
 */

public class NetWork_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8765); //问系统要固定的端口号
        Socket socket = ss.accept();  //获取请求的客户端Socket对象
        InputStream is = socket.getInputStream();

        //读取客户端数据
        byte[] b = new byte[1024];
        int len;

        len = is.read(b);
        System.out.println(new String(b, 0, len));

        //给客户端回写数据
        OutputStream os = socket.getOutputStream();
        os.write("已收到".getBytes());

        socket.close();
        ss.close();
    }
}
