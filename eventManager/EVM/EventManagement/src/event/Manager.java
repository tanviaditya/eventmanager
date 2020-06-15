package event;

public class Manager extends Student{
	String name,uid,branch,password;
	boolean isManager;
	public Manager(String name,String uid,String branch,String password)
	{
		super(name,uid,branch);
		this.password=password;
		this.isManager=true;
	}
}
