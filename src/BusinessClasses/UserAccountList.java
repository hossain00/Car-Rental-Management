package BusinessClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserAccountList {

    //private data

    private HashMap<String, UserAccount> userAccountList;

    //default constructor
    public UserAccountList() {
        userAccountList = new HashMap<>();
    }
      /**
     * Returns the number of elements in the collection
     * @return 
     */
    public int getCount() {
        return userAccountList.size();
    }
    
    
    /**
     * Property that returns a POINTER to the COLLECTION OBJECT
     * this method is used in order to loop through collection from the UI
     * @return 
     */
    public HashMap getUseraccountList(){
        
            return userAccountList; 
    }  

    public UserAccount search(String IDNum) throws Exception { 
        try{ //Step 1-Call Collection Object.get() method 
                //to Return POINTER to OBJECT IN Collection & Exit 
            return userAccountList.get(IDNum); 
        } catch (Exception objE) 
        { 
//Trapping & RETRHOWING for the IOException 
            throw new Exception("Error in search() method - " + objE.toString());
        }
    }

            

    public boolean add(String username, UserAccount userAccount)throws Exception {
        try{
            if(userAccountList.containsKey(username)) 
//the key already exists 
                return false; 
            else 
                userAccountList.put(username,userAccount);
            //Done. Return true & Exit 
            return true;
        }
catch (Exception objE) { 
//Trapping & RETRHOWING for the IOException 
    throw new Exception("Error in add() method - " + objE.toString()); 
} 
    }//
        
    
public boolean add(String username, String password,String email)
            throws Exception {

        UserAccount objusr = UserAccount.getInstance(username,password,email);
        objusr.setUsername(username);
        objusr.setPassword(password);
        objusr.setEmail(email);
        
        try {
            if(userAccountList.containsKey(username)) //the key already exists 
            return false; 
            else 
                userAccountList.put(username, objusr); //Done.
            
            return true;
        } catch (Exception e) {
            throw new Exception("Error in add() method values: " + e.toString());
        }
    }

   

    
    public boolean edit(String Username, UserAccount EditedUser) throws Exception {

        try {

            UserAccount objuser = userAccountList.get(Username);

                    if (objuser != null) {

                        
                        objuser.setUsername(EditedUser.getUserName());
                        objuser.setPassword(EditedUser.getPassword());
                        objuser.setEmail(EditedUser.getEmail());
                        

                        return true;
                    }
                
            

            return false;
        }
        catch (Exception e) {
            throw new Exception("Error in edit() method: " + e.toString());
        }
    }

    public boolean edit(String username, String password, String email) throws Exception {
        try {

            UserAccount objusr = userAccountList.get(username);

                    if (objusr != null) {

                        objusr.setUsername(username);
                        objusr.setPassword(password);
                        
                        objusr.setEmail(email);
                        

                        return true;
                    }
                
            

            return false;
        

            
        } catch (Exception e) {
            throw new Exception("Error in edit() method values: " + e.toString());
        }
    }
   public boolean remove(String usr) throws Exception {
        try {
        UserAccount objusr = userAccountList.remove(usr); 
//test if return value not null & object found & removed 
            if(objusr != null){ 
             //Step 5-removed return true & Exit 
                return true; 
            } 
            else //Key not found 
                return false;
        } catch (Exception objE) {
            throw new Exception("Error in remove() method: " + objE.toString());
        }
    }


    public boolean changeUserName(String username,String newusername) throws Exception {
        try {

            UserAccount objusr = userAccountList.get(username);

                    if (username.equals(objusr.getUserName())) {

                        objusr.setUsername(newusername);
                        
                        

                        return true;
                    }
                
            

            return false;
               } catch (Exception e) {
            throw new Exception("Error in changeUSername() method values: " + e.toString());
        }
    }

    public boolean changePassword(String username, String newPassword)throws Exception {

        try {

            UserAccount objusr = userAccountList.get(username);

                    if (username.equals(objusr.getUserName())) {

                        objusr.setPassword(newPassword);
                        
                        

                        return true;
                    }
                
            

            return false;
               } catch (Exception e) {
            throw new Exception("Error in ChangePassword() method values: " + e.toString());
        }
    }

    public boolean changeEmail(String username, String newEmail)throws Exception {

        try {

            UserAccount objusr = userAccountList.get(username);

                    if (username.equals(objusr.getUserName())) {

                        objusr.setEmail(newEmail);
                        
                        

                        return true;
                    }
                
            

            return false;
               } catch (Exception e) {
            throw new Exception("Error in ChangeEmail() method values: " + e.toString());
        }
    }
    public void clear() {
        //create an obj..

        userAccountList.clear();
    }

    public boolean Authenticate(String u, String p) throws Exception{

        try{
        load();

        UserAccount objusr = userAccountList.get(u);
            if (objusr != null) 
            {
                if (objusr.authenticate(u, p))
                {
                    clear();
                    return true;

                }

            }
        
        clear();
        return false;
        } catch (Exception objE) {
            throw new Exception("Error in Authenticate() method: " + objE.toString());
        }

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
            String connectionUrl = "jdbc:mysql://localhost/db_useraccount"; 
            String user = "root";
            String pass = "abc123";

            //Step 2(b)GET/ESTABLISH connection to Database Server & Database
            Connection objConn = DriverManager.getConnection(connectionUrl, user, pass);

            //Step 3 - Create Statement object to execute Query
            Statement objStatement = objConn.createStatement();


           //Step 4a - Create SQL Query Stringt
            String sql = "select Username from db_useraccount.useraccount";   

           //Step 4b - Execute SQL Query using statement object
            //executeQuery() method     
            ResultSet objRS = objStatement.executeQuery(sql);

           //Step 5- Get all records from ResultSet Object
           while(objRS.next()) {

                    //Step 6-Create NEW Object
                    UserAccount objCustomer = UserAccount.getInstance();
                    
                    //Step 7-Extract data from ResultSet Object and SET object
                    //In this case we display the parsed items to the console
                    String anExistingKey = objRS.getString(1);  
                                      
                    //Step 8 - Call objects load(key) method to load record from database
                    objCustomer.load(anExistingKey);
               
                   //Step 9 - Add object to Collection
                    this.add(objCustomer.getUserName(), objCustomer);               

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
                            new FileWriter("UserAccountData.txt")))) {
                
                for (UserAccount objusr : userAccountList.values()) {
                    
         objOutStream.println(
                 objusr.getUserAccountID() + "," +
        objusr.getUserName() + "," +
        objusr.getPassword() + "," + 
        objusr.getEmail());
                        
                    
                }
                objOutStream.close();
            }

        } catch (IOException objE) {
            throw new IOException("Error in save() method: " + objE.toString());
        }
    }
}
