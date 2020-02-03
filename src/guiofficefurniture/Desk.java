/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiofficefurniture;

/**
 *
 * @author mc03225
 */
public class Desk extends FurnitureItem {
    Desk() {
        super();
        int iWidth; 
        int iDepth;
        int iDraws;
    }
    
   
    
    Desk (int id, char tw, int qty, int iWidth, int iDepth, int iDraws) {
        super(id, tw, qty);
        itemPrice();
    }

    Desk(int id) {
        super(id);
        itemPrice();
    }
    

}
