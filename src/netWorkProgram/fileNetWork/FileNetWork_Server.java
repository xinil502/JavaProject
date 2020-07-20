package netWorkProgram.fileNetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传服务器端：
 * 读取客户端文件，保存到服务器的硬盘，给客户端回写上传成功。
 *
 * 实现步骤:
 *          略
 */
public class FileNetWork_Server {
    public static void main(String[] args) throws IOException {
        //本地写入流
        File file = new File("C:\\Users\\admin\\Desktop\\2.png");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //网络输入输出流
        ServerSocket ss = new ServerSocket(8765);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        byte[] b = new byte[1024];
        int len, bb;

        bb = is.read();
        while(true){
            len = is.read(b);
            bb = is.read();
            bos.write(b, 0 , len);
            if(bb == 48){
                break;
            }
        }
        System.out.println("文件上传成功。");
        os.write("文件上传成功。".getBytes());

        socket.close();
        ss.close();
        bos.close();
        fos.close();
    }
}
