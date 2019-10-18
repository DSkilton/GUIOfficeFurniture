package guiofficefurniture;
/**
 *
 * @author mc03225
 */

public class Chair extends FurnitureItem {
    //default true
    private Boolean armRest; 

    Chair() {
        super();
        armRest = false;
        itemPrice();   
    }
    
    Chair (int id, char tw, int qty, Boolean arm) {
        super(id, tw, qty);
        armRest = arm;
        itemPrice();
    }
    
    public Boolean getArmRest() {
        return armRest;
    }        
}
