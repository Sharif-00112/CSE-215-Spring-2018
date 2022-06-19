/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sharif Hossain
 */
public class MemberOfNsu extends Person{
    private String id;
    private String dept;
    
    public MemberOfNsu(String name, String gender, String id, String dept){
        super(name, gender);
        this.id=id;
        this.dept=dept;
    }
    
    public void setId(String id){
        this.id=id;
    }
    public void setDept(String dept){
        this.dept=dept;
    }
    public String getId(){
        return id;
    }
    public String getDept(){
        return dept;
    }
    public String toString(){
        return "Id: "+id+", Department: "+dept;
    }
}
