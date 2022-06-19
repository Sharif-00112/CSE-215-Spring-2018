
public class Launch
{
 public static void main(String args[]) 
 {
	 readFile RF = new readFile();
	 RF.openFile();
	 Student st[] =new Student[5];
	 st = RF.read();
	
	 RF.closeFile();
	 
 }
}
