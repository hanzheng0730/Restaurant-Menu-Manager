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
	
●The method randomMenu creates a Menu object taking randomly one appetizer, one entree, one side, and one beer. The name of the menu is passed in the parameter String name.

●Methods minCaloriesMenu() and maxCaloriesMenu() generates the lowest and highest calories menus, respectively. The minimum one picks the Entree with the lowest calorie value among entrees. Same for appetizer, side and beer. The method maxCaloriesMenu() do similarly, but selecting highest calories dishes. 

## MenuManagerGUI
It contains all graphic components and a MenuManager object. Also contains a main(String[] args) method. The execution of the MenuManagerGUI.main method creates a MenuManagerGUI object and set the JFrame visible, so the main window appears. The main window in the GUI gives you four options to generate Menu objects. These four options correspond to the buttons:
▪	"Create Menu with these dishes" button take the selected elements in the four comboboxes and creates a menu. Just before creating the menu object, it asks the user to input a name for the menu. The newly created menu is added to the list at the side.
▪	"Generate a Random Menu": this button asks the user to input a name for the new menu and then uses the method randomMenu in class MenuManager. The random menu generated is then added to the list in the right side.
▪	"Generate a Minimum Calories Menu": similarly than the previous button but now using the method minCaloriesMenu() from MenuManager.
▪	"Generate a Maximum Calories Menu": similarly than the previous button but now using the method maxCaloriesMenu() from MenuManager.

The button Details displays the secondary window filling all the fields contained there with the information of the selected Menu in the list of generated menus in the main window. If no menu is selected in the list, then the secondary window is not shown.
The button "Delete all" removes all Menu elements from the list.
The button "Save to File" writes a file "data/menus.txt" with the whole data of the menus in the list.
All text fields in the secondary window are "read only". This mean their values are filled by the program but the user cannot change them.









