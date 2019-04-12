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

    public int getId() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getNickName() {
    	return this.nickname;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public int getGender() {
    	return this.gender;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getAddress() {
    	return this.address;
    }
    
    public String getSignature() {
    	return this.signatrue;
    }
    
    public String getImageUrl() {
    	return this.image_url;
    }
    
    public String getIntroduction() {
    	return this.introduction;
    }
}
