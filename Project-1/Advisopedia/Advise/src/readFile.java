import java.io.*;
import java.util.*;

public class readFile 
{
  private Scanner x;
  public void openFile()
  {
	  try {
		File file = new File("chinese.txt");
		x = new Scanner(file);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
  }
  
  public Student[] read()
  {
	  Student st[] = new Student[5];
	  int i=0;
	  while(x.hasNext())
	  {
		  String a = x.next();
		  String b = x.next();
		  String c = x.next();
		  double d = Double.parseDouble(x.next());
		  double e = Double.parseDouble(x.next());
		  double f = Double.parseDouble(x.next());
		  String g = x.next();
		  
		  
		  
		  
		  
		  st[i] = new Student(a,b,c,d,e,f,g);
		  	 
		  i++;
		  //System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
		  //System.out.println(" ");
		  
		  
	  }
	  return st;
  }
  
  public void closeFile()
  {
	  x.close();
  }
}
