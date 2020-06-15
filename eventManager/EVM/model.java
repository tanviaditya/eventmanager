import java.util.*;
import java.io.*;
class model{
	public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	MyModel m = new MyModel("Oculus");
	System.out.println("Register Menu");
	//Create two register options 
	//Student register as manager and atendee
	int access=0; //access=1 for manager and access=2 for atendee
	//Atendee a;
	String name,uid,branch;
	do{
	System.out.println("Login as \n 1]Manager\n 2]Atendee");
	switch(sc.nextInt())
	{
		case 1:
		if(m.ManagerLogin()==true)
		{
			System.out.println("Login as a manager succesful...");
			access=1;//this will give access to the user as a manager
		}
		else
		{
			System.out.println("Please enter proper uid and password");

		}
		break;
		case 2:
		System.out.println("Enter name");
		name=sc.next();
		System.out.println("Enter UID");
		uid=sc.next();
		System.out.println("Enter branch");
		branch=sc.next();
		if(m.AtendeeLogin(name,uid,branch)==true)
		{
			System.out.println("Login as an atendee succesful...");
			access=2;
		}
		else
		{
			System.out.println("Please enter proper information");
		}
		break;
	}
	}while(access!=1 && access!=2);
	//Login and if password matches then give access

	int flag=1;
	while(flag!=0 && access==1)
	{	System.out.println("=======Menu=======");
		System.out.println("==================");
		System.out.println("Enter option:");
		System.out.println("1]Add event");//add event into the arraylist and also file
		System.out.println("2]View recently added events");//read from arraylist
		System.out.println("3]View all the events");//read from file
		System.out.println("4]Delete recently added event");//delete from arraylist
		System.out.println("5]Delete previously added event");//delete from file
		System.out.println("6]Create Manager");//create manager and add in file
		System.out.println("7]Create Atendee");//create atendee and add in file
		System.out.println("8]Delete Atendee");
		System.out.println("0]Exit");
		System.out.println("=================");
		int c = sc.nextInt();
		switch(c)
		{
			case 1:
			m.addEvent();
			break;
			case 2:
			m.viewevents();
			break;
			case 3:
			System.out.println("Events of Oculus 2020!!!");
			System.out.println("=============");
			m.viewAllEvents();
			break;
			case 4:
			System.out.println("Enter the event id of the event you wish to delete");
			m.deleteEvent(sc.next());
			break;
			case 5:
			System.out.println("Enter the event id of the event you wish to delete");
			//m.deleteFromFile(sc.next());
			break;
			case 6:
			m.createManager();
			break;
			case 7:
			m.createAtendee();
			break;
			case 0:
			flag=0;
		} 
	}
	while(flag!=0 && access==2)
	{ 
		System.out.println("=======Menu=======");
		System.out.println("=================");
		System.out.println("Enter option:");
		System.out.println("1]Book an event");
		System.out.println("2]View all events");
		System.out.println("0]Exit");
		System.out.println("=================");
		int c = sc.nextInt();
		switch(c)
		{
			case 1:
			String aname,auid,abranch;
			System.out.println("Re-enter your correct information");
			System.out.println("Enter name");
			aname=sc.next();
			System.out.println("Enter UID");
			auid=sc.next();
			System.out.println("Enter branch");
			abranch=sc.next();
			m.bookEvent(aname,auid,abranch);
			break;
			case 2:
			System.out.println("Events of Oculus 2020!!!");
			System.out.println("=============");
			m.viewAllEvents();
			break;
			case 0:
			flag=0;
			break;
		} 
	}
	System.out.println("Exiting the program..");
	}
}
class MyModel{
	private Scanner sc = new Scanner(System.in);
	String festname;
	static int ecount=0;
	ArrayList<Event> eventlist = new ArrayList<Event>();
	ArrayList<Manager>managerlist = new ArrayList<Manager>();
	ArrayList<Atendee>atendeelist = new ArrayList<Atendee>();
	MyModel(String festname)
	{
		this.festname=festname;
	}
	void addEvent()
	{
		String eventname,eventid,eventcost,locid,stime,etime;
		System.out.println("Enter event name");
		eventname=sc.next();
		System.out.println("Enter event id");
		eventid=sc.next();
		System.out.println("Enter event cost");
		eventcost=sc.next();
		System.out.println("Enter loaction required");
		locid=sc.next();
		System.out.println("Enter start time");
		stime=sc.next();
		System.out.println("Enter end time");
		etime=sc.next();
		Event e=new Event(eventname,eventid,eventcost,locid,stime,etime);
		eventlist.add(e);
		System.out.println("Event Added.");

		String fileName = "eventsfile.txt";

        try {
            FileWriter fileWriter =
                new FileWriter(fileName,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(e.eventname);
            bufferedWriter.write(" "+e.eventid);
            // 
            bufferedWriter.write(" "+ e.eventcost);
            bufferedWriter.write(" "+ e.locid);
            bufferedWriter.write(" "+ e.stime);
            bufferedWriter.write(" "+ e.etime);

            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
	}
	void viewevents()
	{
		for(Event event : eventlist)
		{
			System.out.print(++ecount +"]");
			event.display_event();
		}
		ecount=0;
	}
	void deleteEvent(String eid)
	{
		Iterator i = eventlist.iterator();
      	Event event;
     	while (i.hasNext()) {
        	event = (Event) i.next();
         	if (event.eventid.equals(eid)) {
            i.remove();
            System.out.println("The event is removed");
            break;
        	}
    	}
 
	}
	void createManager()
	{
		String name,uid,branch,password;
		System.out.println("Enter your full name");
		name=sc.next();
		System.out.println("Enter your UID");
		uid=sc.next();
		System.out.println("Enter your branch");
		branch=sc.next();
		System.out.println("Create a password");
		password=sc.next();
		Manager m=new Manager(name,uid,branch,password);
		managerlist.add(m);
		System.out.println("Your account has been created...");
		
		String fileName = "managerdata.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(uid+" ");
            bufferedWriter.write(password);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }


	}
	void createAtendee()
	{
		String name,uid,branch;
		System.out.println("Enter your full name");
		name=sc.next();
		System.out.println("Enter your UID");
		uid=sc.next();
		System.out.println("Enter your branch");
		branch=sc.next();
		Atendee a=new Atendee(name,uid,branch);
		atendeelist.add(a);
		System.out.println("Your account has been created...");
		String fileName = "atendeedata.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(name+" ");                
            bufferedWriter.write(uid+" ");
            bufferedWriter.write(branch+" ");
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
    }
    void deleteEventFromFile(String eid)
	{
		
	}
	void deleteAtendeeFromFile()
	{

	}
	boolean ManagerLogin()
	{
		boolean flag=false;
		try{
		String uid,password;
		String[] arr;
		System.out.println("Enter UID");
		uid=sc.next();
		System.out.println("Enter password");
		password=sc.next();
			FileReader filereader= new FileReader("managerdata.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(uid) && arr[1].equals(password))
					{
						flag=true;
					}
				line = reader.readLine();
			}
			reader.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			return flag;
		}
	}
	boolean AtendeeLogin(String name,String uid, String branch)
	{
		boolean flag=false;
		try{
			String[] arr;
			FileReader filereader= new FileReader("atendeedata.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(name) && arr[1].equals(uid) && arr[2].equals(branch))
					{
						flag=true;
					}
				line = reader.readLine();
			}
			reader.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			return flag;
		}
	}
	void viewAllManagers()
	{
		//read the file managerdata
	}
	void viewAllAtendee()
	{
		//read the file atendeedata
	}
	void bookEvent(String studentname,String uid,String branch)
	{
		String eventname;
		String arr[];
		System.out.println("Enter the event name you want to book: ");
		eventname=sc.next();
		try{
		FileReader filereader= new FileReader("eventsfile.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(eventname))
					{
						Event etemp=new Event(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
						Ticket t = new Ticket(studentname,uid,branch,etemp);
			//creating a ticket
					System.out.println("Event booked...");
			//printing the ticket
					System.out.println("Collect your ticket");
					System.out.println(t);
					break;
					}
				line = reader.readLine();
			}
			reader.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	void viewAllEvents()
	{
		String arr[];
		try{
		FileReader filereader= new FileReader("eventsfile.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				System.out.println("Event Name:" +arr[0]);
				System.out.println("Location: "+arr[3]);
				System.out.println("Start time: "+arr[4]);
				System.out.println("End time: "+arr[5]);
				System.out.println("============");
				line = reader.readLine();
			}
			reader.close();
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Event implements Serializable{
	String eventname,eventid,eventcost,locid,stime,etime;
	Event(String eventname,String eventid,String eventcost,String locid,String stime,String etime)
	{
		this.eventname=eventname;
		this.eventid=eventid;
		this.eventcost=eventcost;
		this.locid=locid;
		this.stime=stime;
		this.etime=etime;
	}
   void display_event()
   {
   		System.out.println("Event Name:"+this.eventname+
                    " eventid: "+ this.eventid +
                    " eventcost: "+ this.eventcost +
                    " locid : " + this.locid);
   }
   public String toString()
   {
   	return "Event Name:"+this.eventname+
                    " eventid: "+ this.eventid +
                    " eventcost: "+ this.eventcost +
                    " locid : " + this.locid; 
   }
}
class Student{
	String name,uid,branch;
	Student(String name,String uid,String branch)
	{
		this.name=name;
		this.uid=uid;
		this.branch=branch;
	}
}
class Manager extends Student{
	String name,uid,branch,password;
	boolean isManager;
	Manager(String name,String uid,String branch,String password)
	{
		super(name,uid,branch);
		this.password=password;
		this.isManager=true;
	}
}
class Atendee extends Student{
	String name,uid,branch;
	boolean isManager;
	Atendee(String name,String uid,String branch)
	{
		super(name,uid,branch);
		this.isManager=false;
	}
}
class Ticket
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
