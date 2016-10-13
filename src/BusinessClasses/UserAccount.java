package BusinessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class UserAccount {
    

    private String userAccountID;
    private String username;
    private String password;
    private String email;

    
    public String getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(String newUserAccountID) {
        userAccountID = newUserAccountID;
    }

    
    public String getUserName() {
        return username;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String neweMail) {
        email = neweMail;
    }

    //Private Default constructors 
    private UserAccount() {
        //set userAccountID to UUID
        userAccountID = UUID.randomUUID().toString();
        username = "";
        password = "";
        email = "";

    }

    //parametarized constructors
    private UserAccount(String Username, String Password, String eMail) {
        //set userAccountID to UUID
        userAccountID = UUID.randomUUID().toString();

        setUsername(Username);
        setPassword(Password);
        setEmail(eMail);

    }

    //static get instance method no parameters
    //cause is Private  therefore in order to access the constructors we have to use static method
    public static UserAccount getInstance() {//getInstance is method name
        UserAccount objAccount1 = new UserAccount(); //instancies(initializing a new obj w propierites of class) using private constructor cause is static method  (getinstance) is inside of the class
        return objAccount1;
    }

    //static get instance method with parameters passing by value
    public static UserAccount getInstance(String U, String P, String E) {
        UserAccount objAccount1 = new UserAccount(U, P, E);
        return objAccount1;
    }

    //authentication method
    public boolean authenticate(String U, String P) {
        
        
        

        if (username.equals(U) && password.equals(P)) {
            return true;
           
         
        
        
      
        
        
        } 
        
        else {
            return false;
        }

    }
    //public data access methods

    public void load(String key)throws Exception {

        Database_Load(key);
    }

    public void insert() {

        Database_Insert();
    }

    public void update() {

        Database_Update();
    }

    public void delete() {

        Database_Delete();
    }

    protected void Database_Load(String key) throws Exception{
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
            String sql = "select * from db_useraccount.useraccount where Username = '" + key + "'";   

           //Step 4b - Execute SQL Query using statement object
            //executeQuery() method     
            ResultSet objRS = objStatement.executeQuery(sql);


           //Step 5- Move cursor to first record of ResultSet Object. 
           //returns true if exists, false if not record exist
           if(objRS.next()) {

               //There is a record
               //Get Record data and consume by SETTING all properties with data 
               username = objRS.getString(1);
               //userAccountID = objRS.getString(2);
               password = objRS.getString(2);
              //super.getSSNumber(objRS.getString(4));
               email = objRS.getString(3);       
               
               objConn.close();
           }
           else {
             //No record found. Close connection
               
               
               
               
             objConn.close();
        
      throw new UnsupportedOperationException("User Account not found!");      
    
           }
    }
             catch(SQLException|ClassNotFoundException objE) {
               //Trapping & RETRHOWING for the IOException 
              throw new Exception("Error in database_Load() method - " + objE.toString());

         }

    }

    protected void Database_Insert() {

    }

    protected void Database_Update() {

    }

    protected void Database_Delete() {

    }
}
