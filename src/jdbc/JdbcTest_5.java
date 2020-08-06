package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务管理：
 *      Connection 中 setAutoCommit(boolean b)
 *          设置提交机制： true.选择自动提交，false.选择手动提交。
 *          commit() 提交事务
 *          rollback()  出现异常，回滚事务
 */
public class JdbcTest_5 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/db_1?serverTimezone=UTC","user1","pass");

            conn.setAutoCommit(false);  //设为手动提交事务。
            ps = conn.prepareStatement("INSERT INTO dept VALUES(60,'特殊部门','陕西')");
            ps.executeUpdate();
            ps = conn.prepareStatement("UPDATE dept SET loc = '西安' WHERE loc = '陕西'");
            ps.executeUpdate();
            conn.commit();   //手动提交事务

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(conn != null){
                    conn.rollback();   //出现异常，事务回滚。
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
