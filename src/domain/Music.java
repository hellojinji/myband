package domain;

import java.util.Arrays;

public class Music {
    private int id;//ID
    private String lyrics;//歌词
    private int project_id;//所属项目的ID
    private int group_id;//所属小组的ID
    private String style;//风格
    private int likes;//点赞数
    private String image_url;//封面
    private String music_url;//音乐文件
    //private Music_comment[] music_comments;//评论应该单独出来

    public Music(int id, String lyrics, int project_id, int group_id, String style, int likes, String image_url, String music_url) {
        this.id = id;
        this.lyrics = lyrics;
        this.project_id = project_id;
        this.group_id = group_id;
        this.style = style;
        this.likes = likes;
        this.image_url = image_url;
        this.music_url = music_url;
    }

    public Music(int id, String lyrics, int project_id, int group_id, String style, int likes, String image_url, String music_url, Music_comment[] music_comments) {
        this.id = id;
        this.lyrics = lyrics;
        this.project_id = project_id;
        this.group_id = group_id;
        this.style = style;
        this.likes = likes;
        this.image_url = image_url;
        this.music_url = music_url;
        //this.music_comments = music_comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getMusic_url() {
        return music_url;
    }

    public void setMusic_url(String music_url) {
        this.music_url = music_url;
    }

    /*
    public Music_comment[] getMusic_comments() {
        return music_comments;
    }

    public void setMusic_comments(Music_comment[] music_comments) {
        this.music_comments = music_comments;
    }
    */

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", lyrics='" + lyrics + '\'' +
                ", project_id=" + project_id +
                ", group_id=" + group_id +
                ", style='" + style + '\'' +
                ", likes=" + likes +
                ", image_url='" + image_url + '\'' +
                ", music_url='" + music_url + '\'' +
                ", music_comments=" + Arrays.toString(music_comments) +
                '}';
    }
}

