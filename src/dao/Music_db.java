package dao;
import domain.Music;
import domain.Music_comment;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Music_db {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/myband";
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "zhw787374484";
    //ѡ����������ߵ��������֡�
    public static Music[] getHotmusic(){
        Music[] music_group=new Music[3];
        music_group[0]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        music_group[1]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        music_group[2]=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        Connection conn = null;
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // ִ�в�ѯ
            stmt = conn.createStatement();
            String sql;
            sql = "select * from myband.music order by likes desc";
            ResultSet rs = stmt.executeQuery(sql);
            int n=0;
            // չ����������ݿ�
            while (rs.next()) {
                // ͨ���ֶμ���
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
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // ���� JDBC ����
            se.printStackTrace();
        } catch (Exception e) {
            // ���� Class.forName ����
            e.printStackTrace();
        } finally {
            // �ر���Դ
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// ʲô������
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return music_group;
    }
    //��ʼ������ҳ��ʱ���躯��������һ��Music�Ķ���
    public static Music initMusic(int id){
        Music music=new Music(12,"dhe",21,212,"edw",21,"dwdq","dqd");
        Connection conn = null;
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // ִ�в�ѯ
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
            // չ����������ݿ�
            Music_comment[] music_comment_group=new Music_comment[3];
            while (rs.next()&&n<3) {
                // ͨ���ֶμ���
                music_comment_group[n].setId(rs.getInt("id"));
                music_comment_group[n].setContent(rs.getString("content"));
                music_comment_group[n].setMusic_id(rs.getInt("music_id"));
                music_comment_group[n].setUser_id(rs.getInt("user_id"));
                music_comment_group[n].setDate(rs.getString("date"));
                music_comment_group[n].setLikes(rs.getInt("likes"));
                n++;
            }
            music.setMusic_comments(music_comment_group);
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // ���� JDBC ����
            se.printStackTrace();
        } catch (Exception e) {
            // ���� Class.forName ����
            e.printStackTrace();
        } finally {
            // �ر���Դ
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// ʲô������
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return music;
    }
    //����music��Music���ݿ��
    public static void appendMusic(int id, String lyrics, int project_id, int group_id, String style, int likes, String image_url, String music_url){
        Music newmusic=new Music(id, lyrics, project_id, group_id, style, likes, image_url, music_url);
        String sql = "insert into music values(?,?,?,?,?,?,?,?)";//���ݿ������䣨���룩
        Connection conn = null;
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pst = conn.prepareStatement(sql);//����ִ��SQL����ѯ����sql������Ԥ���봦��
            pst.setInt(1, newmusic.getId());
            pst.setString(2, newmusic.getLyrics());
            pst.setInt(3,newmusic.getProject_id());
            pst.setInt(4,newmusic.getGroup_id());
            pst.setString(5,newmusic.getStyle());
            pst.setString(6,newmusic.getImage_url());
            pst.setString(7,newmusic.getMusic_url());
            pst.executeUpdate();//��������
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //ɾ����������
    public static void deleteMusic(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from music where music_id=?";
            // Ԥ����sql���
            PreparedStatement presta = conn.prepareStatement(sql);
            // ����sql����е�valuesֵ
            presta.setInt(1,id);
            // ִ��SQL��䣬ʵ���������
            presta.execute();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //������۵����ݿ⡣
    public static void appendComment(String content, int music_id, int user_id){
        String sql = "insert into myband.music_comments (content,music_id,likes,date,user_id) values (?,?,?,?,?);";//���ݿ������䣨���룩
        Connection conn = null;
        Statement stmt = null;
        Date date = new Date();//���ϵͳʱ��.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        String nowTime = sdf.format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
        Timestamp dates =Timestamp.valueOf(nowTime);//��ʱ��ת��
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pst = conn.prepareStatement(sql);//����ִ��SQL����ѯ����sql������Ԥ���봦��
            pst.setString(1, content);
            pst.setInt(2, music_id);
            pst.setInt(3,0);
            pst.setTimestamp(4,dates);
            pst.setInt(5,user_id);
            pst.executeUpdate();//��������
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //ɾ�����۵�����
    public static void deleteComment(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");

            // ������
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "delete from music_comments where comment_id=?";
            // Ԥ����sql���
            PreparedStatement presta = conn.prepareStatement(sql);
            // ����sql����е�valuesֵ
            presta.setInt(1,id);
            // ִ��SQL��䣬ʵ���������
            presta.execute();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {//ִ�������ݿ⽨��������Ҫ�׳�SQL�쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
