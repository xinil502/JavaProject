package netWorkProgram;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL:统一资源定位器，互联网三大基石之一（http，html）
 *
 * 1.协议
 * 2.域名，计算机：
 * 3.端口：默认：80
 * 4.请求资源
 * http://www.baidu.com:80/?uname=rjw&age=80#a
 */
public class test_1_URL {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com:80/index.html?uname=rjw&age=18#a");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //获取四个值
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名ip：" + url.getHost());
        System.out.println("端口：" + url.getPort());
        System.out.println("请求资源1：（完整内容）" + url.getFile());
        System.out.println("请求资源2：（只获取URI）" + url.getPath());
        System.out.println("获取参数" + url.getQuery());
        System.out.println("获取锚点" + url.getRef());
    }
}
