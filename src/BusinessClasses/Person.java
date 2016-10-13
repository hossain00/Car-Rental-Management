/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author scorpion
 */
public abstract class Person {
     private String ssNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Integer age;
    private String address;
    private String phone;
    private String email;
    
    private static Integer count =0;
   
    //getter/setter methods
    public String getSSNumber(){
        return ssNumber;
}
    public void setSSNumber(String newSsn){
        ssNumber = newSsn;
    
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String newFirstName){
    firstName = newFirstName;
    }
    public String getLastName(){
    return lastName;
    }
    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    public String getDateOfBirth(){
     
    	return dateOfBirth;
    }
    public void setDateOfBirth(String d){
            dateOfBirth = d;
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate objDOB = LocalDate.parse(d, formater);
            LocalDate today = LocalDate.now();
            age = today.getYear() - objDOB.getYear();

    }
    public Integer getAge(){
    return age;
    }

    public String getAddress(){
    return address;
    }
    public void setAddress(String newAddress){
        address = newAddress;
    }
    public String getPhone(){
    return phone;
    }
    public void setPhone(String newPhone){
    phone = newPhone;
    }
    public String getEmail(){
    return email;
    }
    public void setEmail(String newMail){
    email = newMail;
    }
    
    
    public static  Integer getCount(){
    return count;
    }
    public static void setCount(Integer newCount){
     
        count = newCount;
        
    }
    
    //default constructor
    public Person(){
            ssNumber = "";
            firstName = "";
            lastName = "";
            dateOfBirth = "00/00/0000";
            age = 0;
            address = "";
            phone = "";
            email = "";
            
            
            
    }
    //parameterized constructor
    public Person(String ssnumber, String firstname , String lastName, String dob, String address, String phone, String email) {
           
        //
            setSSNumber (ssnumber);
            setFirstName(firstname);
            setLastName(lastName);
            setDateOfBirth (dob);
           
            setAddress(address);
            setPhone (phone);
            setEmail(email);
            
            
 }          
    
    
    public abstract void print ()throws IOException;

       

    

    
    
}
