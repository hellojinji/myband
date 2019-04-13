package domain;

public class Group {
	private int id;
	private String name;
	private String introduction;
	private int num;//成员数
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction=introduction;
	}
	
	public String getIntroduction() {
		return this.introduction;
	}
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return this.num;
	}
}
