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
class Table extends FurnitureItem {
   
    Table(){
        super();        
    }
    
    public Table (int id){
        super(id);
        System.out.println("Constructing furniture.");
        idNum = 10;
    }
    
    public Table(int id, char tw, int qty){
        super(id, tw, qty);
        System.out.println("Constructing furniture.");
        idNum = 10;
        double cost = 11;
        char ar = 'y';
        System.out.println(idNum);
    }   
}