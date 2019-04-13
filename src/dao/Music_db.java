package dao;
import domain.Music;
import domain.Music_comment;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Music_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://39.105.136.116:3306/MYBAND?useSSL=false";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/MYBAND?useSSL=false";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "2017211501";
    //static final String PASS = "zhw787374484";

    //选出点赞量最高的三个音乐。
    public static Music[] getHotmusic(){
        Music[] music_group=new Music[3];
        for(int i=0;i<3;i++){
            music_group[i]=new Music();
        }
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
    //删除音乐数据
    public static void deleteMusic(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from music where music_id=?";
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
    //返回num个风格与id为music_id相似的音乐的信息的结构体。
    public static Music[] getlikes(int music_id,int num){
        Connection conn = null;
        Statement stmt = null;
        Music[] similar_musics=new Music[num];
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from MYBAND.music where style=(SELECT style FROM MYBAND.music where music_id='"+music_id+"') and music_id!='1' order by likes desc";
            // 预处理sql语句
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()&&n<num) {
                // 通过字段检索
                similar_musics[n].setId(rs.getInt("music_id"));
                similar_musics[n].setLyrics(rs.getString("lyrics"));
                similar_musics[n].setProject_id(rs.getInt("project_id"));
                similar_musics[n].setGroup_id(rs.getInt("group_id"));
                similar_musics[n].setStyle(rs.getString("style"));
                similar_musics[n].setLikes(rs.getInt("likes"));
                similar_musics[n].setImage_url(rs.getString("image_url"));
                similar_musics[n].setMusic_url(rs.getString("music_url"));
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
        return similar_musics;
    }
    //返回相应的ID的music的信息。
    public static Music getMusicFromDB(int music_id){
        Music target_music=new Music();
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from MYBAND.music where music_id='"+music_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                target_music.setId(rs.getInt("music_id"));
                target_music.setLyrics(rs.getString("lyrics"));
                target_music.setProject_id(rs.getInt("project_id"));
                target_music.setGroup_id(rs.getInt("group_id"));
                target_music.setStyle(rs.getString("style"));
                target_music.setLikes(rs.getInt("likes"));
                target_music.setImage_url(rs.getString("image_url"));
                target_music.setMusic_url(rs.getString("music_url"));
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
        return target_music;
    }
    //测试用主函数
    public static void main(String[] args){
        System.out.println(getMusicFromDB(1).toString());
    }
}
