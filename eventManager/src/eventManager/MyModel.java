package eventManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyModel{
	private Scanner sc = new Scanner(System.in);
	String festname;
	static int ecount=0;
	ArrayList<Event> eventlist = new ArrayList<Event>();
	ArrayList<Manager>managerlist = new ArrayList<Manager>();
	ArrayList<Atendee>atendeelist = new ArrayList<Atendee>();
	MyModel(String festname) {
		this.festname=festname;
	}
	void addEvent(String eventname, String eventid, String eventcost, String locid, String stime, String etime) {
		Event e=new Event(eventname,eventid,eventcost,locid,stime,etime);
		eventlist.add(e);
		
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
            JOptionPane.showMessageDialog(null, "Event Added.");

            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
        	 JOptionPane.showMessageDialog(null, "Error writing to file");
        }
	}

	void createManager(String name,String uid,String branch,String password) {
		Manager m=new Manager(name,uid,branch,password);
		managerlist.add(m);
		
		String fileName = "managerdata.txt";
        try {
            FileWriter fileWriter =
                new FileWriter(fileName,true);
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            bufferedWriter.write(uid+" ");
            bufferedWriter.write(password);
            bufferedWriter.newLine();
            JOptionPane.showMessageDialog(null, "Manager has been created");
    		
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
        	JOptionPane.showMessageDialog(null, "Error in creation");
        }


	}
	void createAtendee(String name, String uid, String branch) {
		Atendee a=new Atendee(name,uid,branch);
		atendeelist.add(a);
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
            JOptionPane.showMessageDialog( null, "Attendee has been created");
            bufferedWriter.close();
            fileWriter.close();
        }
        catch(IOException ex) {
        	JOptionPane.showMessageDialog( null, "Error in Attendee creation");
        }
    }
	boolean ManagerLogin(String uid, String password) {
		boolean flag=false;
		try{
			String[] arr;
			FileReader filereader= new FileReader("managerdata.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(uid) && arr[1].equals(password)) {
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
	boolean AtendeeLogin(String name,String uid)
	{
		boolean flag=false;
		try{
			String[] arr;
			FileReader filereader= new FileReader("atendeedata.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(name) && arr[1].equals(uid))
					flag=true;

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

	boolean bookEvent(String studentname,String uid,String branch, String eventname) {
		String arr[];
		try{
		FileReader filereader= new FileReader("eventsfile.txt");
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			while (line != null) {
				arr=line.split(" ");
				if(arr[0].equals(eventname))
					{
					System.out.print(6);
					Event etemp=new Event(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
					Ticket t = new Ticket(studentname,uid,branch,etemp);
			//creating a ticket
					JOptionPane.showMessageDialog(null, "Event Added Successfully\nCollect Your Ticket");
			//printing the ticket
					JOptionPane.showMessageDialog(null, t, "Ticket", 1);
					break;
					}
				line = reader.readLine();
			}
			reader.close();
			filereader.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Event Adding Failed");
			return false;
		}


	}
}
