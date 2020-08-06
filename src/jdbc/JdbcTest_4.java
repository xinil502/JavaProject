package jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 * PreparedStatement解决SQL注入问题:
 *      使用户输入的信息不参与编译过程，问题就解决了。
 *      即使用户的信息含有关键字，也不会起作用。
 *      PreparedStatement 继承了 java,sql.Statement
 *      PreparedStatement 预先对 SQL 框架进行编译，然后只能对框架传值。
 * PreparedStatement 和 Statement 的比较：
 *      -Statement有SQL注入问题，PreparedStatement解决了注入问题。
 *      -Statement是编译SQL语句一次，执行一次。 PreparedStatement是编译一次，可以执行N次。
 *      -PreparedStatement会在编译时进行类型检查。
 *      -PreparedStatement 使用较多。
 *          极少数使用 Statement(业务方面要求修改SQL语句结构式，必须支持SQL注入)。
 */
public class JdbcTest_4 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;  //使用PreparedStatement数据库对象
        ResultSet rs = null;
        try {
            //1.注册驱动（获取Driver接口实现类）
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

            //3.获取预编译的数据库操作对象，，，SQL语句
            /**
             *使用PreparedStatement方式：
             *     1.单独一个 ? 作为占位符  , 一个 ? 接收一个值.传给DBMS进行预编译。
             *
             *     2.ps.set数据类型(parameterIndex, x)传对应数据类型的值：
             *             parameterIndex：第一个问号的下标是1，第二个问号的下标是2。
             *             x: 传入的值。
             *             如果数据类型是String，会在前后自动加'，不需要在值里面加了
             *     3.ps.executeUpdate()/ps.executeQuery() 执行SQL语句。
             */
            ps = conn.prepareStatement("SELECT empno a,ename,sal FROM emp WHERE ename = ?"); //SQL框架
            ps.setString(1,"SMITH");
            //5.处理结果集
            rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("存在查询结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps != null){
                    ps.close();
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
