package Railway;

public class Berth {
	
	private int PNR;
	private int berthNo;
	private String status;
	private String berthType;
	private String name;
	private int age;
	
	public int getPNR() {
		return PNR;
	}
	public void setPNR(int pNR) {
		PNR = pNR;
	}
	public int getBerthNo() {
		return berthNo;
	}
	public void setBerthNo(int berthNo) {
		this.berthNo = berthNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBerthType() {
		return berthType;
	}
	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}
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
	
	public Berth(int bNo, String bType)
	{
		this.setBerthNo(bNo);
		this.setBerthType(bType);
		this.setStatus("AVL");
	}
	
	Berth(String status)
	{
		this.status = "WL";
	}
	
	Berth(int bNo, String bType, String status)
	{
		this.setBerthNo(bNo);
		this.setBerthType(bType);
		this.setStatus("RAC");
	}
	
	public static void printBerthDetails(Berth ber)
	{
		System.out.print(ber.PNR+" | "+ber.berthNo+" | "+ber.status+" | ");
		System.out.println(printName(ber.getBerthType()) +" | "+printName(ber.getName())+" | "+printAge(ber.getAge()));
	}
	
	public static String printName(String name)
	{
		if(name == null || name.isEmpty())
		{
			return "-";
		}
		return name;
	}
	public static String printAge(int age)
	{
		if(age ==0)
		{
			return "-";
		}
		return String.valueOf(age);
	}
	

}
