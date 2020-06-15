package eventManager;

public class Ticket
{
	String name,uid,branch;
	String ticketcost;
	Event bookedevent;
	Ticket(String name,String uid,String branch,Event bookedevent)
	{
		this.name=name;
		this.uid=uid;
		this.branch=branch;
		this.bookedevent=bookedevent;
		this.ticketcost=bookedevent.eventcost;
	}
	public String toString()
	{
		System.out.println("***Ticket***");
		return "Name: "+this.name+
		 "\nUID: "+this.uid+
		 "\nBranch: "+this.branch+
		 "\nEvent booked:"+ this.bookedevent.eventname +
		 "\nTicket cost: "+this.ticketcost+ " ";
	}

}