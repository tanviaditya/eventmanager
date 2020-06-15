package event;
import java.util.*;
import java.io.*;
public class myModel {
	private Scanner sc = new Scanner(System.in);
	String festname;
	static int ecount=0;
	ArrayList<Event> eventlist = new ArrayList<Event>();
	ArrayList<Manager>managerlist = new ArrayList<Manager>();
	ArrayList<Atendee>atendeelist = new ArrayList<Atendee>();
	myModel(String festname)
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

		String fileName = "eventsfile";

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
		Iterator<Event> i = eventlist.iterator();
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
		
		String fileName = "managerdata";
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
		String fileName = "atendeedata";
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
			FileReader filereader= new FileReader("managerdata");
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
			FileReader filereader= new FileReader("atendeedata");
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
		FileReader filereader= new FileReader("eventsfile");
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
		FileReader filereader= new FileReader("eventsfile");
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
