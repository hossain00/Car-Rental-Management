package BusinessClasses;

import java.util.HashMap;

import java.nio.file.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeList {

    private HashMap<String, Employee>employeeList;

    

    public EmployeeList() {
        employeeList = new HashMap<>();
    }
      /**
     * Returns the number of elements in the collection
     * @return 
     */
    public int getCount() {
        return employeeList.size();
    }
    
    
    /**
     * Property that returns a POINTER to the COLLECTION OBJECT
     * this method is used in order to loop through collection from the UI
     * @return 
     */
    public HashMap getEmployeeList(){
        
            return employeeList; 
    }  

    public Employee search(String ssnumber) throws Exception {

        try {
            return employeeList.get(ssnumber); 
                    

                
            }

            
         catch (Exception objE) {
            throw new Exception("Error in search() method: " + objE.toString());
        }
}
    

    public boolean add(String ssnumber,Employee NewEmployee) throws Exception {

        try {
            if(employeeList.containsKey(ssnumber)) 
//the key already exists 
                return false; 
            else 
                employeeList.put(ssnumber,NewEmployee);
            //Done. Return true & Exit 
            return true;

            
            }

            
         catch (Exception objE) {
            throw new Exception("Error in add() method: " + objE.toString());
        }
    }

    public boolean add(String SSNumber, String FirstName,
            String LastName, String DateOfBirth,
            String Address, String Phone,
            String Email, String JobTitle) throws Exception {

        Employee objEmployee = new Employee(SSNumber, FirstName, LastName, DateOfBirth, Address, Phone, Email, JobTitle);
        objEmployee.setSSNumber(SSNumber);
        objEmployee.setFirstName(FirstName);
        objEmployee.setLastName(LastName);
        objEmployee.setDateOfBirth(DateOfBirth);
        objEmployee.setAddress(Address);
        objEmployee.setPhone(Phone);
        objEmployee.setEmail(Email);
        objEmployee.setJobTitle(JobTitle);
        try {
            if(employeeList.containsKey(SSNumber)) //the key already exists 
            return false; 
            else 
                employeeList.put(SSNumber, objEmployee); //Done.
            
            return true;
        } catch (Exception e) {
            throw new Exception("Error in add() method values: " + e.toString());
        }
    }

    public boolean edit(String ssNumber, Employee EditedUserAccount) throws Exception {
        try {

            Employee objEmployee = employeeList.get(ssNumber);

                    if (objEmployee != null) {

                        objEmployee.setFirstName(EditedUserAccount.getFirstName());
                        objEmployee.setLastName(EditedUserAccount.getLastName());
                        objEmployee.setDateOfBirth(EditedUserAccount.getDateOfBirth());
                        objEmployee.setAddress(EditedUserAccount.getAddress());
                        objEmployee.setPhone(EditedUserAccount.getPhone());
                        objEmployee.setEmail(EditedUserAccount.getEmail());
                        objEmployee.setJobTitle(EditedUserAccount.getJobTitle());

                        return true;
                    }
                
            

            return false;
        }
        catch (Exception e) {
            throw new Exception("Error in edit() method: " + e.toString());
        }
    }

    public boolean edit(String SSNumber, String FirstName,
            String LastName, String DateOfBirth,
            String Address, String Phone,
            String Email, String JobTitle) throws Exception {
        try {

            Employee objEmployee = employeeList.get(SSNumber);

                    if (objEmployee != null) {

                        objEmployee.setFirstName(FirstName);
                        objEmployee.setLastName(LastName);
                        objEmployee.setDateOfBirth(DateOfBirth);
                        objEmployee.setAddress(Address);
                        objEmployee.setPhone(Phone);
                        objEmployee.setEmail(Email);
                        objEmployee.setJobTitle(JobTitle);

                        return true;
                    }
                
            

            return false;
        

            
        } catch (Exception e) {
            throw new Exception("Error in edit() method values: " + e.toString());
        }
    }

    public boolean remove(String SSNumber) throws Exception {
        try {
        Employee objEmployee = employeeList.remove(SSNumber); 
//test if return value not null & object found & removed 
            if(objEmployee != null){ 
             //Step 5-removed return true & Exit 
                return true; 
            } 
            else //Key not found 
                return false;
        } catch (Exception objE) {
            throw new Exception("Error in remove() method: " + objE.toString());
        }
    }

    public boolean print(String ssNumber) throws Exception {
        try {
            Employee objEmployee = employeeList.get(ssNumber); 
//test if return value not null & object found & removed 
            if(objEmployee != null){ 
             //Step 5-removed return true & Exit 
                objEmployee.print();
                return true;
            } 
            else //Key not found 
                return false;
            
        } catch (Exception objE) {
            throw new Exception("Error in print() method: " + objE.toString());
        }
    }

    public void printAll() throws Exception {
        try {
            for(Employee objEmployee: employeeList.values()){
                objEmployee.print();
            }
            
        } 
        catch (Exception objE) {
            throw new Exception("Error in printAll() method: " + objE.toString());
        }

    }

    public void clear() {

        employeeList.clear();

    }

    public void load() throws Exception {
        Database_Load();
    }

    public void save() throws IOException {
        Database_Save();

    }

    protected void Database_Load() throws Exception {
        try { 
            
            //Step 1 - Load JDBC drivers
            //(JDBC Drivers for MySQL must be downloaded and installed prior 
             Class.forName("com.mysql.jdbc.Driver");           

            //Step 2(a) - Creating Connection String
            String connectionUrl = "jdbc:mysql://localhost/db_employee"; 
            String user = "root";
            String pass = "abc123";

            //Step 2(b)GET/ESTABLISH connection to Database Server & Database
            Connection objConn = DriverManager.getConnection(connectionUrl, user, pass);

            //Step 3 - Create Statement object to execute Query
            Statement objStatement = objConn.createStatement();


           //Step 4a - Create SQL Query Stringt
            String sql = "select SSnumber from db_employee.employee";   

           //Step 4b - Execute SQL Query using statement object
            //executeQuery() method     
            ResultSet objRS = objStatement.executeQuery(sql);

           //Step 5- Get all records from ResultSet Object
           while(objRS.next()) {

                    //Step 6-Create NEW Object
                    Employee objCustomer = new Employee();
                    
                    //Step 7-Extract data from ResultSet Object and SET object
                    //In this case we display the parsed items to the console
                    String anExistingKey = objRS.getString(1);  
                                      
                    //Step 8 - Call objects load(key) method to load record from database
                    objCustomer.load(anExistingKey);
               
                   //Step 9 - Add object to Collection
                    this.add(objCustomer.getSSNumber(), objCustomer);               

           }
 
               //Close connection
               objConn.close();

         }     
         catch(SQLException|ClassNotFoundException objE) {
               //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Load() method - " + objE.toString());

         }

    }

    protected void Database_Save() throws IOException {
        try {
            try (PrintWriter objOutStream = new PrintWriter(
                            new BufferedWriter(
                            new FileWriter("EmployeeData.txt")))) {
                
                for (Employee objEmployee : employeeList.values()) {
                    
objOutStream.println(
        objEmployee.getSSNumber() + "," +
        objEmployee.getFirstName() + "," + 
        objEmployee.getLastName() + "," + 
        
        objEmployee.getDateOfBirth() + "," + 
        objEmployee.getAddress() + "," + 
        objEmployee.getPhone() + "," + 
        objEmployee.getEmail()  +"," +
                objEmployee.getJobTitle());
                        
                    
                }
                objOutStream.close();
            }

        } catch (IOException objE) {
            throw new IOException("Error in save() method: " + objE.toString());
        }
    }
}
