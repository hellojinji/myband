package domain;

public class Group {
    private int group_id;
    private String name;
    private String introduction;
    private int number;


    public Group(int group_id, String name, String introduction, int number) {
        this.group_id = group_id;
        this.name = name;
        this.introduction = introduction;
        this.number = number;
    }

    public Group(){
        this(0,"name","introduction",0);
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
