package jdbc.nettalk;


import jdbc.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class SignIn {
    private boolean re = false;
    private String user_j = "";
    private String password_j = "";

    public SignIn() {
        getInput();
    }

    public SignIn(String user_j, String password_j) {
        this.user_j = user_j;
        this.password_j = password_j;
    }

    public void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        user_j = sc.next();
        System.out.print("请输入密码：");
        password_j = sc.next();
    }

    public int judgeSignIn() {
        int id = -1;
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //密码判断
            ps = conn.prepareStatement("SELECT uid,name FROM user WHERE  name = ? and password = ?");
            ps.setString(1, user_j);
            ps.setString(2, password_j);
            rs = ps.executeQuery();

            if(rs.next()){
                re = true;
                id = rs.getInt("uid");
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
        return id;
    }
}
