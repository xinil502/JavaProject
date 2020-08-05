package jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 1、注册驱动
 * 2、获取连接
 * 3、获取数据库操作对象。
 * 4、执行sql
 * 5、处理查询结果
 * 6、释放资源
 *
 *
 * int executeUpdate(INSERT/DELETE/UPDATE)
 * ResultSet executeQuery(SELECT)
 *  艾克sei kiyoute 快瑞
 */
public class JdbcTest_1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动（获取Driver接口实现类）
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

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

            //3.获取数据库操作对象(Statement专门执行SQL语句)
            stmt = conn.createStatement();

            //4.执行sql语句（不用写分号）
            String sql = "INSERT INTO dept VALUES(50,'其他部门','北京')";
            /**
             * .executeUpdate() 专门执行DML语句（INSERT, DELETE, UPDATE）
             * 返回值：影响数据库中的记录条数。
             */
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "修改成功" : "修改失败");

            //5.处理查询结果集


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            /**
             * 为了保证资源一定释放，必须在finally中释放资源。
             * 从小到大依次关闭。
             * 每个语句都要单独写try catch
             */
            try {
                if(stmt != null){
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
