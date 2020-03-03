/*
 * Class: MenuManagerGUI
 * Author: Zheng Han
 * Created: 03/20/2018
 */
package edu.pitt.is17.zhh41.menumanager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MenuManagerGUI {
    
    public static void main (String[] args) {
	MenuManagerGUI myGui = new MenuManagerGUI();
      
    }
    
    private JFrame frmMenuManager;
    private JPanel panelBuildYourOwnMenu;
    private JPanel panelCreatedMenus;
    private JPanel panelOrGenerateAMenu;
    private JLabel lblBuildYourOwnMenu;
    private JLabel lblAppetizer;
    private JLabel lblEntree;
    private JLabel lblSide;
    private JLabel lblBeer;
    private JLabel lblOrGenerateAMenu;
    private JLabel lblCreatedMenus;
    private JTextArea txtArea;
    private JButton btnCreateMenuWithTheseDishes;
    private JButton btnGenerateARandomMenu;
    private JButton btnGenerateAMinCalMenu;
    private JButton btnGenerateAMaxCalMenu;
    private JButton btnDetails;
    private JButton btnDeleteAll;
    private JButton btnSaveToFile;
    private JComboBox cboAppetizerOptions;
    private JComboBox cboEntreeOptions;
    private JComboBox cboSideOptions;
    private JComboBox cboBeerOptions;

    private JDialog dialogMenuDetails;
    private JLabel lblAppetizer2;
    private JLabel lblEntree2;
    private JLabel lblSide2;
    private JLabel lblBeer2;
    private JLabel lblTotalCal;
    private JLabel lblTotalPrice;
    private JTextArea txtAppetizerArea;
    private JTextArea txtEntreeArea;
    private JTextArea txtSideArea;
    private JTextArea txtBeerArea;
    private JTextArea txtTotalCal;
    private JTextArea txtTotalPrice;
    private DefaultListModel createdMenuModel = new DefaultListModel();

    private MenuManager myMenuManager;
    
    //create a new MenuManager object that loads the data from file "dishes.txt" which is in the same project folder
    public MenuManagerGUI(){
        try {
            myMenuManager = new MenuManager("dishes.txt");
            
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        //create a JFrame with title "Menu Manager"
        frmMenuManager = new JFrame("Menu Manager");
        frmMenuManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frmMenuManager.setResizable(false); 
        frmMenuManager.setBounds(100, 100, 800, 600); 
        frmMenuManager.setLayout(null);
       
        //add a JPanel with title "Build your own Menu" in the JFrame 
        panelBuildYourOwnMenu = new JPanel();
        panelBuildYourOwnMenu.setLayout(null);
        panelBuildYourOwnMenu.setBorder(new TitledBorder("Build your own Menu"));
        panelBuildYourOwnMenu.setBounds(10, 10, 350, 260);
        frmMenuManager.add(panelBuildYourOwnMenu);
        
        //below is to add four JLabels as Appetizer, Entree, Side, Beer in the "Buid your own Menu" panel
        lblAppetizer = new JLabel("Appetizer");
        lblAppetizer.setBounds(20, 40, 100, 20);
        panelBuildYourOwnMenu.add(lblAppetizer);
       
        lblEntree = new JLabel("Entree");
        lblEntree.setBounds(20, 80, 100, 20);
        panelBuildYourOwnMenu.add(lblEntree);
       
        lblSide = new JLabel("Side");
        lblSide.setBounds(20, 120, 100, 20);
        panelBuildYourOwnMenu.add(lblSide);
              
        lblBeer = new JLabel("Beer");
        lblBeer.setBounds(20, 160, 100, 20);
        panelBuildYourOwnMenu.add(lblBeer);
        
        
        ArrayList<String> appertizerNames = new ArrayList<String>();        
        //use enhanced for loop to add appetizer element to the arraylist appetizerNames
        for(Appetizer appetizer : myMenuManager.getAppetizers()) {
            appertizerNames.add(appetizer.getName());
        }
        //add a JComboBox to accormodate all appetizers
        cboAppetizerOptions = new JComboBox(appertizerNames.toArray());
        cboAppetizerOptions.setBounds(100, 40, 200, 20);
        panelBuildYourOwnMenu.add(cboAppetizerOptions);
        
        ArrayList<String> entreeNames = new ArrayList<String>();        
        for(Entree entree : myMenuManager.getEntrees()) {
            entreeNames.add(entree.getName());
        }
        cboEntreeOptions = new JComboBox(entreeNames.toArray());
        cboEntreeOptions.setBounds(100, 80, 200, 20);
        panelBuildYourOwnMenu.add(cboEntreeOptions);
        
        ArrayList<String> sideNames = new ArrayList<String>();        
        for(Side side : myMenuManager.getSides()) {
            sideNames.add(side.getName());
        }
        cboSideOptions = new JComboBox(sideNames.toArray());
        cboSideOptions.setBounds(100, 120, 200, 20);
        panelBuildYourOwnMenu.add(cboSideOptions);
        
        ArrayList<String> beerNames = new ArrayList<String>();        
        for(Beer beer : myMenuManager.getBeers()) {
            beerNames.add(beer.getName());
        }
        cboBeerOptions = new JComboBox(beerNames.toArray());
        cboBeerOptions.setBounds(100, 160, 200, 20);
        panelBuildYourOwnMenu.add(cboBeerOptions);
        
        //add a button called "Create Menu with these dishes"
        btnCreateMenuWithTheseDishes = new JButton("Create Menu with these dishes");
        btnCreateMenuWithTheseDishes.setBounds(20, 200, 280, 30);
        btnCreateMenuWithTheseDishes.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    String menuName = JOptionPane.showInputDialog("Please enter the menu name:");
                    Menu manulMenu = new Menu(menuName);
                    //use getSelectedIndex() method to get the appetizer that the user selected
                    Appetizer selectedAppetizer = myMenuManager.getAppetizers().get(cboAppetizerOptions.getSelectedIndex());
                    manulMenu.setAppetizer(selectedAppetizer);
                    Entree selectedEntree = myMenuManager.getEntrees().get(cboEntreeOptions.getSelectedIndex());
                    manulMenu.setEntree(selectedEntree);
                    Side selectedSide = myMenuManager.getSides().get(cboSideOptions.getSelectedIndex());
                    manulMenu.setSide(selectedSide);
                    Beer selectedBeer = myMenuManager.getBeers().get(cboBeerOptions.getSelectedIndex());
                    manulMenu.setBeer(selectedBeer);
                    //the DefaultlisModel createdMenuModel is used to hold all created menus which will be added to JList later
                    createdMenuModel.addElement(manulMenu);
            }
        });
        panelBuildYourOwnMenu.add(btnCreateMenuWithTheseDishes);
        
        lblCreatedMenus = new JLabel("Created Menus:");
        lblCreatedMenus.setBounds(400, 10, 100, 20);
        frmMenuManager.add(lblCreatedMenus);
        
        panelCreatedMenus = new JPanel();
        panelCreatedMenus.setLayout(null);
        panelCreatedMenus.setBorder(new TitledBorder(""));
        panelCreatedMenus.setBounds(400, 40, 340, 450);

        frmMenuManager.add(panelCreatedMenus);    
        
        panelOrGenerateAMenu = new JPanel();
        panelOrGenerateAMenu.setLayout(null);
        panelOrGenerateAMenu.setBorder(new TitledBorder("Or generate a Menu"));
        panelOrGenerateAMenu.setBounds(10, 300, 350, 230);
        frmMenuManager.add(panelOrGenerateAMenu);
        
        //the methods in MenuManager class are used to generate various menus as random, min calories and max calories
        btnGenerateARandomMenu = new JButton("Generate a Random Menu");
        btnGenerateARandomMenu.setBounds(20, 40, 280, 30);
        btnGenerateARandomMenu.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    String menuName = JOptionPane.showInputDialog("Please enter the menu name:");
                    Menu randomMenu = new Menu(menuName);
                    randomMenu = myMenuManager.randomMenu(menuName); 
                    createdMenuModel.addElement(randomMenu);
            }
        });
        panelOrGenerateAMenu.add(btnGenerateARandomMenu);

        btnGenerateAMinCalMenu = new JButton("Generate a Minimum Calories Menu");
        btnGenerateAMinCalMenu.setBounds(20, 100, 280, 30);
        btnGenerateAMinCalMenu.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    String menuName = JOptionPane.showInputDialog("Please enter the menu name:");
                    Menu minCalMenu = new Menu(menuName);
                    minCalMenu = myMenuManager.minCaloriesMenu(menuName); 
                    createdMenuModel.addElement(minCalMenu);
            }
        });
        panelOrGenerateAMenu.add(btnGenerateAMinCalMenu);  
        
        btnGenerateAMaxCalMenu = new JButton("Generate a Maximum Calories Menu");
        btnGenerateAMaxCalMenu.setBounds(20, 160, 280, 30);
        btnGenerateAMaxCalMenu.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    String menuName = JOptionPane.showInputDialog("Please enter the menu name:");
                    Menu maxCalMenu = new Menu(menuName);
                    maxCalMenu = myMenuManager.maxCaloriesMenu(menuName); 
                    createdMenuModel.addElement(maxCalMenu);
            }
        });
        panelOrGenerateAMenu.add(btnGenerateAMaxCalMenu); 
        
        //the JList that takes the createdMenuModel is added to the panel
        JList menuList = new JList(createdMenuModel);
        menuList.setBounds(20, 20, 300, 360);
        panelCreatedMenus.add(menuList);
        
        btnDetails = new JButton("Details");
        btnDetails.setBounds(400, 500, 100, 30);
        btnDetails.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    //typecast the selected menu in the JList to Menu and then get name of the menu to be used as the title of the JDialog
                    Menu selectedMenu = (Menu)menuList.getSelectedValue();
                    String menuName = selectedMenu.getName();
                    dialogMenuDetails = new JDialog(frmMenuManager, "Menu: " + menuName);
                    dialogMenuDetails.setResizable(false); 
                    dialogMenuDetails.setBounds(100, 100, 700, 550); 
                    dialogMenuDetails.setLayout(null);
                    dialogMenuDetails.setVisible(true);
                    
                    lblAppetizer2 = new JLabel("Appetizer");
                    lblAppetizer2.setBounds(20, 40, 100, 20);
                    dialogMenuDetails.add(lblAppetizer2);
                    
                    lblEntree2 = new JLabel("Entree");
                    lblEntree2.setBounds(20, 120, 100, 20);
                    dialogMenuDetails.add(lblEntree2);
                    
                    lblSide2 = new JLabel("Side");
                    lblSide2.setBounds(20, 200, 100, 20);
                    dialogMenuDetails.add(lblSide2);
                    
                    lblBeer2 = new JLabel("Beer");
                    lblBeer2.setBounds(20, 280, 100, 20);
                    dialogMenuDetails.add(lblBeer2);
                    
                    lblTotalCal = new JLabel("Total calories:");
                    lblTotalCal.setBounds(20, 360, 100, 20);
                    dialogMenuDetails.add(lblTotalCal);
                    
                    lblTotalPrice = new JLabel("Total price: $");
                    lblTotalPrice.setBounds(20, 420, 100, 20);
                    dialogMenuDetails.add(lblTotalPrice);
                    
                    //the text area is not editable by users
                    txtAppetizerArea = new JTextArea();
                    txtAppetizerArea.setBounds(120, 40, 500, 70);
                    txtAppetizerArea.setText(selectedMenu.getAppetizer().getName()+".\n"+selectedMenu.getAppetizer().getDescription()+". Calories: "+ selectedMenu.getAppetizer().getCalories()+". Price: $"+selectedMenu.getAppetizer().getPrice());
                    txtAppetizerArea.setEditable(false);
                    dialogMenuDetails.add(txtAppetizerArea);
                    
                    
                    txtEntreeArea = new JTextArea();
                    txtEntreeArea.setBounds(120, 120, 500, 70);
                    txtEntreeArea.setText(selectedMenu.getEntree().getName()+".\n"+selectedMenu.getEntree().getDescription()+". Calories: "+ selectedMenu.getEntree().getCalories()+". Price: $"+selectedMenu.getEntree().getPrice());
                    txtEntreeArea.setEditable(false);
                    txtEntreeArea.setLineWrap(true);
                    txtEntreeArea.setWrapStyleWord(true);
                    dialogMenuDetails.add(txtEntreeArea);
                    
                    txtSideArea = new JTextArea();
                    txtSideArea.setBounds(120, 200, 500, 70);
                    txtSideArea.setText(selectedMenu.getSide().getName()+".\n"+selectedMenu.getSide().getDescription()+". Calories: "+ selectedMenu.getSide().getCalories()+". Price: $"+selectedMenu.getSide().getPrice());
                    txtSideArea.setEditable(false);
                    dialogMenuDetails.add(txtSideArea);
                    
                    txtBeerArea = new JTextArea();
                    txtBeerArea.setBounds(120, 280, 500, 70);
                    txtBeerArea.setText(selectedMenu.getBeer().getName()+".\n"+selectedMenu.getBeer().getDescription()+". Calories: "+ selectedMenu.getBeer().getCalories()+". Price: $"+selectedMenu.getBeer().getPrice());
                    txtBeerArea.setEditable(false);
                    dialogMenuDetails.add(txtBeerArea);
                    
                    txtTotalCal = new JTextArea();
                    txtTotalCal.setBounds(120, 360, 100, 50);
                    txtTotalCal.setText("" + selectedMenu.totalCalories());
                    txtTotalCal.setEditable(false);
                    dialogMenuDetails.add(txtTotalCal);
                    
                    txtTotalPrice = new JTextArea();
                    txtTotalPrice.setBounds(120, 420, 100, 50);
                    txtTotalPrice.setText("" + selectedMenu.totalPrice());
                    txtTotalPrice.setEditable(false);
                    dialogMenuDetails.add(txtTotalPrice);
            }
        });
        frmMenuManager.add(btnDetails);
        
        btnDeleteAll = new JButton("Delete all");
        btnDeleteAll.setBounds(520, 500, 100, 30);
        btnDeleteAll.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    //this is to remove the menus in createdMenuModel
                    createdMenuModel.clear();
            }
        });
        frmMenuManager.add(btnDeleteAll);
        
        btnSaveToFile = new JButton("Save to file");
        btnSaveToFile.setBounds(640, 500, 100, 30);
        btnSaveToFile.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                    try{
                    //in order to use the FileManager.writeMenuf method, an arraylist is converted from the createdMenuModel
                    Menu[] selectedMenus = new Menu[createdMenuModel.getSize()];
                    createdMenuModel.copyInto(selectedMenus);
                    ArrayList<Menu> mySelectedMenus = new ArrayList<Menu>();
                    for(Menu menu : selectedMenus){
                        mySelectedMenus.add(menu);  
                    }
                    FileManager.writeMenu("All_Menus.txt", mySelectedMenus);//"All_Menus.txt" file will be created in the same project folder
                    JOptionPane.showMessageDialog(null, "The file All_Menus.txt has been created.");
                    }
                    catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Failed to create the file All_Menus.txt." + ex.getMessage());
                    }
            }
        });
        frmMenuManager.add(btnSaveToFile);
        
        //set the JFrame visible upon running the main method
        frmMenuManager.setVisible(true);
    }    
    
}
