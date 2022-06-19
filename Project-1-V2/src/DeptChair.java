/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sharif Hossain
 */
public class DeptChair extends Faculty{
    private String initial;
    private String dept;
    
    public DeptChair(String name, String gender, String id, String dept, String initial, String rank, double salary){
        super(name, gender, id, dept, initial, rank, salary);
        
    }
}
