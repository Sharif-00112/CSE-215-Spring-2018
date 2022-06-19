import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver 
{
	private static boolean admin = false;
	private static int add = -1;
	private static int limit = 15;
 public static void main(String args[]) 
 {
	 
	 createAcc();
	 Launch.main(null);
	 login();

 }
 public static void createAcc()
 {
	 Student st[] = new Student[5];
	
		 st[0] = new Student("raihan","password","department", 3.22, 3, 2, "mat,cse,eng");
		 st[1] = new Student("saddam","password","department", 3.22, 3, 2, "pol,mat,hala");
		 st[2] = new Student("mohona","12345","department", 3.22, 3, 2, "mat,arc,eng");
		 st[3] = new Student("hafija","12345","department", 3.22, 3, 2, "pol,mat,env");
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
    
   //System.out.println("enter youe choice");
   //int choice = sc.nextInt();
   /*switch(choice) 
   {
   case 1 :
       {
	   System.out.println(courses[choice-1]); */
       Isavailable(st);
       /*break;
       }
   case 2 :
	   System.out.println(courses[choice-1]); 
	   Isavailable();
	   break;
   case 3 :
	   System.out.println(courses[choice-1]); 
	   Isavailable();
	   break;
   
   default :
      System.out.println("Invalid choice");
    }*/
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
		  
		  //System.out.println(a+" "+b+" "+d+" "+e+" "+f+" "+g+" ");
		  
	  }
	  
	  
	  
	  /*for(i=0; i<18; i++)
	  {
		  System.out.println(c[i].getCourse());
	  }*/
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
	  if(admin == true || add == 2)
	  {
	    
	    noOfStudents++;  
	    limit = limit + 3;
	  }
	  else
	  {
	  taken(st,(s[0] +" "+ c[choice-1].getTime()));
	  noOfStudents--;
	  limit = limit - 3;
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
	    
	    
	    
	    if(limit<3)
	    {
	    	System.out.println("no more credits allowed");
	    }
	    else
	    {
	    	
	    	Isavailable(st);
	    }
}

   /*public static void print()
   {	 
	return;
   }*/
   
   public static void taken(Student st,String c)
   {
   	st.setAdvised(c,true);
   	
   	System.out.println("these are the courses you advised for : \n\n");
   	System.out.println(st.getAdvised());
   }

}