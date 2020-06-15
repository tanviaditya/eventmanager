package event;

public class Atendee extends Student {
	String name,uid,branch;
	boolean isManager;
	Atendee(String name,String uid,String branch)
	{
		super(name,uid,branch);
		this.isManager=false;
	}
}
