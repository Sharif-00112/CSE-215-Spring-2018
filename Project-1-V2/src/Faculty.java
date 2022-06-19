/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sharif Hossain
 */
public class Faculty extends MemberOfNsu{
    private String initial;
    private String rank;
    private double salary;
    
    public Faculty(String name, String gender, String id, String dept, String initial, String rank, double salary){
        super(name, gender, id, dept);
        this.initial=initial;
        this.rank=rank;
        this.salary=salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setInitial(String initial){
        this.initial=initial;
    }
    public void setRank(String rank){
        this.rank=rank;
    }
    public String getInitial(){
        return initial;
    }
    public String getRank(){
        return rank;
    }
    public double getSalary(){
        return salary;
    }
    public String toString(){
        return "Initial: "+initial+", Rank: "+rank+ ", Salary: "+salary;
    }
}
