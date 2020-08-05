package jdbc.mysqlonnextion;


import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

class SignIn {
    private boolean re = false;
    private String user_j = "";
    private String password_j = "";

    public void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        user_j = sc.next();
        System.out.println("请输入密码：");
        password_j = sc.next();
    }

    public Boolean judgeSignIn() {
        Map<String, String> map = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            FileReader fr = new FileReader("src/jdbc/user.properties");
            Properties p = new Properties();
            p.load(fr);
            fr.close();
            String url = p.getProperty("url");
            String user = p.getProperty("user1");
            String password = p.getProperty("password1");
            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();
            //获取输入
            getInput();
            //密码判断
            String SQL = "USE test";
            stmt.execute(SQL);
            SQL = "SELECT name,password FROM user";
            rs = stmt.executeQuery(SQL);
            while(rs.next()){
                if(rs.getString(1).equals(user_j) && rs.getString(2).equals(password_j)){
                    re = true;
                }
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
        return re;
    }
}
