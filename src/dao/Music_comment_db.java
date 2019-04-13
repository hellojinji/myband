package dao;

import domain.Music_comment;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Music_comment_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.105.136.116:3306/MYBAND?useSSL=false";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/MYBAND?useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2017211501";
    //static final String PASS = "zhw787374484";
    //获取评论数量
    public static int getMusic_comments_number(int music_id){
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
            String sql = "select count(*) from MYBAND.music_comments where music_id='"+music_id+"'";
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
    //获取评论根据点赞数排序从高到低
    public static Music_comment[] getMusic_comments_by_likes(int music_id){
        Connection conn = null;
        Statement stmt = null;
        int n=getMusic_comments_number(music_id);
        Music_comment[] comments=new Music_comment[n];
        for(int i=0;i<n;i++){
            comments[i]=new Music_comment();
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
            sql = "SELECT * FROM myband.music_comments where music_id='"+music_id+"' order by likes desc ";
            rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next()&&i<n) {
                // 通过字段检索
                comments[n].setId(rs.getInt("id"));
                comments[n].setContent(rs.getString("content"));
                comments[n].setMusic_id(rs.getInt("music_id"));
                comments[n].setUser_id(rs.getInt("user_id"));
                comments[n].setDate(rs.getString("date"));
                comments[n].setLikes(rs.getInt("likes"));
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
        return comments;
    }
    //获取评论根据日期排序从新到旧
    public static Music_comment[] getMusic_comments_by_date(int music_id){
        Connection conn = null;
        Statement stmt = null;
        int n=getMusic_comments_number(music_id);
        Music_comment[] comments=new Music_comment[n];
        for(int i=0;i<n;i++){
            comments[i]=new Music_comment();
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
            sql = "SELECT * FROM myband.music_comments where music_id='"+music_id+"' order by date ";
            rs = stmt.executeQuery(sql);
            int i=0;
            while (rs.next()&&i<n) {
                // 通过字段检索
                comments[n].setId(rs.getInt("id"));
                comments[n].setContent(rs.getString("content"));
                comments[n].setMusic_id(rs.getInt("music_id"));
                comments[n].setUser_id(rs.getInt("user_id"));
                comments[n].setDate(rs.getString("date"));
                comments[n].setLikes(rs.getInt("likes"));
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
        return comments;
    }
    //添加评论到数据库。
    public static void appendComment(String content, int music_id, int user_id){
        String sql = "insert into myband.music_comments (content,music_id,likes,date,user_id) values (?,?,?,?,?);";//数据库操作语句（插入）
        Connection conn = null;
        Statement stmt = null;
        java.util.Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String nowTime = sdf.format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp dates =Timestamp.valueOf(nowTime);//把时间转换
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pst = conn.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setString(1, content);
            pst.setInt(2, music_id);
            pst.setInt(3,0);
            pst.setTimestamp(4,dates);
            pst.setInt(5,user_id);
            pst.executeUpdate();//解释在下
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除评论的数据
    public static void deleteComment(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from music_comments where comment_id=?";
            // 预处理sql语句
            PreparedStatement presta = conn.prepareStatement(sql);
            // 设置sql语句中的values值
            presta.setInt(1,id);
            // 执行SQL语句，实现数据添加
            presta.execute();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
