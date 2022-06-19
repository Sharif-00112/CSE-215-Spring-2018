
public class Launch
{
 public static void main(String args[]) 
 {
	 readFile RF = new readFile();
	 RF.openFile();
	 Student st[] =new Student[5];
	 st = RF.read();
	 /*for(int i=0;i<5;i++)
	 {
		 System.out.println(st[i]);
	 }*/
	 RF.closeFile();
	 
 }
}
