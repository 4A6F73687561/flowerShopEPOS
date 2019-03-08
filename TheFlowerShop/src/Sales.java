/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 30259508
 */
public class Sales {

    private String userName;
    private int salesValue;

    public Sales(String pUserName, int pSalesValue) {

        this.userName = pUserName;
        this.salesValue = pSalesValue;

    }

    public Sales() {

    }

    public void setUserName(String pUserName) {

        if (!pUserName.equals("")) {
            this.userName = pUserName;
        }
    }

    public String getUserName() {
        // Accessor method- these guard aginst false being use for state.
        return this.userName;
    }

    public void setSalesValue(int pSalesValue) {
        this.salesValue = pSalesValue;
    }
    
    public int getSalesValue() {
        return this.salesValue;
    }
    
    
}
