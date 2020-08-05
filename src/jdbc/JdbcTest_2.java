package jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * 使用类加载动作注册驱动（常用方式）
 */
public class JdbcTest_2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            /**
             * 使用反射机制会导致类加载动作。
             * 类加载动作会导致静态代码块的执行。
             * 静态代码块的执行完成驱动注册。
             */
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.获取连接(ip,端口，用户名，密码)
            BufferedReader br = new BufferedReader(new FileReader("src/jdbc/user.properties"));
            Properties p = new Properties();
            p.load(br);
            br.close();
            String url = p.getProperty("url");
            String name = p.getProperty("user1");
            String password = p.getProperty("password1");
            conn = DriverManager.getConnection(url,name,password);
            System.out.println("成功连接数据库对象：" + conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

