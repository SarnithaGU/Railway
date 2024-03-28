package Railway;
import java.util.*;
public class Main {
	
	public static void printDash()
	{
		System.out.println("-------------------------");
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to  Railways");
		printDash();
		System.out.println("Initialize the Train.. ");
		System.out.println("Enter the number of cabins in each coach: ");
		
		int nc = sc.nextInt();
		List<Cabin> coach = new ArrayList<>();
		for(int i=0;i<nc;i++)
		{
			Cabin cabin = new Cabin();
			coach.add(cabin);
		}
		printDash();
		boolean active = true;
//		for(Cabin c : coach)
//		{
//			Cabin.printCabinDetails(c);
//		}
		
		List<Ticket> tickets = new ArrayList<>();
		
		while(active == true)
		{
			System.out.println("Welcome to booking!");
			System.out.println("Enter 0 -> Print Berth details");
			System.out.println("Enter 1 -> Book Ticket");
			System.out.println("Enter 2 -> Print PNR details");
			System.out.println("Enter 3 -> For group booking");
			
			System.out.println("Enter 9 -> Exit");
			
			int inp = sc.nextInt();
			switch(inp)
			{
			case 0:
			{
				for(Cabin c : coach)
				{
					Cabin.printCabinDetails(c);
				}
				break;
			}
				
			case 1:
				System.out.println("Enter the name of Passenger ");
				String pName = sc.next();
				System.out.println("Enter age of Passenger ");
				int age = sc.nextInt();
				System.out.println("Enter berth preference: ");
				String pref = sc.next();
				Passenger p = new Passenger(pName, age, pref);
				boolean isBooked = true;
				if(pref.isEmpty() || pref.equalsIgnoreCase("na"))
				{
					isBooked = Ticket.blockSeats(p, coach);
				}
				else
				{
					isBooked = Ticket.blockSeats(coach, p);
				}
				
				
				if(isBooked)
				{
					Ticket t = new Ticket(p);
					tickets.add(t);
					System.out.println("Ticket Successfully booked");
				}
				else
				{
					System.out.println("Berth preferences no met.. Do you want to proceed?");
					int pr = sc.nextInt();
					if(pr==1)
					{
						boolean isB = Ticket.blockSeats(p, coach);
						if(isB)
						{
							System.out.println("Ticket Successfully booked");
						}
						else
						{
							System.out.println("Not available");
						}
					}
					else
					{
						System.out.println("Tickets not available");
					}
					
				}
				
				
				break;
				
			case 2:
				
				System.out.println("Enter PNR number: ");
				int pnr = sc.nextInt();
				Ticket.printPnrDetails(tickets, pnr);
				break;
				
			case 3:
				List<Passenger> passengers = new ArrayList<>();
				System.out.println("Enter number of tickets to book: ");
				int nt = sc.nextInt();
				for(int i=1;i<=nt;i++)
				{
					System.out.println("Enter the name of Passenger "+i);
					String pN = sc.next();
					System.out.println("Enter age of Passenger "+i);
					int pA = sc.nextInt();
					System.out.println("Enter berth preference: ");
					String pP = sc.next();
					Passenger pp = new Passenger(pN, pA, pP);
					passengers.add(pp);
				}
				int bookedCount = 0;
				int passengerCount = passengers.size();
				for(Passenger pc : passengers)
				{
					if(pc.getAge()<=5)
					{
						continue;
					}
					boolean isB = Ticket.blockSeats(coach, pc);
					if(isB)
					{
						continue;
					}
					else
					{
						System.out.println("Berth preferences not met.. Do you want to proceed?");
						int pr = sc.nextInt();
						if(pr==1)
						{
							boolean isBB = Ticket.blockSeats(pc, coach);
							if(isBB)
							{
								continue;
							}
							else
							{
								System.out.println("Not available");
							}
						}
						else
						{
							System.out.println("Tickets not available");
						}
					}
				}
				if(bookedCount == passengerCount)
				{
					Ticket t = new Ticket(passengers);
					tickets.add(t);
					System.out.println("Ticket Successfully booked");
				}
				break;
				
				
			case 9:
				System.out.print("Exitting....");
				active = false;
				break;
				
				
			}
		}
		
	}

}
