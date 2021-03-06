package domain;

import java.util.Arrays;

public class Music {
    private int id;
    private String lyrics;
    private int project_id;
    private int group_id;
    private String style;
    private int likes;
    private String image_url;
    private String music_url;

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

    public Music(){
        this(0,"lyrics",0,0,"style",0,"image_url","music_url");
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
                ", music_url='" + music_url  +
                '}';
    }
}
