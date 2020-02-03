package guiofficefurniture;
/**
 *
 * @author mc03225
 */

public class Chair extends FurnitureItem {

    //default true
    private static Boolean armRest; 

    Chair() {
        super();
        armRest = false;
        itemPrice();   
    }
    
    Chair (int id){
        
    }
    
    Chair (int id, char ar){
        
    }

    
    
    Chair (int id, char tw, int qty, Boolean arm) {
        super(id, tw, qty);
        armRest = arm;
        itemPrice();
    }
    
    public static void setArmRest(boolean armRest) {
        armRest = armRest; 
    }
    
    public static Boolean getArmRest() {
        return armRest;
    }    
    
    public int cost(){
        int cost = 0;
        
    return cost;
    }
    
    
}
