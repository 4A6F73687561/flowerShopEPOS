
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Users_DATA_Handler {
    
    public User getValidUser(User pUser){
        //  boolean userExistsInDatabase = false;
        
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
    
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM users WHERE username='" + pUser.getUserName()+ "' AND " + " PinNumber=" + pUser.getPinNumber() );
               
                rs.next();//move to first record
                

                pUser.setFirstName(rs.getString("firstname"));
                pUser.setLastName(rs.getString("lastname"));
                pUser.setPinNumber(Integer.parseInt(rs.getString("pinnumber")));
                pUser.setRole(rs.getString("role"));

            }
         catch(SQLException e)
            {
                System.out.println("getValidUser : Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return pUser;
    }
   
    public boolean checkUserIsValid(User pUser){
        boolean userExistsInDatabase = false;
      
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM users WHERE username='" + pUser.getUserName()+ "' AND " + " PinNumber=" + pUser.getPinNumber() );
                while (rs.next()) 
                {        
                  userExistsInDatabase=true; // set if at least one record is found
                }
                
            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
    return (userExistsInDatabase);
    }
    
    public void updateUser(User pUser ){
           
        
    }
    
    public void deleteUser(int pID ){
        
    }
    
    public void insertUser(User pUser)
    {

         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                pUser.getUserName();
               
                String mySql = "INSERT INTO Users";
                mySql = mySql +  ("(FirstName  , LastName , PinNumber , Role, UserName)");
                mySql = mySql +  ("VALUES (") ;
                mySql = mySql +  ("'" +    pUser.getFirstName()    + "',") ;
                mySql = mySql +  ("'" +    pUser.getLastName()   + "',") ;
                mySql = mySql +  ( ""  +   pUser.getPinNumber() + "," ) ;  // no apostrophe pinnumber is an integer
                mySql = mySql +  ("'" +   pUser.getRole()   + "',") ;   
                mySql = mySql +  ("'" +  pUser.getUserName()   + "'") ;  
                mySql = mySql +  (")") ;     
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
   
    }   
        
}    
    
   