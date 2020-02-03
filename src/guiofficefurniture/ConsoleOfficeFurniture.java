package guiofficefurniture;

import java.util.Scanner;
import javax.swing.*;

public class ConsoleOfficeFurniture {
    static FurnitureItem newFurnitureItem = new FurnitureItem();
    static Chair newChair = new Chair();
    static Desk newDesk = new Desk();
    static Table newTable = new Table();

    public static void main(String[] args) {
        
        //int idNum = 0;
        int idNum = addFurnitureItem();
        int choice = menu();
        
        while (choice != 0) {
            switch(choice){
                case 1: addChair();
                        choice = menu();
                        break;
                case 2: addTable(idNum);
                        choice = menu();
                        break; 
                case 3: addDesk(idNum);
                        choice = menu();
                        break;                  
            }
        }
        
    }
    
    static int menu(){ //displays the main menu and returns user choice to the switch in main method
        
        int iChoice;
        Scanner sc = new Scanner(System.in);
        
            do{
                System.out.println("Please Enter Your Furniture Type \n" +
                              "1. Add Chair \n" +
                              "2. Add Table \n" +
                              "3. Add Desk \n" +
                              "0. Exit");      
                iChoice = sc.nextInt();
            } 
            while (iChoice < 0 || iChoice > 3);
        
        return iChoice;
    }
    
    static int addFurnitureItem(){
        int idNum;
        char typeOfWood;
        int quantity;
        
        ImageIcon i = new ImageIcon("Chair1.jpg");
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please Enter a furniture id : ");
        idNum = sc.nextInt();
            
        System.out.println("Please Enter quantity : ");
        quantity = sc.nextInt();
            
        System.out.println("Please Enter type of wood (o or w) : ");
        typeOfWood = sc.next().charAt(0);
             
        newFurnitureItem = new FurnitureItem(idNum, typeOfWood, quantity);
        
        System.out.println("\nSUMMARY : " + newFurnitureItem.toString());
        
        return idNum;      
    }   
      
    static int addChair(){
        int idNum = 0;
        char ar;
        double cost = 0;
        
        ImageIcon i = new ImageIcon("Chair1.jpg");
        
        Scanner keyboard = new Scanner(System.in);
            
        System.out.println("Do you require armrest? (y or n) : ");
            ar = keyboard.next().charAt(0);
        
        newChair = new Chair(idNum, ar);
        
        System.out.println("\nSUMMARY : " + newChair.toString() + "  Cost: " + newChair.cost() +  "  Armrests: " + newChair.getArmRest());
        
        return idNum;
    }   
    
        static void addTable(int idNum){
        
        int diameter;
        char base;
        
        ImageIcon i = new ImageIcon("Table1.jpg");
        
        Scanner keyboard = new Scanner(System.in);
            
        System.out.println("Enter Diameter: ");
            diameter = keyboard.nextInt();
            
        System.out.println("Type of Base? (w or c) : ");
            base = keyboard.next().charAt(0);
        
        newTable = new Table(idNum);
        
        System.out.println("\nSUMMARY : " + newTable.toString());     
    }  
      
       static void addDesk(int idNum){
           
       int width;
       int depth;
       int numOfDraws;
        
        ImageIcon i = new ImageIcon("Desk1.jpg");
        
        Scanner keyboard = new Scanner(System.in);
            
        System.out.println("Enter Width: ");
            width = keyboard.nextInt();
            
        System.out.println("Enter Depth: ");
            depth = keyboard.nextInt();
            
        System.out.println("Number of Draws: ");
            depth = keyboard.nextInt();
        
        newDesk = new Desk(idNum);
        
        System.out.println("\nSUMMARY : " + newDesk.toString());    
    }   
    
}