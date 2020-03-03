/*
 * Class: FileManager
 * Author: Zheng Han
 * Created: 03/20/2018
 */
package edu.pitt.is17.zhh41.menumanager;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class FileManager {

    //this static method takes string and return arraylist
    public static ArrayList<MenuItem> readItems(String fileName){
        ArrayList<MenuItem> myMenuItems = new ArrayList<MenuItem>();
        try{
            Scanner in = new Scanner(new File(fileName));
            //read the file line by line and each line contains all the information of a MenuItem
            while(in.hasNextLine()){
                String input = in.nextLine();
                //split each line by identifier "@@" and save as an array
                String[] parts = input.split("@@");
                String part1 = parts[0];//name of the item
                String part2 = parts[1];//type of the item
                String part3 = parts[2];//description of the item
                String part4 = parts[3];//calories of the item
                String part5 = parts[4];//price of the item
                if(part2.equals("appetizer")){
                    Appetizer myAppetizer = new Appetizer(part1, part3, Integer.parseInt(part4), Double.parseDouble(part5));
                    myMenuItems.add(myAppetizer);
                }else if(part2.equals("entree")){
                    Entree myEntree = new Entree(part1, part3, Integer.parseInt(part4), Double.parseDouble(part5));
                    myMenuItems.add(myEntree);
                }else if(part2.equals("side")){
                    Side mySide = new Side(part1, part3, Integer.parseInt(part4), Double.parseDouble(part5));
                    myMenuItems.add(mySide);
                }else if(part2.equals("beer")){
                    Beer myBeer = new Beer(part1, part3, Integer.parseInt(part4), Double.parseDouble(part5));
                    myMenuItems.add(myBeer);
                }
            }
            in.close();
       
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } 
        
        return myMenuItems;//return the arraylist that stores all items
    }
    
    //this method writes an arraylist into a file
    public static void writeMenu(String fileName, ArrayList<Menu> menus){
        PrintWriter out = null;
        try{
            out = new PrintWriter(new File(fileName));
            for(int i =0; i<menus.size(); i++){
                Menu menu = menus.get(i);
                //to write the information in one line and use the format specifiers to hold the place of the corresponding information
                String line = String.format("Menu: %s. Appetizer: %s, %s, Calories: %d, Price: %.2f; Entree: %s, %s, Calories: %d, Price: %.2f; Side: %s, %s, Calories: %d, Price: %.2f; Beer: %s, %s, Calories: %d, Price: %.2f. Total Calories: %d. Total Price: %.2f.", 
                        menu.getName(),
                        menu.getAppetizer().getName(), menu.getAppetizer().getDescription(),menu.getAppetizer().getCalories(),menu.getAppetizer().getPrice(),
                        menu.getEntree().getName(),menu.getEntree().getDescription(),menu.getEntree().getCalories(),menu.getEntree().getPrice(),
                        menu.getSide().getName(),menu.getSide().getDescription(),menu.getSide().getCalories(),menu.getSide().getPrice(),
                        menu.getBeer().getName(),menu.getBeer().getDescription(),menu.getBeer().getCalories(),menu.getBeer().getPrice(),
                        menu.totalCalories(), menu.totalPrice());
                out.println(line);
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            if(out != null){
                out.close();
            }
        }
        
    }
}