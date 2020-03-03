/*
 * Class Menu
 * Author: Zheng Han
 * Created: 03/07/2018
 */
package edu.pitt.is17.zhh41.menumanager;

public class Menu {
        private String name;
        private Appetizer appetizer;
        private Entree entree;
        private Side side;
        private Beer beer;
        private int totalCalories = 0;
        private String description = "";
        private double totalPrice = 0;
        
        
        public Menu(String name){
                this.name=name;                
                this.appetizer=null;
                this.entree=null;
                this.side=null;
                this.beer=null;
        }
        
        public Menu(String name, Entree entree,Side side){
                this.name=name;
                this.appetizer=null;
                this.entree=entree;
                this.side=side;
                this.beer=null;
        }
        
        public Menu(String name, Appetizer appetizer, Entree entree, Side side, Beer beer){
                this.name=name;
                this.appetizer=appetizer;
                this.entree=entree;
                this.side=side;
                this.beer=beer;
        }
        
        /*the getCalories() method only works when the object is not null. 
        the total Calories method then returns total calories of all dishes which are not null*/
        public int totalCalories(){
                int result = 0;
                if (appetizer!=null)
                    result+=appetizer.getCalories();
                if (entree!=null)
                    result+=entree.getCalories();
                if (side!=null)
                    result+=side.getCalories();
                if (beer!=null)
                    result+=beer.getCalories();
                return result;
        }
        
        public double totalPrice(){
                int result = 0;
                if (appetizer!=null)
                    result+=appetizer.getPrice();
                if (entree!=null)
                    result+=entree.getPrice();
                if (side!=null)
                    result+=side.getPrice();
                if (beer!=null)
                    result+=beer.getPrice();
                return result;
        }
        //when object is null, its description is N/A.
        public String description(){
                String result = "";
                if (appetizer==null){
                        result+= "Appetizer: N/A.\n";
                } else {
                    result+="Appetizer: "+appetizer.getName()+". "+appetizer.getDescription()+".\n";
                }            
                if (entree==null){
                        result+="Entree: N/A.\n";
                } else {
                  result+="Entree: "+entree.getName()+". "+entree.getDescription()+".\n";
                }
                if (side==null){
                        result+="Side: N/A.\n";
                } else {
                    result+="Side: "+side.getName()+". "+side.getDescription()+".\n"; 
                }
                if (beer==null){
                        result+="Beer: N/A.\n";
                } else {
                        result+="Beer: "+beer.getName()+". "+beer.getDescription()+".\n"; 
                }
                return result;
        }
        
        public String getName(){
                return name;
        }
        
        public void setName(String name){
                this.name=name;
        }
        
        public Appetizer getAppetizer() {
		return appetizer;
	}

	public void setAppetizer(Appetizer appetizer) {
		this.appetizer = appetizer;
	}

	public Entree getEntree() {
		return entree;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public Beer getBeer() {
		return beer;
	}

	public void setBeer(Beer beer) {
		this.beer = beer;
	}
        
        //override toString to print name
        public String toString(){
                return name;
        }
}
