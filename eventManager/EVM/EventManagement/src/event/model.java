package event;
import java.util.*;
import java.io.*;
public class model {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		myModel m = new myModel("Oculus");
		System.out.println("Register Menu");
		//Create two register options 
		//Student register as manager and atendee
		int access=0; //access=1 for manager and access=2 for atendee
		//Atendee a;
		String name,uid,branch;
		try{
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
			System.out.println("6]Create Manager");//create manager and add in file
			System.out.println("7]Create Atendee");//create atendee and add in file
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
	}
	catch(Exception e) {System.out.println(e);}
		System.out.println("Exiting the program..");
	}
}
