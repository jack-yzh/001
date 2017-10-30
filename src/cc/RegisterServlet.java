package cc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String code = "";
        String message = "";

        //获取你请求地址中account和password、sex、academic字段的值
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //System.out.println(account + password);
        Connection connection = DBUtil.getConnect();
        try {

            Statement statement  = connection.createStatement();

            String sqlQuery = "select account from " + DBUtil.TABLE_USERINFO + " where account='" + account + "'";

            ResultSet result =  statement.executeQuery(sqlQuery);


            if(result.next()){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().append("哈哈哈哈啊哈");

//                code = "100";
//                message = "账号已存在！";

            }else{
                String sqlInsert = "insert into " + DBUtil.TABLE_USERINFO  + "(account, password) values('"
                        + account + "', '" + password + "')";
                int resultl = statement.executeUpdate(sqlInsert);
                if(resultl > 0){
                    code = "200";
                    message = "注册成功！";
                }else{
                    code = "300";
                    message = "注册失败";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String code = "";
        String message = "";

        //获取你请求地址中account和password、sex、academic字段的值
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        //System.out.println(account + password);
        Connection connection = DBUtil.getConnect();
        try {

            Statement statement  = connection.createStatement();

            String sqlQuery = "select account from " + DBUtil.TABLE_USERINFO + " where account='" + account + "'";

            ResultSet result =  statement.executeQuery(sqlQuery);


            if(result.next()){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().append("哈哈哈哈啊哈");

//                code = "100";
//                message = "账号已存在！";

            }else{
                String sqlInsert = "insert into " + DBUtil.TABLE_USERINFO  + "(account, password) values('"
                        + account + "', '" + password + "')";
                int resultl = statement.executeUpdate(sqlInsert);
                if(resultl > 0){
                    code = "200";
                    message = "注册成功！";
                }else{
                    code = "300";
                    message = "注册失败";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
