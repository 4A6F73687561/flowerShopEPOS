/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 30259508
 */
public class User {
    
    //attributes====================
    private String firstName;
    private String lastName;
    private int pinNumber;
    private String userName;
    private String role;
    //======constructor===============
    
    public User(){
    //default constructor   
    //if you indlude an overloaded consructor then you must include a default
    }
    
    public User (String pFirstName, String pLastName,String pUserName, int pPinNumber, String pRole) 
    {
    //overloaded constructor    
    // these need guards !! - I have not added these but you should be adding these if you intend 
    // to use this overloaded constructor
    this.pinNumber=pPinNumber;
    this.firstName=pFirstName; 
    this.lastName=pLastName;
    this.userName=pUserName;
    this.role = pRole;

    }
    
    //setters========================
    //p is telling me that this is a parameter variable
      public void setRole(String pRole){
        // Accessor method- these guard aginst false data being use for state.
        if (!pRole.equals("")){
            this.role=pRole;
        }
      }   
        
        
       public void setPinNumber(int pPinNumber){
        // Accessor method- these guard aginst false data being use for state.
        if (pPinNumber > 10000){
            this.pinNumber=pPinNumber;
        }
        
    }
    
    public void setFirstName(String pFirstName){
        // Accessor method- these guard aginst false data being use for state.
        if (!pFirstName.equals("")){
            this.firstName=pFirstName;
        }
        
    }
    
        public void setLastName(String pLastName){
         // Accessor method- these guard aginst false data being use for state.
        if (!pLastName.equals("")){
            this.lastName=pLastName;
        }
        
        }
        public void setUserName(String pUserName){
         // Accessor method- these guard against false data being use for state.
        if (!pUserName.equals("")){
            this.userName=pUserName;
        }
    }
    
      //===========getters========================
    
       public String getFirstName(){
        // Accessor method- these guard aginst false being use for state.
            return this.firstName;
    }
              public String getLastName(){
        // Accessor method- these guard aginst false being use for state.
            return this.lastName;
    }
         public String getUserName(){
        // Accessor method- these guard aginst false being use for state.
            return this.userName;
    }
              public int getPinNumber(){
        // Accessor method- these guard aginst false being used for state.
            return this.pinNumber;
    }
              
       public String getRole(){
        // Accessor method- these guard aginst false being used for state.
            return this.role;
    }         
       
       
    @Override
       public String toString(){

           StringBuilder theStringVersionOfTheUser= new StringBuilder();
           
           theStringVersionOfTheUser.append(this.pinNumber).append(" , ");
           theStringVersionOfTheUser.append(this.firstName ).append(" , ");
           theStringVersionOfTheUser.append( this.lastName ).append(" , ");
           theStringVersionOfTheUser.append(this.role).append(" , ");
           theStringVersionOfTheUser.append(this.userName );
           
           return theStringVersionOfTheUser.toString();
       }
           
    
}
