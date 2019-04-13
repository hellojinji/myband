package domain;

public class Project {
    private int project_id;
    private int group_id;
    private String name;
    private String style;
    private String introduction;
    private String music_url;
    private String image_url;
    private String opern_url;
    private int status;

    public Project(int project_id, int group_id, String name, String style, String introduction, String music_url, String image_url, String opern_url, int status) {
        this.project_id = project_id;
        this.group_id = group_id;
        this.name = name;
        this.style = style;
        this.introduction = introduction;
        this.music_url = music_url;
        this.image_url = image_url;
        this.opern_url = opern_url;
        this.status = status;
    }

    public Project(){
        this(0,0,"name","style","introdution","music_url","image_url","opern_url",0);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMusic_url() {
        return music_url;
    }

    public void setMusic_url(String music_url) {
        this.music_url = music_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getOpern_url() {
        return opern_url;
    }

    public void setOpern_url(String opern_url) {
        this.opern_url = opern_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
