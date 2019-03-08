

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Flowers_DATA_Handler {
    
    
   

    public Flowers getFlowers(Flowers pFlowers) {

        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist

        try {
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flowers WHERE FlowerName='" + pFlowers.getFlowerName()+ "'");

            rs.next();//move to first record

            pFlowers.setFlowerName(rs.getString("flower"));
            pFlowers.setFlowerDescription(rs.getString("description"));
            pFlowers.setFlowerPrice(rs.getInt("price"));
            pFlowers.setFlowerScreen(rs.getInt("screen"));

        } catch (SQLException e) {
            System.out.println("getValidUser : Error");
            System.out.println("SQL exception occured" + e);
        }

        //==========================================================='  
        return pFlowers;
    }
    
    
    public static ArrayList<Flowers> getAllTheFlowers () {
                DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
                

               ArrayList<Flowers> allTheFlowers = new ArrayList<>();
                

        try {
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Flowers");
             while (rs.next())//move to first record
            {
                Flowers pFlowers= new Flowers();
                 pFlowers.setFlowerName(rs.getString("FlowerName"));
            pFlowers.setFlowerDescription(rs.getString("description"));
            pFlowers.setFlowerPrice(rs.getInt("price"));
            pFlowers.setFlowerScreen(rs.getInt("screen"));
            allTheFlowers.add(pFlowers);
                }

        } catch (SQLException e) {
            System.out.println("getValidUser : Error");
            System.out.println("SQL exception occured" + e);
        }

        //==========================================================='  
        
        return allTheFlowers;
    }



public void insertFlowers(Flowers pFlowers)
    {

         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                pFlowers.getFlowerName();
               
                String mySql = "INSERT INTO Flowers";
                mySql = mySql +  ("(Screen, FlowerName, Description, Price)");
                mySql = mySql +  ("VALUES (") ;
                mySql = mySql +  ("'" +    pFlowers.getFlowerScreen()+ "',") ;
                mySql = mySql +  ("'" +    pFlowers.getFlowerName()   + "',") ;    
                mySql = mySql +  ("'" +    pFlowers.getFlowerDescription() + "',") ;
                mySql = mySql +  ("'" +    pFlowers.getFlowerPrice() + "'") ;
                mySql = mySql +  (")") ;     
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);
              

            }
         catch(SQLException ex)
            {
                System.out.println("Invalid Flower : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
   
    }

}