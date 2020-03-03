/*
 * Class: MenuManager
 * Author: Zheng Han
 * Created: 03/20/2018
 */
package edu.pitt.is17.zhh41.menumanager;

import java.util.ArrayList;
import java.util.Random;


public class MenuManager {
    private ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();
    private ArrayList<Entree> entrees = new ArrayList<Entree>();
    private ArrayList<Side> sides = new ArrayList<Side>();
    private ArrayList<Beer> beers = new ArrayList<Beer>();
    
    //the constructor initializes four fields by reading the file
    public MenuManager(String dishesFile){
        //readItems method returns MenuItem object which will be typecased to specific type by using instanceof operator
        ArrayList<MenuItem> menuItems = FileManager.readItems(dishesFile);
        for(int i=0; i<menuItems.size(); i++){
            MenuItem menuItem = menuItems.get(i);
            if(menuItem instanceof Appetizer){
                appetizers.add((Appetizer)menuItem);
            }else if(menuItem instanceof Entree){
                entrees.add((Entree)menuItem);
            }else if(menuItem instanceof Side){
                sides.add((Side)menuItem);
            }else if(menuItem instanceof Beer){
                beers.add((Beer)menuItem);
            }
        }
    }
       
    private Random randomGenerator = new Random();
    public Menu randomMenu(String name){
        Menu menu = new Menu(name);
        
        //this is used to get a random number within the range of the size of the arraylist appetizers
        int index = randomGenerator.nextInt(appetizers.size());
        menu.setAppetizer(appetizers.get(index));
        
        index = randomGenerator.nextInt(entrees.size());
        menu.setEntree(entrees.get(index));
        
        index = randomGenerator.nextInt(sides.size());
        menu.setSide(sides.get(index)); 
        
        index = randomGenerator.nextInt(beers.size());
        menu.setBeer(beers.get(index));
        
        return menu;    
    }
    
    public Menu minCaloriesMenu(String name){
        Menu minMenu = new Menu(name);
        
        Appetizer minAppetizer = appetizers.get(0);
        //use below for loop to locate the appetizer with the min calories
        for(int i=0; i<appetizers.size(); i++){
            if(appetizers.get(i).getCalories()< minAppetizer.getCalories()){
                minAppetizer = appetizers.get(i);
            }
        }
        minMenu.setAppetizer(minAppetizer);
        
        Entree minEntree = entrees.get(0);
        for(int i=0; i<entrees.size(); i++){
            if(entrees.get(i).getCalories()< minEntree.getCalories()){
                minEntree = entrees.get(i);
            }
        }
        minMenu.setEntree(minEntree);
        
        Side minSide = sides.get(0);
        for(int i=0; i<sides.size(); i++){
            if(sides.get(i).getCalories()< minSide.getCalories()){
                minSide = sides.get(i);
            }
        }
        minMenu.setSide(minSide);
        
        Beer minBeer = beers.get(0);
        for(int i=0; i<beers.size(); i++){
            if(beers.get(i).getCalories()< minBeer.getCalories()){
                minBeer = beers.get(i);
            }
        }
        minMenu.setBeer(minBeer);
        
        /*the menu with min calories is constucted by the elements all with min calories,
        in this way the menu with min calories is returned*/
        return minMenu;
    }

    public Menu maxCaloriesMenu(String name){
        Menu maxMenu = new Menu(name);
        
        Appetizer maxAppetizer = appetizers.get(0);
        for(int i=0; i<appetizers.size(); i++){
            if(appetizers.get(i).getCalories()> maxAppetizer.getCalories()){
                maxAppetizer = appetizers.get(i);
            }
        }
        maxMenu.setAppetizer(maxAppetizer);
        
        Entree maxEntree = entrees.get(0);
        for(int i=0; i<entrees.size(); i++){
            if(entrees.get(i).getCalories()> maxEntree.getCalories()){
                maxEntree = entrees.get(i);
            }
        }
        maxMenu.setEntree(maxEntree);
        
        Side maxSide = sides.get(0);
        for(int i=0; i<sides.size(); i++){
            if(sides.get(i).getCalories()> maxSide.getCalories()){
                maxSide = sides.get(i);
            }
        }
        maxMenu.setSide(maxSide);
        
        Beer maxBeer = beers.get(0);
        for(int i=0; i<beers.size(); i++){
            if(beers.get(i).getCalories()> maxBeer.getCalories()){
                maxBeer = beers.get(i);
            }
        }
        maxMenu.setBeer(maxBeer);
        
        return maxMenu;
    } 

        public ArrayList<Appetizer> getAppetizers(){
                return appetizers;
        }
        
        public void setAppetizers(ArrayList<Appetizer> appetizers){
                this.appetizers=appetizers;
        }
        
        public ArrayList<Entree> getEntrees(){
                return entrees;
        }
        
        public void setEntrers(ArrayList<Entree> entrees){
                this.entrees=entrees;
        }
        
        public ArrayList<Side> getSides(){
                return sides;
        }
        
        public void setSides(ArrayList<Side> sides){
                this.sides=sides;
        }
        
        public ArrayList<Beer> getBeers(){
                return beers;
        }
        
        public void setBeers(ArrayList<Beer> beers){
                this.beers=beers;
        }
    
}
