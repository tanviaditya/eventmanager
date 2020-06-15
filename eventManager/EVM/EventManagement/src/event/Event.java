package event;

public class Event {
	String eventname,eventid,eventcost,locid,stime,etime;
   public Event(String eventname, String eventid, String eventcost, String locid, String stime, String etime) {
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
