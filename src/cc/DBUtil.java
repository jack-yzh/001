package cc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    //数据库要操作的表
    public static final String TABLE_USERINFO = "userinfom";

    // connect to MySql database
    public static Connection getConnect() {
        //驱动地址，user为你数据库的名字
        String url = "jdbc:mysql://localhost:3306/sever";
        Connection connecter = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //数据库登录名和密码
            connecter = (Connection) DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return connecter;
    }}
