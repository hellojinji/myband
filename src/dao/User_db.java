package dao;

import domain.User;

import java.sql.*;

public class User_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.105.136.116:3306/MYBAND?useSSL=false";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/MYBAND?useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2017211501";
    //static final String PASS = "zhw787374484";

    public static User getUserFromDB(int user_id){
        User target_user=new User();
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from MYBAND.user where user_id='"+user_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                target_user.setId(rs.getInt("user_id"));
                target_user.setName(rs.getString("name"));
                target_user.setNickname(rs.getString("nickname"));
                target_user.setPassword(rs.getString("password"));
                target_user.setEmail(rs.getString("email"));
                target_user.setAddress(rs.getString("address"));
                target_user.setIntroduction(rs.getString("introduction"));
                target_user.setImage_url(rs.getString("image_url"));
                target_user.setSignatrue(rs.getString("signature"));
                target_user.setGender(rs.getInt("gender"));
                n++;
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return target_user;
    }
}
