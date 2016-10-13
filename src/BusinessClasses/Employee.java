
package BusinessClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee extends Person {
    //declaring private data
    
    private String jobTitle;
   
   
    
    
    
    public void setDateOfBirth(String newBDate){
//Create DateTimeFormatter object with desired pattern.
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//date object will be converted and formated based on DateTiemFormatter object format
LocalDate objDOB = LocalDate.parse(newBDate, formatter);
int theAge = LocalDate.now().getYear() - objDOB.getYear();
if(theAge >= 16) {
super.setDateOfBirth(newBDate);
}
else {
throw new UnsupportedOperationException("Policy Violation-Underage Employee");
}
}

   

    
    public String getJobTitle(){
    return jobTitle;
    }
    public void setJobTitle(String newJobTitle){
    jobTitle = newJobTitle;
    }
    
    
    //default constructor
    public Employee(){
            super();
            jobTitle ="";
            super.setCount(1);
    }
    //parameterized constructor
    public Employee(String ssnumber, String firstname , String lastName, String dob, String address, String phone, String email, String jobTitle) {
           
        //
            setSSNumber (ssnumber);
            setFirstName(firstname);
            setLastName(lastName);
            setDateOfBirth (dob);
           
            setAddress(address);
            setPhone (phone);
            setEmail(email);
            setJobTitle(jobTitle);
            //Employee.count++;
            super.setCount(1);
 }          
    
    //print method
    @Override
    public void print() throws IOException {

        try {
            try (PrintWriter objOutStream = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("Network_Printer.txt", true)))) {
                        
                        objOutStream.println("**************** Employee ****************");
                        objOutStream.println();

                        objOutStream.println("First Name: " + super.getFirstName());
                        objOutStream.println("Last Name: " + super.getLastName());
                        objOutStream.println("Social Security: " + super.getSSNumber());
                        objOutStream.println("Date Of Birth: " + super.getDateOfBirth());
                        objOutStream.println("Address: " + super.getAddress());
                        objOutStream.println("Phone: " + super.getPhone());
                        objOutStream.println("Age: " + super.getAge());
                        objOutStream.println("Email: " + super.getEmail());
                        objOutStream.println("Job Title: " + jobTitle);

                        objOutStream.close();

                    }

        } catch (IOException objE) {
            throw new IOException("Error in print() method: " + objE.toString());
        }

    }

    public void load(String key)throws Exception {

        Database_Load(key);
    }

    public void insert()throws Exception {

        Database_Insert();
    }

    public void update()throws Exception {

        Database_Update();
    }

    public void delete()throws Exception {

        Database_Delete();
    }

    protected void Database_Load(String key)throws Exception {
    try{
        Class.forName("com.mysql.jdbc.Driver");
               

            //Step 2(a) - Creating Connection String
            String connectionUrl = "jdbc:mysql://localhost/db_customer"; 
            String user = "root";
            String pass = "abc123";

            //Step 2(b)GET/ESTABLISH connection to Database Server & Database
            Connection objConn = DriverManager.getConnection(connectionUrl, user, pass);

            //Step 3 - Create Statement object to execute Query
            Statement objStatement = objConn.createStatement();


           //Step 4a - Create SQL Query Stringt
            String sql = "select * from db_employee.employee where SSnumber = '" + key + "'";   

           //Step 4b - Execute SQL Query using statement object
            //executeQuery() method     
            ResultSet objRS = objStatement.executeQuery(sql);


           //Step 5- Move cursor to first record of ResultSet Object. 
           //returns true if exists, false if not record exist
           if(objRS.next()) {

               //There is a record
               //Get Record data and consume by SETTING all properties with data 
               super.setSSNumber (objRS.getString(1));
               super.setFirstName(objRS.getString(2));
               super.setLastName(objRS.getString(3));
              //super.getSSNumber(objRS.getString(4));
               super.setDateOfBirth(objRS.getString(4));       
               super.setAddress(objRS.getString(5));       
               super.setPhone(objRS.getString(6));
               super.setEmail(objRS.getString(7));
               jobTitle = objRS.getString(8);
               //Close connection
               objConn.close();
           }
           else {
             //No record found. Close connection
               
               
               
               
             objConn.close();
      throw new UnsupportedOperationException("Employee not found!");      
           }
    }
           
    
             catch(SQLException|ClassNotFoundException objE) {
               //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Load() method - " + objE.toString());

         }
    }        
   

    protected void Database_Insert() {
        throw new UnsupportedOperationException("Insert feature under construction");
    }

    protected void Database_Update() {
        throw new UnsupportedOperationException("Update feature under construction");
    }

    protected void Database_Delete() {
        throw new UnsupportedOperationException("Delete feature under construction");
    }
}





   