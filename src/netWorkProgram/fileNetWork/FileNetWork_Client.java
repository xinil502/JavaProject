package netWorkProgram.fileNetWork;

import java.io.*;
import java.net.Socket;

/**
 * 本地上传：
 *   C:\Users\admin\Desktop\txt.txt  ->   服务器
 *
 * 实现步骤：
 *          1.创建一个本地字节输入流，绑定读取的数据源。
 *          2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
 *          3.使用Socket对象中的getOutputStream()获取网络字节输出流对象OutputStream。
 *          4.使用Socket对象中的getInputStream()获取网络字节输入流对象InputStream
 *          5.使用本地字节输入流FileInputStream中的read方法，读取本地文件。
 *          6.使用网络字节输出流对象OutputStream对象中的write方法，给服务器发送文件。
 *          7.使用网络字节输出流对象InputStream对象中的read方法，接受服务器回写的数据。
 *  *       8.释放资源(BufferedInputStream,Socket)
 *
 */
public class FileNetWork_Client {
    public static void main(String[] args) throws IOException {
        //本地读取流
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream("C:\\Users\\admin\\Desktop\\1.png"));

        //网络输入输出流
        Socket socket = new Socket("127.0.0.1", 8765);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        byte[] b = new byte[1024];
        int len;

        while((len = bf.read(b)) != -1){
            os.write(99);
            os.write(b);
        }
        os.write(48);

        len = is.read(b);
        System.out.println(new String(b, 0, len));

        socket.close();
        bf.close();
    }
}
