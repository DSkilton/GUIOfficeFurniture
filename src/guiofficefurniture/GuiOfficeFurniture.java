package guiofficefurniture;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class GuiOfficeFurniture extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    private JLabel Chair1, Chair2, Desk1, Desk2, Desk3, Desk4, Table1, Table2;
    //private JLabel emptySmall1, emptySmall2, emptySmall3, emptySmall4, emptySmall5, emptySmall6;
    //private JLabel emptyLarge1, emptyLarge2, emptyLarge3;
    private ImageIcon c1, c2, d1, d2, d3, d4, t1, t2; 
    //private ImageIcon eS1, eS2, eS3, eS4, eS5, eS6, eL1, eL2, eL3;

    int iSmallGridIndex = 0;
    int iLargeGridIndex = 0;
    String chairIDNum;
    String selectedWood;
    String selectedArmType;
    String qty;

    //Gridbag Layout 
    final boolean shouldFill = true;
    final boolean shouldWeightX = true;
        
    //IMAGEICONS
    ImageIcon emptySmall = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
    JLabel[] emptySmallLabel = new JLabel[6];
    
    ImageIcon emptyLarge = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));   
    JLabel[] emptyLargeLabel = new JLabel[3];
        
    //ARRAYS    
    // The [6] & [3] set the max for the array
    static FurnitureItem[] smallItem = new FurnitureItem[6];
    static FurnitureItem[] largeItem = new FurnitureItem[3];
    
    //CONSTRUCTORS
    //static Chair newChair = new Chair();    
    private JButton addChairBTN = new JButton();
    private JButton addTableBTN = new JButton();
    private JButton addDeskBTN = new JButton();
    private JButton clearAllBTN = new JButton();
    private JButton totalPriceBTN = new JButton();
    private JButton saveBTN = new JButton();
    private JButton loadBTN = new JButton();
    private JButton summaryBTN = new JButton();
    
    JTextArea txtArea = new JTextArea(8,38);
    int x,y;
    
    JMenuBar menuBar = new JMenuBar();
    JMenu menu1 = new JMenu("File"); 
    JMenuItem item1 = new JMenuItem("Open");
    JMenuItem item2 = new JMenuItem("Cancel"); 
    
    public GuiOfficeFurniture(){
        super("Real Office Furniture");  
              
        setJMenuBar(menuBar);
        
        //setLayout(new FlowLayout()); 
        setLayout(new BorderLayout());
        Container contentPane = getContentPane();
        
        JPanel pnlNorth = new JPanel();        
        pnlNorth.setBackground(Color.yellow);
        pnlNorth.setOpaque(true);
        
        JPanel pnlSouth = new JPanel();        
        pnlSouth.setBackground(Color.yellow);
        pnlSouth.setOpaque(true);
                
        JPanel btnPanel = new JPanel(new GridLayout(8,1));
        JPanel ctPanel = new JPanel(new GridLayout(3,2));
        JPanel deskPanel = new JPanel(new GridLayout(3,1));
        
        addChairBTN.setPreferredSize(new Dimension(120, 50));
        addChairBTN.setText("Add Chair");
        btnPanel.add(addChairBTN);
        
        addTableBTN.setPreferredSize(new Dimension(120, 50));
        addTableBTN.setText("Add Table");
        btnPanel.add(addTableBTN);
        
        addDeskBTN.setPreferredSize(new Dimension(120, 50));
        addDeskBTN.setText("Add Desk");
        btnPanel.add(addDeskBTN);
        
        clearAllBTN.setPreferredSize(new Dimension(120, 50));
        clearAllBTN.setText("Clear All");
        btnPanel.add(clearAllBTN);
        
        totalPriceBTN.setPreferredSize(new Dimension(120, 50));
        totalPriceBTN.setText("Total Price");
        btnPanel.add(totalPriceBTN);
        
        saveBTN.setPreferredSize(new Dimension(120, 50));
        saveBTN.setText("Save");
        btnPanel.add(saveBTN);
        
        loadBTN.setPreferredSize(new Dimension(120, 50));
        loadBTN.setText("Load");
        btnPanel.add(loadBTN);
        
        summaryBTN.setPreferredSize(new Dimension(120, 50));
        summaryBTN.setText("Total for day");
        btnPanel.add(summaryBTN);
        
        // set the images in an array
        c1 = new ImageIcon(getClass().getResource("/img/Chair1.png"));
        Chair1 = new JLabel(c1);
        Chair1.setOpaque(true);
        
        c2 = new ImageIcon(getClass().getResource("/img/Chair2.png"));
        Chair2 = new JLabel(c2);
        Chair2.setOpaque(true);
        
        d1 = new ImageIcon(getClass().getResource("/img/Desk1.png"));
        Desk1 = new JLabel(d1);
        Desk1.setOpaque(true);
        
        d2 = new ImageIcon(getClass().getResource("/img/Desk2.png"));
        Desk2 = new JLabel(d2);
        Desk2.setOpaque(true);
        
        d3 = new ImageIcon(getClass().getResource("/img/Desk3.png"));
        Desk3 = new JLabel(d3);
        Desk3.setOpaque(true);
        
        d4 = new ImageIcon(getClass().getResource("/img/Desk4.png"));
        Desk4 = new JLabel(d4);
        Desk4.setOpaque(true);
        
        t1 = new ImageIcon(getClass().getResource("/img/Table1.png"));
        Table1 = new JLabel(t1);
        Table1.setOpaque(true);
        
        t2 = new ImageIcon(getClass().getResource("/img/Table2.png"));
        Table2 = new JLabel(t2);
        Table2.setOpaque(true);
        
       
        //need to set es1 etc.. in an array
        
        //ImageIcon eS = new ImageIcon(getClass().getResource("/img/empty_w100xh100.png"));
        //ImageIcon eL = new ImageIcon(getClass().getResource("/img/empty_w150xh100.png"));
        
        //ARRAYS
        for (int i = 0; i < 6; i++) {
            ctPanel.add(emptySmallLabel[i]);
        }
              
        for (int i = 0; i < 3; i++) {
            deskPanel.add(emptyLargeLabel[i]);
        }
        
        pnlNorth.add(new JLabel("Real Office Funiture"));
        pnlSouth.add(txtArea);
        
        contentPane.add("North", pnlNorth);
        contentPane.add("West", btnPanel); 
        contentPane.add("Center", ctPanel);
        contentPane.add("East", deskPanel);
        contentPane.add("South", pnlSouth);

        //BTN listeners 
        addChairBTN.addActionListener(this);
        addTableBTN.addActionListener(this);
        addDeskBTN.addActionListener(this); 
        clearAllBTN.addActionListener(this);
        saveBTN.addActionListener(this);
        loadBTN.addActionListener(this);
        totalPriceBTN.addActionListener(this);

        for (int i = 0; i < 6; i++) {
            emptySmallLabel[i].addMouseListener(this);
        }
        
        for (int i = 0; i < 6; i++){
            emptyLargeLabel[i].addMouseListener(this);
        }
        
        txtArea.addMouseListener(this);
        txtArea.addMouseMotionListener(this);
        
        menu1.add(item1);
        menu1.add(item2);
        menuBar.add(menu1);
    } //end of contructor
    //static void newChair(){
    
    public Chair createChair(){        
        JTextField chairID = new JTextField(8);
        JTextField typeOfWood = new JTextField(8);
        JTextField quantity = new JTextField(5);
        
        ButtonGroup tow = new ButtonGroup();        
        JRadioButton oak = new JRadioButton("Oak", true);
        JRadioButton walnut = new JRadioButton("Walnut");
        tow.add(oak);
        tow.add(walnut);
        
        ButtonGroup chrType = new ButtonGroup(); 
        JRadioButton chair1 = new JRadioButton("Without Armrests", true);
        JRadioButton chair2 = new JRadioButton("With Armrests");
        chrType.add(chair1);
        chrType.add(chair2);
       
        JPanel myChair = new JPanel();
        myChair.add(new JLabel("Chair ID Number: "));
        myChair.add(chairID);
        myChair.add(oak);
        myChair.add(walnut);
        myChair.add(new JLabel("Quantity: "));
        myChair.add(quantity);
        myChair.add(chair1);
        myChair.add(chair2);
        
if (iSmallGridIndex == 6){           
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Small Furniture Display Limit Reached");
        } //end of small grid limit if statement
        
        else { int chairBtnResult = JOptionPane.showConfirmDialog(null, myChair, "Chair Selected", JOptionPane.OK_CANCEL_OPTION);
        
        if (chairBtnResult == JOptionPane.OK_OPTION) {
           System.out.println("chairID: " + chairID.getText());
           if (oak.isSelected()){ 
                selectedWood = "Oak";
                System.out.println("Type of Wood Selected: " + oak.getText());               
           } else if (walnut.isSelected()){
                selectedWood = "Walnut";
                System.out.println("Type of Wood Selected: " + walnut.getText());
           }         
           
           System.out.println("Quantity: " + quantity.getText());

           if (chair1.isSelected()){               
                System.out.println("Chair1: " + chair1.getText());
                //emptySmall3.setIcon(c1);
                selectedArmType = "Without Arm Rest";
                emptySmallLabel[iSmallGridIndex].setIcon(c1);
                iSmallGridIndex++;
           } else if (chair2.isSelected()){
                System.out.println("Chair2: " + chair2.getText());
                //emptySmall6.setIcon(c2);
                selectedArmType = "With Arm Rest";
                emptySmallLabel[iSmallGridIndex].setIcon(c2);
                iSmallGridIndex++;
           } 
        }    
        if (chairBtnResult == JOptionPane.OK_OPTION){
            System.out.println("OK Pressed");
        } else if (chairBtnResult == JOptionPane.CANCEL_OPTION) {          
            System.out.println("Cancel Pressed");      
        }
    }//end else for grid position check
        
    //Chair newChair = new Chair(chairID.getText());
    Chair newChair = new Chair(iSmallGridIndex, chairID.getText(), selectedWood, quantity.getText(), selectedArmType);
     
    return newChair;
    }
    
    public Table createTable(){        
        JTextField TableID = new JTextField(8);
        JTextField typeOfWood = new JTextField(8);
        JTextField quantity = new JTextField(5);
        
        ButtonGroup tow = new ButtonGroup();        
        JRadioButton oak = new JRadioButton("Oak", true);
        JRadioButton walnut = new JRadioButton("Walnut");
        tow.add(oak);
        tow.add(walnut);
        
        JPanel myTable = new JPanel();
        myTable.add(new JLabel("Table ID Number: "));
        myTable.add(TableID);
        myTable.add(oak);
        myTable.add(walnut);
        myTable.add(new JLabel("Quantity: "));
        myTable.add(quantity);
        
        int TableBtnResult = JOptionPane.showConfirmDialog(null, myTable, 
            "Table Selected", JOptionPane.OK_CANCEL_OPTION);
        
        if (TableBtnResult == JOptionPane.OK_OPTION) {
            System.out.println("TableID: " + TableID.getText());
           
            if (oak.isSelected()){               
                System.out.println("Type of Wood Selected: " + oak.getText()); 
            }

            if (walnut.isSelected()){               
                System.out.println("Type of Wood Selected: " + walnut.getText()); 
            } 
                
            System.out.println("Quantity: " + quantity.getText());
            emptySmall3.setIcon(t1);
                //emptySmall1.setIcon(smallItem[0].getImage());
                
                //for (int i = 0; i < 6; i++){
                    
                    //System.out.println(smallSpaces[i]);
                                  
               // }
                
                //emptySmall1.setIcon(c1);
           }
        
        if (TableBtnResult == JOptionPane.OK_OPTION){
            System.out.println("OK Pressed");
            
            } else if (TableBtnResult == JOptionPane.CANCEL_OPTION) {          
            System.out.println("Cancel Pressed");      
        }
        
        Table newTable = new Table(TableID.());     
        return newTable;
    }
    
    public Desk createDesk(){
        
        //experimenting with GridBagLayout for a more fluid look and feel to the app
        Container cPaneCreateDesk = getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints cGridBag = new GridBagConstraints();
        cPaneCreateDesk.setLayout(gridbag);
        
        if(shouldFill){
            cGridBag.fill = GridBagConstraints.HORIZONTAL;
        }

        JTextField DeskID = new JTextField(8);
        JTextField towCreateDesk = new JTextField(8);
        JTextField quantity = new JTextField(3);
        JTextField getWidth = new JTextField(8);
        JTextField getDraws = new JTextField(3);
        
        Box rbCreateDesk = Box.createVerticalBox();
        ButtonGroup towButton = new ButtonGroup();        
        
        JRadioButton oak = new JRadioButton("Oak", true);
        JRadioButton walnut = new JRadioButton("Walnut");
        
        towButton.add(oak);
        towButton.add(walnut);
        rbCreateDesk.add(oak);
        rbCreateDesk.add(walnut);
        
        rbCreateDesk.setBorder(BorderFactory.createTitledBorder("Wood Type"));
        //addItem(cPaneCreateDesk, rbCreateDesk, 0, 2, 1, 1, GridBagConstraints.NORTH);
        
        JPanel myDesk = new JPanel(new GridLayout(2,6));
        myDesk.add(new JLabel("Desk ID Number: "));

        myDesk.add(DeskID);
        myDesk.add(new JLabel("Wood Type: "));
        myDesk.add(oak);
        myDesk.add(walnut);
        myDesk.add(new JLabel("Quantity: "));
        myDesk.add(quantity);
        myDesk.add(new JLabel("Desk Width: "));
        myDesk.add(getWidth);

        //Heigh must always be 80cm
        myDesk.add(new JLabel("Height: "));
        myDesk.add(new JLabel("80cm "));
        myDesk.add(new JLabel ("Draw Qty: "));
        myDesk.add(getDraws);

        int DeskBtnResult = JOptionPane.showConfirmDialog(null, myDesk, 
            "Desk Selected", JOptionPane.OK_CANCEL_OPTION);

        if (DeskBtnResult == JOptionPane.OK_OPTION) {
           System.out.println("DeskID: " + DeskID.getText());

        if (oak.isSelected()){               
            System.out.println("Type of Wood Selected: " + oak.getText());
        } 

        if (walnut.isSelected()){               
            System.out.println("Type of Wood Selected: " + walnut.getText());
        } 

            System.out.println("Quantity: " + quantity.getText());

                emptySmall3.setIcon(d1);
                //emptySmall1.setIcon(smallItem[0].getImage());
                //for (int i = 0; i < 6; i++){
                    //System.out.println(smallSpaces[i]);
                // }
                //emptySmall1.setIcon(c1);
           }

        if (DeskBtnResult == JOptionPane.OK_OPTION){
            System.out.println("OK Pressed");

            }else if (DeskBtnResult == JOptionPane.CANCEL_OPTION) {          
            System.out.println("Cancel Pressed");      
        }

        Desk newDesk = new Desk(DeskID.getText());

        return newDesk;
        }    
         
    public void mouseEntered(MouseEvent event){
        txtArea.setText("Mouse Entered");
    }

    public void mousePressed(MouseEvent event){
        //txtArea.append("\nMouse Pressed at X: " + x + " Y" + y);
        if (SwingUtilities.isLeftMouseButton(event)){
            txtArea.append("\nLeft Mouse Button Clicked");
        }
        if (SwingUtilities.isMiddleMouseButton(event)){
            txtArea.append("\nMiddle Mouse Button Clicked");
        }
        if (SwingUtilities.isRightMouseButton(event)){
            txtArea.append("\nRight Mouse Button Clicked");
        }
    }

    public void mouseReleased(MouseEvent event){
    JLabel clickedLabel = (JLabel) event.getSource();
         
        int smallLabelPos = -1; //no match
        
        for (int i = 0; i < 6; i++) {
            if (clickedLabel == emptySmallLabel[i])    // match
            {
                smallLabelPos = i;
                txtArea.append("\nYou have clicked on a small empty space");
                break;
            }
        }
        System.out.println("Position: " + smallLabelPos);
       
        int largeLabelPos = -1; //no match
        
        for (int i = 0; i < 3; i++) {
            if (clickedLabel == emptyLargeLabel[i])    // match
            {
                largeLabelPos = i;
                txtArea.append("\nYou have clicked on a large empty space");
                break;
            }
        }
        System.out.println("Position: " + largeLabelPos);

        if(event.getButton() == MouseEvent.BUTTON1) {             
            if (clickedLabel.getIcon() == c1 || clickedLabel.getIcon() == c2){           
            System.out.println("Small Furniture Found");
            smallFurnitureSummary(smallLabelPos);       
            }
            /**
            if (clickedLabel.getIcon() == c1 || clickedLabel.getIcon() == c2 ){
            txtArea.append("\nYou have clicked on a Chair 1");
            String to_print = "ID: " + chairID.getText() + "\nType Of Wood: " + selectedWood + "\nQuantity: " + quantity.getText() + "\nArmRests: " + selectedArmType;
            JOptionPane.showMessageDialog(null, to_print, "Item Details", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nLeft Click!");
          }
          **/
        }// end button 1 
          if(event.getButton() == MouseEvent.BUTTON2) {
            if (clickedLabel.getIcon() == c1){
            JOptionPane.showMessageDialog(null, "","Change/Update Item", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nMiddle Click!");
          } 
            
        } // end button 2
          if(event.getButton() == MouseEvent.BUTTON3) {
            if (clickedLabel.getIcon() == c1){
            JOptionPane.showMessageDialog(null, "", "Remove the Item", JOptionPane.INFORMATION_MESSAGE);
            txtArea.append("\nRight Click!");
            }
          } //end button 3

    }

    public void mouseClicked(MouseEvent event){}

    public void mouseExited(MouseEvent event){}

    public void mouseMoved(MouseEvent event){
        x = event.getX(); y = event.getY();
    }

    public void mouseDragged(MouseEvent event){}
    
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == addChairBTN){

            addChair();
            System.out.println("Chair Button Pressed");
        }

        if(event.getSource() == addTableBTN){

            System.out.println("Table Button Pressed");

        }

        if(event.getSource() == addDeskBTN){

            System.out.println("Desk Button Pressed");

        }
        
        if(event.getSource() == clearAllBTN){

            System.out.println("Clear All Button Pressed");
            iSmallGridIndex = 0; //reset position
            
            for (int i = 0; i < 6; i++){     
                //emptySmallLabel[i] = new JLabel();
                emptySmallLabel[i].setIcon(emptySmall);          
            }

        }
        
        if(event.getSource() == totalPriceBTN){

            System.out.println("Total Price Button Pressed");

        }       

    }

    public static void main(String[] args) {
        GuiOfficeFurniture RealOfficeFuniture = new GuiOfficeFurniture(); 
        //RealOfficeFuniture.setSize(500,200);
        RealOfficeFuniture.pack();    
        RealOfficeFuniture.setDefaultCloseOperation(EXIT_ON_CLOSE);
        RealOfficeFuniture.setVisible(true);
    }
}
