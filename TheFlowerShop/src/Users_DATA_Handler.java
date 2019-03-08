import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users_DATA_Handler {
        
    public static ArrayList<User> getAllTheUsers () {
                DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
                

               ArrayList<User> allTheUsers = new ArrayList<>();
                

        try {
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
             while (rs.next())//move to first record
            {
                User pUser= new User();
                 pUser.setFirstName(rs.getString("FirstName"));
            pUser.setLastName(rs.getString("LastName"));
            pUser.setPinNumber(rs.getInt("PinNumber"));
            pUser.setRole(rs.getString("Role"));
           pUser.setUserName(rs.getString("UserName"));
                       pUser.setOrders(rs.getInt("Orders"));
                       pUser.setSales(rs.getInt("Sales"));
            allTheUsers.add(pUser);
                }

        } catch (SQLException e) {
            System.out.println("getValidUser : Error");
            System.out.println("SQL exception occured" + e);
        }

        //==========================================================='  
        
        return allTheUsers;
    }

    public User getValidUser(User pUser){
        //  boolean userExistsInDatabase = false;
        
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
    
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM users WHERE username='" + pUser.getUserName()+ "' AND " + " PinNumber=" + pUser.getPinNumber() );
               
                rs.next();//move to first record
                

                pUser.setFirstName(rs.getString("FirstName"));
                pUser.setLastName(rs.getString("LastName"));
                pUser.setPinNumber(Integer.parseInt(rs.getString("PinNumber")));
                pUser.setRole(rs.getString("Role"));
                pUser.setUserName(rs.getString("UserName"));              
                pUser.setOrders(rs.getInt("Orders"));
                pUser.setSales(rs.getInt("Sales"));
                System.out.println("This is the user "+pUser.toString());
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
                
                if (rs.next()) 
                {        
                System.out.println(rs.getString("UserName"));
                    userExistsInDatabase=true; // set if at least one record is found
                }
                else
                {
                    System.out.println("Invalid Credentials");
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
                mySql = mySql +  ("(FirstName  , LastName , PinNumber , Role, UserName, Orders, Sales)");
                mySql = mySql +  ("VALUES (") ;
                mySql = mySql +  ("'" +    pUser.getFirstName()    + "',") ;
                mySql = mySql +  ("'" +    pUser.getLastName()   + "',") ;
                mySql = mySql +  ( ""  +   pUser.getPinNumber() + "," ) ;  // no apostrophe pinnumber is an integer
                mySql = mySql +  ("'" +   pUser.getRole()   + "',") ;   
                mySql = mySql +  ("'" +  pUser.getUserName()   + "'") ; 
                mySql = mySql +  ("'" +  pUser.getOrders()   + "'") ; 
                mySql = mySql +  ("'" +  pUser.getSales()   + "'") ;
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
public static void addOrder(User theUser)
{
      try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
             String mySql = "UPDATE Users ";
                mySql = mySql +  ("SET Orders = ");
                mySql = mySql +  (  theUser.getOrders()+1   ) ; 
                mySql=mySql+(" WHERE UserName = " );
                mySql = mySql +  ("'" +  theUser.getUserName()   + "'") ; 
                
                 
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
            }
       catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

}

public static void addSales(User theUser, int globalSales)
{
    try
    {           Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                String mySql = "UPDATE Users ";
                mySql = mySql + ("SET Sales = ");
                mySql = mySql + (theUser.getSales()+globalSales);
                mySql = mySql + (" WHERE UserName = ");
                mySql = mySql + ("'" + theUser.getUserName() + "'");
                
                                 
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
            }
       catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }
                
                
}
    
   
}    
    
   