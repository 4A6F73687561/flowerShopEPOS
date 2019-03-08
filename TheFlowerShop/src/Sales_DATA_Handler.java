
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 30259508
 */
public class Sales_DATA_Handler {

    public void insertSales(Sales pSales) {

        try {
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            pSales.getUserName();

            String mySql = "INSERT INTO Sales ";
            mySql = mySql + ("(UserName  , SalesValue)");
            mySql = mySql + (" VALUES (");
            mySql = mySql + ("'" + pSales.getUserName() + "',");
            mySql = mySql + (" " + pSales.getSalesValue());  // no apostrophe pinnumber is an integer
            mySql = mySql + (")");
            System.out.println("the sql  - " + mySql);
            stmt.executeUpdate(mySql);

        } catch (SQLException ex) {
            System.out.println("checkUserIsValid : Error");
            System.out.println("SQL exception occured\n" + ex);
        }

    }
    
        public static ArrayList<Integer> getAllTheSales () {
                DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
                

               ArrayList<Integer> allTheSales = new ArrayList<>();
                

        try {
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SalesValue FROM Sales WHERE Username = 'Anris'"); //where emloyyee number = number of logged in user change to doubles
             while (rs.next())//move to first record
            {
                Sales pSales= new Sales();
               

            pSales.setSalesValue(rs.getInt("SalesValue"));

            allTheSales.add(pSales);
            
                }

        } catch (SQLException e) {
            System.out.println("getValidSales : Error");
            System.out.println("SQL exception occured" + e);
        }

        //==========================================================='  
        
        return allTheSales;
    }
    
}
