/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sharif Hossain
 */
public class Person {
    
    private String name;
    private String gender;
    
    public Person(String name, String gender){
        this.name=name;
        this.gender=gender;     
    }
    public void setName(String name){
        this.name=name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }    
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String toString(){
        return "Name: "+name+", Gender: "+gender;
    }
}
