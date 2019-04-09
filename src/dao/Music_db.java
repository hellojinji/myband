package dao;
import domain.Music;
import domain.Music_comment;

import java.sql.*;

public class Music_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/myband";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "zhw787374484";
    //选出点赞量最高的三个音乐。
    public static Music[] getHotmusic(){
        Music[] music_group=new Music[3];
        music_group[0]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        music_group[1]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        music_group[2]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "select * from myband.music order by likes desc";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                music_group[n].setId(rs.getInt("music_id"));
                music_group[n].setLyrics(rs.getString("lyrics"));
                music_group[n].setProject_id(rs.getInt("project_id"));
                music_group[n].setGroup_id(rs.getInt("group_id"));
                music_group[n].setStyle(rs.getString("style"));
                music_group[n].setLikes(rs.getInt("likes"));
                music_group[n].setImage_url(rs.getString("image_url"));
                music_group[n].setMusic_url(rs.getString("music_url"));
                n++;
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
        return music_group;
    }
    //初始化音乐页面时所需函数，传递一个Music的对象。
    public static Music initMusic(int id){
        Music music=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM myband.music where music_id='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            music.setId(rs.getInt("music_id"));
            music.setLyrics(rs.getString("lyrics"));
            music.setProject_id(rs.getInt("project_id"));
            music.setGroup_id(rs.getInt("group_id"));
            music.setStyle(rs.getString("style"));
            music.setLikes(rs.getInt("likes"));
            music.setImage_url(rs.getString("image_url"));
            music.setMusic_url(rs.getString("music_url"));
            sql = "SELECT * FROM myband.music_comments where myband.music_comments.music_id='"+id+"' order by likes desc";
            rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            Music_comment[] music_comment_group=new Music_comment[3];
            while (rs.next()&&n<3) {
                // 通过字段检索
                music_comment_group[n].setId(rs.getInt("id"));
                music_comment_group[n].setContent(rs.getString("content"));
                music_comment_group[n].setMusic_id(rs.getInt("music_id"));
                music_comment_group[n].setUser_id(rs.getInt("user_id"));
                music_comment_group[n].setDate(rs.getString("date"));
                music_comment_group[n].setLikes(rs.getInt("likes"));
                n++;
            }
            music.setMusic_comments(music_comment_group);
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
        return music;
    }
    //插入music到Music数据库表。
    public static void appendMusic(int id, String lyrics, int project_id, int group_id, String style, int likes, String image_url, String music_url){
        Music newmusic=new Music(id, lyrics, project_id, group_id, style, likes, image_url, music_url);
        String sql = "insert into music values(?,?,?,?,?,?,?,?)";//数据库操作语句（插入）
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pst = conn.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setInt(1, newmusic.getId());
            pst.setString(2, newmusic.getLyrics());
            pst.setInt(3,newmusic.getProject_id());
            pst.setInt(4,newmusic.getGroup_id());
            pst.setString(5,newmusic.getStyle());
            pst.setString(6,newmusic.getImage_url());
            pst.setString(7,newmusic.getMusic_url());
            pst.executeUpdate();//解释在下
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//执行与数据库建立连接需要抛出SQL异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
