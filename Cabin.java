package Railway;

import java.util.ArrayList;
import java.util.List;

public class Cabin {
	
	static int cabinNo = 1;
	private int cn;
	List<Berth> berths;
	
	public List<Berth> getBerths() {
		return berths;
	}
	public void setBerths(List<Berth> berths) {
		this.berths = new ArrayList<>();
	}
	
	public Cabin()
	{
		this.cn = cabinNo++;
		this.berths = new ArrayList<>();
		for(int i=1;i<=9;i++)
		{
			if(i==1 || i==4)
			{
				Berth berth = new Berth(i,"LB");
				this.berths.add(berth);
			}
			if(i==2 || i==5)
			{
				Berth berth = new Berth(i,"MB");
				berths.add(berth);
			}
			if(i==3 || i==6)
			{
				Berth berth = new Berth(i,"UB");
				berths.add(berth);
			}
			if(i==8)
			{
				Berth berth = new Berth(i,"SU");
				this.berths.add(berth);
			}
			if(i==7)
			{
				Berth berth1 = new Berth(i,"SL", "RAC1");
				Berth berth2 = new Berth(i,"SL", "RAC2");
				berths.add(berth1);
				berths.add(berth2);
			}
			if(1==8 || i==9)
			{
				Berth berth = new Berth("WL");
				berths.add(berth);
			}
		}
	}
	public static void printCabinDetails(Cabin cabin) {
		System.out.println("Cabin no: "+cabin.cn);
		for(Berth ber : cabin.berths)
		{
			
//			System.out.print(ber.getPNR()+" | "+ber.getBerthNo()+" | "+ber.getStatus()+" | ");
//			System.out.print(ber.getBerthType()+" | "+ber.getName());
			
			Berth.printBerthDetails(ber);
		}
		
	}

}
