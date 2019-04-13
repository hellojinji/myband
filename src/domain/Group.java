package domain;

public class Group {
    private int group_id;
    private String name;
    private String introduction;

    public Group(int group_id, String name, String introduction) {
        this.group_id = group_id;
        this.name = name;
        this.introduction = introduction;
    }

    public Group(){
        this(0,"name","introduction");
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
