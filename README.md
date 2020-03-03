# Restaurant-Menu-Manager
This is an application for restaurant menu system. It includes the following classes:
## FileManager 
Methods in this class are static and the class has no fields. 
●	The following method  
	public static ArrayList<MenuItem> readItems(String fileName)
reads all types of dishes from a single file in which each line can be an appetizer, entree, side, or beer. The format of a line in file dishes.txt is
	name of dish@@type of the dish@@description of the dish@@calories@@price
Where "type of the dish" is either “appetizer”, "entree", "side", or "beer" (Take a look to the file included dishes.txt). This "type of the dish" determines what kind of object to create, which class to use: Appetizer, Entree, Side, or Beer. Then the object is added to an ArrayList<MenuItem>. Since all these classes extend MenuItem, objects of them can be "treated" generically as MenuItem objects. 
●	The method 
public static void writeMenu( String fileName, ArrayList<Menu> menus )
writes a file (use String fileName parameter) with the information of all the menus in the ArrayList<Menu> menus. You are free of choosing the format in which the data is written, but for each Menu in the ArrayList, all information should be included: name of the menu, name of each dish, description of each dish, calories and price of each dish, plus the sum of all calories, and the total price
## MenuItem
The superclass for Appetizer, Entree, Side, and Beer (all these 4 classes extend MenuItem). As a result, the fields and getters/setters previously defined are moved to MenuItem. Appetizer, Entree, Side, and Beer classes extend MenuItem (as indicated in the figure) and remove from them all fields and Getters/Setters. The fields name, description, calories are now inherited.
## MenuManager
A MenuManager object has an ArrayList of each of the type of dishes. It reads in the file using the method readItems of the class FileManager and fill a single ArrayList of MenuItem. It separates the single ArrayList containing MenuItem objects into the four ArrayList of different types.
●	The method randomMenu creates a Menu object taking randomly one appetizer, one entree, one side, and one beer. The name of the menu is passed in the parameter String name.

●	Methods minCaloriesMenu() and maxCaloriesMenu() generates the lowest and highest calories menus, respectively. The minimum one picks the Entree with the lowest calorie value among entrees. Same for appetizer, side and beer. The method maxCaloriesMenu() do similarly, but selecting highest calories dishes. 








