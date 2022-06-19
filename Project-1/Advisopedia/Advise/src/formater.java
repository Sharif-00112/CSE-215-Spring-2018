 import java.io.FileNotFoundException;
import java.util.Formatter;

public class formater 
{
	private static Formatter x;
	public static void main(String arg[])
	{
		createFile();
		write();
		closeFile();
		
		
	}
   public static void createFile()
   {
	   try {
			x = new Formatter("chinese.txt");
			System.out.println("file created succesfully");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	   
   }
   public static void write()
   {
	   x.format("%s %s %s \n %s %s %s  ", "20", "bucky" , "roberts" ,"21", "buck" , "roba");
   }
   public static void closeFile()
   {
	   x.close();
   }
}
