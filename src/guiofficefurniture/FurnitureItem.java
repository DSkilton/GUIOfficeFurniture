/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiofficefurniture;

import javax.swing.*;
/**
 *
 * @author M1610718 [Duncan Skilton]
 */

public class FurnitureItem {
    
    int idNum;
    private char typeOfWood;
    private double itemPrice;
    private int quantity; 
    private int units;
    private ImageIcon chairImg = new ImageIcon("");
   
    public FurnitureItem() {
        //System.out.println("Constructing furniture: " + arg);
        idNum = 12;
        typeOfWood = 'o';
        quantity = 3;
    }
    
    public FurnitureItem(int id, char tw, int qty){
        this.idNum = id;
        this.typeOfWood = tw; 
        this.quantity = qty;         
    }
        
    public double itemPrice(){
        if (typeOfWood == 'w'){
            itemPrice = 10.00;
            } else if (typeOfWood == 'o'){
            itemPrice = 6.00;
            }      
      
        return itemPrice;    
    }
       
    private int calcUnits(){
        
        int calcUnits = 1625;
            if (Chair.getArmRest() == true) {
                calcUnits += 250; 
            }
        
        return units;
    }
   
    @Override
    public String toString(){
        
        return super.toString() + "  Id Number: " + idNum + "  Quantity: " + quantity + "  Type of Wood: " + typeOfWood + "  Item Price:  £" + itemPrice();
       //return super.toString();
    }

    Icon getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
