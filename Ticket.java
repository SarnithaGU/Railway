package Railway;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	static int pnrNos = 1001;
	
	int PNR;
	List<Passenger> passengers;
	
	public Ticket(Passenger p)
	{
		this.passengers = new ArrayList<>();
		this.PNR = pnrNos++;
		passengers.add(p);
	}
	
	
	public Ticket(List<Passenger> passengers2) {
		
		
	}


	public static boolean blockSeats(List<Cabin> coach, Passenger p) {
		int ct = 0;
		for(Cabin c : coach)
		{
			for(Berth b : c.getBerths())
			{
				if(b.getBerthType()!=null && b.getBerthType().equals(p.getBerthType())  && b.getStatus().equals("AVL"))
				{
					b.setAge(p.getAge());
					b.setName(p.getName());
					b.setStatus("CNF");
					p.setStatus(b.getStatus());
					p.setBerthNo(b.getBerthNo());
					p.setBerthType(b.getBerthType());
					ct++;
//					break;
				}
				if(ct>0)
				{
					return true;
				}
			}
		}
		
		return false;
		
	}
	public static boolean blockSeats(Passenger p, List<Cabin> coach) {
		int ct = 0;
		for(Cabin c : coach)
		{
			for(Berth b : c.getBerths())
			{
				if(p.getAge()>60)
				{
					if(b.getStatus()=="AVL" && b.getBerthType()=="LB")
					{
						b.setAge(p.getAge());
						b.setName(p.getName());
						b.setStatus("CNF");
						p.setStatus(b.getStatus());
						p.setBerthNo(b.getBerthNo());
						p.setBerthType(b.getBerthType());
						ct++;
					}
				}
				else
				{
					if(b.getStatus()=="AVL")
					{
						b.setAge(p.getAge());
						b.setName(p.getName());
						b.setStatus("CNF");
						p.setStatus(b.getStatus());
						p.setBerthNo(b.getBerthNo());
						p.setBerthType(b.getBerthType());
						ct++;
//						break;
					}
				}
				if(ct>0)
				{
					return true;
				}
			}
		}
		
		return false;
		
	}


	public static void printPnrDetails(List<Ticket> tic,int pnr2) {
		
		for(Ticket t : tic)
		{
			if(t.PNR == pnr2)
			{
				System.out.println("PNR NO: "+pnr2);
				for(Passenger p : t.passengers)
				{
					System.out.print(p.getName()+" | "+p.getAge()+" | "+p.getStatus()+" | ");
					System.out.println(p.getBerthNo()+" | "+p.getBerthType());
					System.out.println("----------------------------------");
				}
			}
		}
	}

}
