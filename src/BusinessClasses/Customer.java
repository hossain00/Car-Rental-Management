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
//Database Access Code Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author scorpion
 */
public  class  Customer extends Person {
    private String idNumber;
    
   public String getIDnumber(){
        return idNumber;
}
    public void setIDnumber(String newID){
        idNumber = newID;
    
    }  
    public Customer(){
          super();
            idNumber = "";
            
          
            
            
    }
    //parameterized constructor
    public Customer(String ssnum,String firstname , String lastName, String dob, String address, String phone, String email) {
           
        //
        
            super(ssnum,firstname,lastName,dob,address,phone,email);
            idNumber = ssnum;
            
            
 }    
    @Override
    public void print() throws IOException {

        try {
            try (PrintWriter objOutStream = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("Network_Printer.txt", true)))) {
                        
                        objOutStream.println("**************** Customer Information ****************");
                        objOutStream.println();
                        objOutStream.println("Customer ID: " + idNumber);
                        objOutStream.println("First Name: " + super.getFirstName());
                        objOutStream.println("Last Name: " + super.getLastName());
                        objOutStream.println("Social Security: " + super.getSSNumber());
                        objOutStream.println("Address : " + super.getAddress());
                        objOutStream.println("Date of Birth: " + super.getDateOfBirth());
                        objOutStream.println("Age: " + super.getAge());
                        objOutStream.println("Phone: " + super.getPhone());
                        objOutStream.println("Email: " + super.getEmail());
                        

                        objOutStream.close();

                    }

        } catch (IOException objE) {
            throw new IOException("Error in print() method: " + objE.toString());
        }

    }
    public void load(String key) throws Exception{

        Database_Load(key);
    }

    public void insert()throws Exception {

        Database_Insert();
    }

    public void update() throws Exception{

        Database_Update();
    }

    public void delete(String key)throws Exception {

        Database_Delete(key);
    }

    protected void Database_Load(String key)throws Exception {
        try { 
            
            //Step 1 - Load JDBC drivers
            //(JDBC Drivers for MySQL must be downloaded and installed prior 
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
            String sql = "select * from db_customer.customer where IDnumber = '" + key + "'";   

           //Step 4b - Execute SQL Query using statement object
            //executeQuery() method     
            ResultSet objRS = objStatement.executeQuery(sql);


           //Step 5- Move cursor to first record of ResultSet Object. 
           //returns true if exists, false if not record exist
           if(objRS.next()) {

               //There is a record
               //Get Record data and consume by SETTING all properties with data 
               idNumber = objRS.getString(1);
               super.setFirstName(objRS.getString(2));
               super.setLastName(objRS.getString(3));
              //super.getSSNumber(objRS.getString(4));
               super.setDateOfBirth(objRS.getString(4));       
               super.setAddress(objRS.getString(5));       
               super.setPhone(objRS.getString(6));
               super.setEmail(objRS.getString(7));    
               //Close connection
               objConn.close();
           }
           else {
             //No record found. Close connection
               
               
               
               
             objConn.close();
        
      throw new UnsupportedOperationException("Customer not found!");      
    
           }
    }
             catch(SQLException|ClassNotFoundException objE) {
               //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Load() method - " + objE.toString());

         }
              
   }
    protected void Database_Insert() throws Exception{
        try { 
            
            //Step 1 - Load JDBC drivers
            //(JDBC Drivers for MySQL must be downloaded and installed prior 
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
//                String sql = "INSERT INTO customer(IDNumber,Name,SSNumber,DateOfBirth,Address,Phone,TotalItems)" +
//                             "VALUES('3333','Sam Franks','333-33-3333','03/03/1973','333 Jay Street','718 333-3333',33)";                

            String sql = "insert into db_customer.customer(IDnumber,FirstName,LastName,DateOfBirth,Address,Phone,Email)"+

                         "values('" + this.getIDnumber() + "','" +
                                      this.getFirstName() + "','" +
                                      this.getLastName() + "','" + 
                                      this.getDateOfBirth() + "','" + 
                                      this.getAddress() + "','" + 
                                      this.getPhone() + "','" +
                                      this.getEmail()+ "'"  + ")";                 


            //Step 4b - Execute SQL ACTION Query using statement object
            //executeUpdate()method. Return number of record affected                   
            int rowsAffected = objStatement.executeUpdate(sql);

            //Step 5- Test number of records affected to prove operation.
            //should be only 1 row since we inserted 1 record
            if(rowsAffected != 1) {
        throw new UnsupportedOperationException("Insert Query failed");
    }
         objConn.close();
            }
         catch(SQLException|ClassNotFoundException objE) {
              //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Insert() method - " + objE.toString());

         } 
      
   }//End of method 

    protected void Database_Update()throws Exception {
        try { 
            
                //Step 1 - Load JDBC drivers
                //(JDBC Drivers for MySQL must be downloaded and installed prior 
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
                
//                String sql = "UPDATE customer  " +
//                             "SET    Name ='Joe Smith (Joey)', " +
//                                     "DateOfBirth ='11/01/1981'," +
//			             "SSNumber ='111-22-1111'," +            
//			             "Address ='111 Glendwood Road, Brooklyn, New York'," +
//			             "Phone='1-718-282-1111'," +
//			             "TotalItems = 100 " + 	 
//                                     "WHERE IDNumber ='1111'";    

                
                String sql = "UPDATE db_customer.customer  " +
                             "SET    FirstName = '"   + this.getFirstName() + "', " +
                                     "LastName = '" + this.getLastName() + "', " +
                                     "DateOfBirth ='" + this.getDateOfBirth() + "', " +
			                        
			             "Address = '" + this.getAddress() + "', " +
			             "Phone = '" + this.getPhone() + "', " +
                                     "Email = '" + this.getEmail() + "' " +
                                     "WHERE IDnumber = '" + this.getIDnumber() + "'";    
                
                //Step 4b - Execute SQL ACTION Query using statement object
                //executeUpdate()method. Return number of record affected                   
                int rowsAffected = objStatement.executeUpdate(sql);

                //Step 5- Test number of records affected to prove operation.
                //should be only 1 row since we inserted 1 record
                if(rowsAffected != 1) {
        throw new UnsupportedOperationException("Update query failed!");
    }
                 objConn.close();
            }
             catch(SQLException|ClassNotFoundException objE) {
                  //Trapping & RETRHOWING for the IOException 
                  throw new Exception("Error in database_Update() method - " + objE.toString());

             }
          
         
   } //End of method 

    protected void Database_Delete(String key) throws Exception{
         try { 

            //Step 1 - Load JDBC drivers
            //(JDBC Drivers for MySQL must be downloaded and installed prior 
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
            //String sql = "DELETE FROM customer WHERE IDNumber = '1111' ";
            String sql = "DELETE FROM db_customer.customer WHERE IDnumber = '" + key + "'";                

           //Step 4b - Execute SQL ACTION Query using statement object
            //executeUpdate()method. Return number of record affected                   
            int rowsAffected = objStatement.executeUpdate(sql);

            //Step 5- Test number of records affected to prove operation.
            //should be only 1 row since we inserted 1 record
            if(rowsAffected != 1) {
        throw new UnsupportedOperationException("Delete query Failed!");
    }
             objConn.close();
        }
         catch(SQLException|ClassNotFoundException objE) {
             //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Delete() method - " + objE.toString());

         }
      
   } //End of method 
}


