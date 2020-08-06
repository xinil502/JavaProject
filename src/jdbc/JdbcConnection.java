package jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcConnection {

    static{   //调用类加载器的运行加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        FileReader fr = null;
        try {
            fr = new FileReader("src/jdbc/user.properties");
            Properties p = new Properties();
            p.load(fr);
            conn = DriverManager.getConnection(p.getProperty("jdbcConnection_url")
                    ,p.getProperty("jdbcConnection_user")
                    ,p.getProperty("jdbcConnection_password"));
        } catch (Exception e) {
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return conn;
    }
}
