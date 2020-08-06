package jdbc;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.sql.*;
        import java.util.Properties;

/**
 * int executeUpdate(INSERT/DELETE/UPDATE)
 * ResultSet executeQuery(SELECT)
 *
 * executeQuery() + ResultSet查询结果集
 * ResultSet也要释放
 */
public class JdbcTest_3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
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

            //3.获取数据库操作对象(Statement专门执行SQL语句)
            stmt = conn.createStatement();

            //4.执行sql语句（不用写分号）
            /**
             * .executeQuery() 专门执行DQL语句（SELECT）
             * 返回值：单个ResultSet对象，永远不能为null。
             */
            String sql = "SELECT empno a,ename,sal FROM emp";
            rs = stmt.executeQuery(sql);

            //5.处理查询结果集
            /**
             * rs结果集起始位于第一行数据的前一行。
             * .next后移一位，并判断移动后的位置是否有数据
             * 返回值：true/false
             */
            while(rs.next()){
                /**
                 * .getString(参数) 不管数据类型是什么，都以String取出
                 * .getInt(参数)   以特定类型取出
                 *  参数：index(列数，从1开始)。
                 *  参数：字段值 (查询结果集的列名)
                 */
                System.out.println(rs.getInt("a")
                        + "\t"+ rs.getString(2)
                        + "\t" + rs.getDouble("sal"));
            }
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
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
