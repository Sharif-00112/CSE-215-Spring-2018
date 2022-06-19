
public class Course 
{
  private String course;
  private String time;
  public Course()
  {
	 this.course = "NULL";
	 this.time = "0000";
  }
  public Course(String course, String time) 
  {
	super();
	this.course = course;
	this.time = time;
  }
  public String getCourse() {
	return course;
  }
  public void setCourse(String course) {
	this.course = course;
  }
  public String getTime() {
	return time;
  }
  public void setTime(String time) {
	this.time = time;
  }
  
  public String toString() {
	return "Course [course=" + course + ", time=" + time + "]";
  }
 
 
}
