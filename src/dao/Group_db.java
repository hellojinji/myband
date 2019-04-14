package dao;

import domain.Group;
import domain.Project;

import java.sql.*;

public class Group_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.105.136.116:3306/MYBAND?useSSL=false";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/MYBAND?useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2017211501";
    //static final String PASS = "zhw787374484";

    //获取小组人数
    public static int getGroup_members_number(int group_id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        int num=0;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select count(*) from MYBAND.group_members where group_id='"+group_id+"'";
            rs = stmt.executeQuery(sql);
            // 完成后关闭
            while (rs.next()){
                num=rs.getInt(1);
            }
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
        return num;
    }
    //获取小组信息
    public static Group getGroupFromDB(int group_id){
        Group target_group=new Group();
        Connection conn = null;
        Statement stmt = null;
        target_group.setNumber(getGroup_members_number(group_id));
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from MYBAND.group where group_id='"+group_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                target_group.setGroup_id(rs.getInt("group_id"));
                target_group.setName(rs.getString("name"));
                target_group.setIntroduction(rs.getString("introduction"));
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
        return target_group;
    }
    //获取小组成员id
    public static int[] getGroup_members_id(int group_id){
        Connection conn = null;
        Statement stmt = null;
        int num=getGroup_members_number(group_id);
        int[] group_members_id=new int[num];
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select user_id from MYBAND.group_members where group_id='"+group_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()&&n<num) {
                // 通过字段检索
                group_members_id[n]=rs.getInt(1);
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
        return group_members_id;
    }
    //获取小组项目数
    public static int getGroup_projects_number(int group_id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        int num=0;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select count(*) from MYBAND.project where group_id='"+group_id+"'";
            rs = stmt.executeQuery(sql);
            // 完成后关闭
            while (rs.next()){
                num=rs.getInt(1);
            }
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
        return num;
    }
    //返回小组的项目
    public static Project[] getGroup_projects(int group_id){
        Connection conn = null;
        Statement stmt = null;
        int n=getGroup_projects_number(group_id);
        Project[] projects=new Project[n];
        for(int i=0;i<n;i++){
            projects[i]=new Project();
        }
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            ResultSet rs;
            sql = "SELECT * FROM myband.project where group_id='"+group_id+"' order by date ";
            rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next()&&i<n) {
                // 通过字段检索
                projects[n].setProject_id(rs.getInt("project_id"));
                projects[n].setGroup_id(rs.getInt("group_id"));
                projects[n].setName(rs.getString("name"));
                projects[n].setStyle(rs.getString("style"));
                projects[n].setIntroduction(rs.getString("introduction"));
                projects[n].setImage_url(rs.getString("image_url"));
                projects[n].setMusic_url(rs.getString("music_url"));
                projects[n].setOpern_url(rs.getString("opern"));
                projects[n].setStatus(rs.getInt("status"));
                i++;
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return projects;
    }
    //没用（复制代码使用）
    public static ResultSet getResult(String sql){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        int num=0;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
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
        return rs;
    }
}
