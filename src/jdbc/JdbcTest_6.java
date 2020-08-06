package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试封装的JdbcConnection工具类。
 */
public class JdbcTest_6 {
    public static void main(String[] args) {
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //3.获取数据库操作对象(Statement专门执行SQL语句)
            ps = conn.prepareStatement("SELECT uid ID, name 用户 FROM user ORDER BY ID");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)
                        + "\t"+ rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
