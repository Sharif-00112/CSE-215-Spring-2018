    
public class Student
{
	private int GlobalCounterForInitializingAdvised =  0;
	private String name;
	private String password;
	private String department;
	private double ID;
	private double credit;
	private double cgpa;
	private String pre;
	private String advised;
	
	public String getAdvised() {
		return advised;
	}
	public void setAdvised(String advised,boolean add)
	{
		if(GlobalCounterForInitializingAdvised == 0)
		{
			this.advised = advised + "\n";
			GlobalCounterForInitializingAdvised++;
			return;
		}
		if(add)
		{
		this.advised = this.advised + advised + "\n";
		
		}
			
	}
	public Student(String name, String password, String department, double iD, double credit, double cgpa, String pre) {
		super();
		this.name = name;
		this.password = password;
		this.department = department;
		ID = iD;
		this.credit = credit;
		this.cgpa = cgpa;
		this.pre = pre;
	}
	public Student(String name, String password, String department, double iD, double credit, double cgpa) {
		super();
		this.name = name;
		this.password = password;
		this.department = department;
		ID = iD;
		this.credit = credit;
		this.cgpa = cgpa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getID() {
		return ID;
	}
	public void setID(double iD) {
		ID = iD;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	@Override
	public String toString() {
		return  name + " " + password + " " + department + " " + ID
				+ " " + credit + " " + cgpa + " " + pre + " \n";
	}
	
	

}
