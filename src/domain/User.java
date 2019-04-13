package domain;

public class User {
    private int id;
    private String name;
    private String nickname;
    private String password;
    private int gender;
    private String email;
    private String address;
    private String signatrue;
    private String image_url;
    private String introduction;

    public User(int id, String name, String nickname, String password, int gender, String email, String address, String signatrue, String image_url, String introduction) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.signatrue = signatrue;
        this.image_url = image_url;
        this.introduction = introduction;
    }

    public User(){
        this(0,"name","nickname","password",0,"email","address","signature","image_url","introduction");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignatrue() {
        return signatrue;
    }

    public void setSignatrue(String signatrue) {
        this.signatrue = signatrue;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
