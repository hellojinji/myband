package dao;

import domain.Project;

import java.sql.*;

public class Project_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.105.136.116:3306/MYBAND?useSSL=false";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/MYBAND?useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2017211501";
    //static final String PASS = "zhw787374484";

    //根据project_id查找project
    public static Project getProjectFromDB(int project_id){
        Project target_project=new Project();
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from MYBAND.project where project_id='"+project_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                target_project.setProject_id(rs.getInt("project_id"));
                target_project.setGroup_id(rs.getInt("group_id"));
                target_project.setName(rs.getString("name"));
                target_project.setStyle(rs.getString("style"));
                target_project.setIntroduction(rs.getString("introduction"));
                target_project.setImage_url(rs.getString("image_url"));
                target_project.setMusic_url(rs.getString("music_url"));
                target_project.setOpern_url(rs.getString("opern_url"));
                target_project.setStatus(rs.getInt("status"));
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
        return target_project;
    }
    //测试用主函数
    public static void main(String[] args){
        System.out.println(getProjectFromDB(1).toString());
    }
}
