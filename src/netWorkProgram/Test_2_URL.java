package netWorkProgram;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test_2_URL {
    public static void main(String[] args) throws Exception{
        //获取URL
        URL u1 = new URL("https://www.jd.com");
        URL u2 = new URL("https://www.bilibili.com/");

        //正常获取资源
        String msg;
//        InputStream is = u1.openStream();
//        BufferedReader br1 = new BufferedReader(new InputStreamReader(is, "utf-8"));
//        while(null != (msg = br1.readLine())){
//            System.out.println(msg);
//        }
//        br1.close();
//        is.close();


        HttpURLConnection conn = (HttpURLConnection)u2.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:78.0) Gecko/20100101 Firefox/78.0");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        while(null != (msg = br2.readLine())){
            System.out.println(msg);
        }
        br2.close();

    }
}
