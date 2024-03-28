package Railway;

public class Passenger {
	
	private String name;
	private int age;
	private String status;
	private int berthNo;
	private String berthType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBerthNo() {
		return berthNo;
	}
	public void setBerthNo(int berthNo) {
		this.berthNo = berthNo;
	}
	public String getBerthType() {
		return berthType;
	}
	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}
	
	Passenger(String pName, int age, String pref)
	{
		this.name = pName;
		this.age = age;
		this.berthType = pref;
	}
	
	

}
