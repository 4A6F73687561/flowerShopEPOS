/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 30259508
 */
public class Flowers {
    
    private String flowerName; 
    private String flowerDescription;
    private double flowerPrice;
    private int  flowerScreen;
    
    public Flowers() {

    }

    public Flowers(String pFlowerName, String pFlowerDescription, double pFlowerPrice) {
        this.flowerName = pFlowerName;
        this.flowerDescription = pFlowerDescription;
        this.flowerPrice = pFlowerPrice;
    }

    public void setFlowerName(String pFlowerName) {

        if (!pFlowerName.equals("")) {
            this.flowerName = pFlowerName;
        }
    }

    public void setFlowerDescription(String pFlowerDescription) {

        if (!pFlowerDescription.equals("")) {
            this.flowerDescription = pFlowerDescription;
        }
    }
    
    public void setFlowerPrice(double pFlowerPrice) {
        
       if (pFlowerPrice>0.0){
            this.flowerPrice = pFlowerPrice;
       }
    }
    
    public void setFlowerScreen(int pFlowerScreen){
        if(pFlowerScreen>0) {
            this.flowerScreen = pFlowerScreen;
      }
    }
    
    public String getFlowerName(){
        return this.flowerName;
    }
    
    public String getFlowerDescription(){
        return this.flowerDescription;
    }
    
    public double getFlowerPrice(){
        return this.flowerPrice;
    }
    
    public int getFlowerScreen(){
        return this.flowerScreen;
    }
    
    
    @Override
    public String toString(){
        StringBuilder toStringOverrideSpices = new StringBuilder();
        
        toStringOverrideSpices.append(this.flowerName).append(" , ");
        toStringOverrideSpices.append(this.flowerDescription).append(" , ");
        toStringOverrideSpices.append(this.flowerPrice).append(" , ");
        toStringOverrideSpices.append(this.flowerScreen).append(" , ");
        
        return toStringOverrideSpices.toString();
        
    }
    
    

}
