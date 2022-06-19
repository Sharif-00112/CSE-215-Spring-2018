import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver 
{
	private static boolean admin = false;
	//private static int add = -1;
	
 public static void main(String args[]) 
 {
	 
	 createAcc();
	 Launch.main(null);
	 login();

 }
 public static void createAcc()
 {
	 Student st[] = new Student[5];
	
		 st[0] = new Student("jawad","password","department", 3.22, 3, 2, "mat,cse,eng");
		 st[1] = new Student("sharif","password","department", 3.22, 3, 2, "pol,mat,hala");
		 st[2] = new Student("rubaidah","password","department", 3.22, 3, 2, "mat,cse,eng");
		 st[3] = new Student("fariha","password","department", 3.22, 3, 2, "pol,mat,hala");
		 st[4] = new Student("samin","lala","department", 3.22, 3, 2, "mat,cse,eng");
	 
	     write(st,st.length);
 }

 public static void write(Student st[],int count)
 {
	 File file = new File("chinese.txt");
	 PrintWriter output = null;
	 try 
	 {
		output = new PrintWriter(file);
	 } 
	 catch (FileNotFoundException e) 
	 {
		e.printStackTrace();
	 }
	 int i=0;
	 while(i<count)
	 {
		output.println(st[i]); 
		i++;
	 }
	 
	 output.close();
 }
 
 public static void login()
 {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("please enter your name ");
	 String name = sc.nextLine();
	 System.out.println("please enter your password ");
	 String password = sc.nextLine();
	 
	 readFile RF = new readFile();
	 Student st[] = new Student[5];
	 RF.openFile();
	 st = RF.read();
	 boolean flag = false;
	 for(int i=0;i<5;i++)
	 {
		if(st[i].getName().equals(name))
		{
			if(st[i].getPassword().equals(password) )
			{
				String[] info = st[i].toString().split(" ");
				System.out.println("name : "+info[0]+" depaetment : "+info[2]+" ID :"+info[3]+" credit : "+info[4]+" cgpa : "+info[5]);
				if(st[i].getName().equals("samin"))
			    {
			    	admin=true;
			    	
			    }
				loggedin(st[i]);
			    flag = true;
			    
			}
			
		}
		
	 }
	 if(!flag)
	 {
		System.out.println("Invalid user name or password ");
		System.out.println("please re enter your your information : ");
		login();
	}
	
	 
	 RF.closeFile();
	 
	 
	 return;
	 
	 
	 
 }



public static void loggedin(Student st)
{
	
	@SuppressWarnings({ "unused", "resource" })
	Scanner sc = new Scanner(System.in);
	System.out.println("entry succesful");
	System.out.println("these are the courses that you pre advised");
	
	
	System.out.println(st.getPre());
	String[] courses=st.getPre().split(",");
	int j=1;
	for(String s : courses)
	{
            System.out.println(j+". "+s);
            j++;
    } 
      
	   Isavailable(st);
       

}


public static void Isavailable(Student st)
{
	  Scanner x = null;
	  Scanner y = null;
	  
	  try 
	  {
		File file = new File("courses.txt");
		x = new Scanner(file);
	  } 
	  catch (FileNotFoundException e) 
	  {
	    e.printStackTrace();
	  }
	  
	  Course[] c = new Course[100];
	  for(int i=0; i<100; i++)
	  {
		  c[i] = new Course();
	  }
	  
	  int i = 0;
	  
	  while(x.hasNext())
	  {
		  String a = x.next();
		  c[i].setCourse(a);i++;
		  String b = x.next();
		  c[i].setCourse(b);i++;
		  String d = x.next();
		  c[i].setCourse(d);i++;
		  String e = x.next();
		  c[i].setCourse(e);i++;
		  String f = x.next();
		  c[i].setCourse(f);i++;
		  String g = x.next();
		  c[i].setCourse(g);i++;
		  
	  }
	  
	  x.close();
	  try 
	  {
		File file2 = new File("timing.txt");
		y = new Scanner(file2);
	  } 
	  catch (FileNotFoundException e) 
	  {
	    e.printStackTrace();
	  }
	  
	  i=0;
	  while(y.hasNext())
	  {
		  String h = y.next();
		  c[i].setTime(h);i++;
		  String z = y.next();
		  c[i].setTime(z);i++;
		  String j = y.next();
		  c[i].setTime(j);i++;
		  String k = y.next();
		  c[i].setTime(k);i++;
		  String l = y.next();
		  c[i].setTime(l);i++;
		  String m = y.next();
		  c[i].setTime(m);i++;
		  
		  //System.out.println(h+z+j+k+l+m);
	 }
	  
	  System.out.println("\n\n\n these are the courses that you can choose from \n\n\n");
	  
	  for(i=0; i<18; i++)
	  {
		  System.out.println((i+1)+" . "+c[i].getCourse()+" "+c[i].getTime());
	  }
	  
	  y.close();
	  
	  @SuppressWarnings("resource")
	  Scanner sc = new Scanner(System.in);
	  
	  System.out.println("choose a course :-");
	  int choice=sc.nextInt();
	  System.out.println("add or drop, if add press 1 ,if drop press 2");
	  int add=sc.nextInt();
	  
	  String[] s=c[choice-1].getCourse().split("-");
	  int noOfStudents = Integer.parseInt(s[1]);   
	  if(admin == true || add == 1)
	  {
		taken(st,(s[0] +" "+ c[choice-1].getTime()),true);
	    noOfStudents++;  
	    st.setLimit(3, true);
	  }
	  else
	  {
	  taken(st,(s[0] +" "+ c[choice-1].getTime()),false);
	  noOfStudents--;
	  st.setLimit(3, false);
	  }
	  s[1]=String.valueOf(noOfStudents);
	  c[choice-1].setCourse(s[0]+"-"+s[1]);
	  
	  //writing after the changes have been made
	  
	  try 
		{
			File file = new File("courses.txt");
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(i=0;i<18;i++)
			{
			
				printWriter.print(c[i].getCourse() + " ");i++;
				printWriter.print(c[i].getCourse() + " ");i++;
				printWriter.print(c[i].getCourse() + " ");i++;
				printWriter.print(c[i].getCourse() + " ");i++;
				printWriter.print(c[i].getCourse() + " ");i++;
				printWriter.print(c[i].getCourse() + " ");
				
			
			    printWriter.println();
			    
			}
			
			fileWriter.flush();
			fileWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	    
	    
	    
	    if(st.getLimit()<3)
	    {
	    	System.out.println("no more credits allowed");
	    }
	    else
	    {
	    	Isavailable(st);
	    }
	    
	    
	    
	   /* 
	    
	    try 
		{
			File file = new File("advised.txt");
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			String gt[] = new String[100];
		  
		  
		  
		  gt = st.getAdvised().clone();
		  for(String s: gt)
	   	  {
			  if(!(s == null))
	   	      printWriter.print(s);
	   	  }
			
			fileWriter.flush();
			fileWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	    
	    
	    */
	    
	    
}

   public static void taken(Student st,String c,boolean add)
   {
   	  if(add)
   	  {
   		  st.setAdvised(c,true);
   	   	  System.out.println("these are the courses you advised for : \n\n");
   	      String gt[] = new String[100];
		  gt = st.getAdvised().clone();
		  for(String s: gt)
	   	  {
			  if(!(s == null))
	   	      System.out.println(s);
	   	  }
   	   	
   	  }
   	  else 
   	  {
   		  st.setAdvised(c,false);
   		  System.out.println("these are the courses you advised for : \n\n");
   		  String gt[] = new String[100];
   		  gt = st.getAdvised();
   		  for(String s: gt)
	   	  {
   			  if(!(s == null))
	   	      System.out.println(s);
	   	  }
   	  }
   }

}