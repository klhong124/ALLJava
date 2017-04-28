/**
 * Show the main flow of customers
 * @author ALL Boys Project Team
 * @version 1.0
 */
package ALLJava;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CustomerMainFlow extends PreOrder{  
	HashMap<Integer,String>RemoveMenu=new HashMap<Integer,String>();
	int number;
	boolean quit = false;
	int x;double y;int z;
	
	/**
	 * Reading order
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void ReadOrderBill() throws ClassNotFoundException, IOException{
		System.out.println("\nHere is your Order:");
		x=0;y=0;z=1;double[][] calculator={{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		while (true){
			File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x));
			if(file.exists()){
				foodMenu.InputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu", Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x)+"\\FoodOrder");
				RemoveMenu.put(z, "FoodMenuOrder"+String.valueOf(x));
				System.out.println("Order ["+z+"]");z++;
				foodMenu.ShowSelectionMenu("Food","");
				calculator[0][x]=foodMenu.Calculator();
				x++;}else{x=0;break;}}
		while (true){
			File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x));
			if(file.exists()){
				drinkMenu.InputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu", Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x)+"\\DrinkOrder");
				RemoveMenu.put(z, "DrinkMenuOrder"+String.valueOf(x));
				System.out.println("\nOrder ["+z+"]");z++;
				drinkMenu.ShowSelectionMenu("Drink","");
				calculator[1][x]=drinkMenu.Calculator();
				x++;}else{x=0;break;}}
		while (true){
			File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x));
			if(file.exists()){
				setfoodMenu.InputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu", Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetFoodOrder");
				setdrinkMenu.InputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu", Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetDrinkOrder");
				RemoveMenu.put(z, "SetMenuOrder"+String.valueOf(x));
				System.out.println("\nOrder ["+z+"]");z++;
				setfoodMenu.ShowSelectionMenu(" Set ","");
				setdrinkMenu.ShowSelectionMenu("Drink","");
				calculator[2][x]=setfoodMenu.Calculator()+setdrinkMenu.Calculator();
					x++;}else{x=0;break;}}
			for(y=0;x<10;x++){y=y+calculator[0][x]+calculator[1][x]+calculator[2][x];}
		System.out.println("==============================\n\n"
				+ "Total:\t\t$"+y);	
		}

	/**
	 * After choosing their food, this method ask customers to decide whether they want to continue, cancel or pay
	 * @param shopID
	 * @param Order
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private boolean payORnot(String shopID,String Order) throws ClassNotFoundException, IOException{
		while (quit != true){
		System.out.print("\n[1]continue [2]cancel [3]confirm(pay)\n"
				+ "Select by Entering number:");
		String option=input.nextLine();
		switch (option){
		case "1":quit = true;break;
		case "2":if(Order.equals("FOOD")){File  file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x)+"\\FoodOrder.txt");file.delete();
											    file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x));file.delete();}
			else if(Order.equals("DRINK")){File file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x)+"\\DrinkOrder.txt");file.delete();
												file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x));file.delete();}
			else						  {File file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetFoodMenu.txt");file.delete();
												file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetDrinkMenu.txt");file.delete();
												file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x));file.delete();}
			quit = true;break;
		case "3":System.out.println("Your Order :");
			ReadOrderBill();
			System.out.println("are sent to the restaurantMenu");
			quit = true;break;
		default:System.out.println("Please Try Again... :");}
		}
		return !quit;}

	/**
	 * This method show the procedure of the main flow of customers
	 * And show what method are called in the main flow of customers
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void mainflow() throws ClassNotFoundException, IOException {
		System.out.println("\nWelcome to HereRice !\n"
				+ "Choose a Restaurant below:");
	      selectShop.InputTextFile(OneDrivePath,"", "SelectShop", "");
	      selectShop.ShowRestaurant();  	
	      number = 0;
			while (number == 0) {
				try {
					System.out.print("Select a Restaurant by Entering a number:");
					number = Integer.parseInt(input.nextLine());
				} catch (NumberFormatException ie)
				{
					number = 0;
					System.out.println("Please try again...");
				} 
			}
	      OrderNumber=10000;
	      while (quit != true){
	      	File folder=new File (OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber));
	      	while (selectShop.ReadStringStringHashMapSelectionID(number)=="true") {
	      		selectShop.ShowRestaurant();  	
	  	      number = 0;
	  			while (number == 0) {
	  				try {
	  					System.out.print("Select a Restaurant by Entering a number:");
	  					number = Integer.parseInt(input.nextLine());
	  				} catch (NumberFormatException ie)
	  				{
	  					number = 0;
	  					System.out.println("Please try again...");
	  				} 
	  			}
	      	}
	      	if(!folder.exists()){new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)).mkdir();
	      	quit=true;}else{OrderNumber++;}};
	      	foodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","FoodMenu");
			drinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","DrinkMenu");
			setfoodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","FoodSetMenu");
			setdrinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","DrinkSetMenu");
			shopInfo.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "ShopInfo"," ");
			quit = false;
			System.out.print("\n>>> Entering "+selectShop.ReadStringStringHashMapSelectionNAME(number)+"...");
			while (quit != true){ 
				shopInfo.ShowShopInformation();
				System.out.print(
					  "[1]Food Menu\n"
					+ "[2]Drink Menu\n"
					+ "[3]Set Menu\n"
					+ "[4]Read Order (included order no.)\n"
					+ "[5]Del Order\n"
					+ "[6]Quit\n"
					+"Select the options by Entering a number:");
			String option=input.nextLine();
			switch (option){
			case "1":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x)+"\\FoodOrder.txt");
				if(file.exists()){x++;}else{break;}}
				foodMenu.SelectRestaurantMenuHelper("Select your food","Food");
				foodMenu.SelectRestaurantMenu("Food");
				foodMenu.ShowSelectionMenu("Food","==============================\n");
				foodMenu.ShowTotal();
				File folder =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x));
				if(!folder.exists()){folder.mkdir();}
				foodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu",Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x)+"\\FoodOrder");
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"FOOD");
				break;
			case "2":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x)+"\\DrinkOrder.txt");
				if(file.exists()){x++;}else{break;}}
				drinkMenu.SelectRestaurantMenuHelper("Select your drink","Drink");
				drinkMenu.SelectRestaurantMenu("Drink");
				drinkMenu.ShowSelectionMenu("Drink","==============================\n");
				drinkMenu.ShowTotal();
				folder =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x));
				if(!folder.exists()){folder.mkdir();}
				drinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu",Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x)+"\\DrinkOrder");
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"DRINK");
				break;
			case "3":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetFoodOrder.txt");
				if(file.exists()){x++;}else{break;}}
				setfoodMenu.SelectRestaurantMenuHelper("Select your Set"," Set ");
				setfoodMenu.SelectRestaurantMenu(" Set ");
				for(String items : setfoodMenu.ReadSelectionMenu().keySet()){
					System.out.println("choose a drink for "+items+".");
					setdrinkMenu.ShowRestaurantMenu("==========Drink Menu=========");
					int Option=Integer.parseInt(input.nextLine());
					setdrinkMenu.ReadSelectReadSetDrinkMenu(setdrinkMenu.ReadSetDrinkMenu()[Option-1],setdrinkMenu.ReadRestaurantMenu().get(setdrinkMenu.ReadSetDrinkMenu()[Option-1]));}
				setfoodMenu.ShowRestaurantMenu("==========Set Menu===========");
				double a = setfoodMenu.Calculator();
				System.out.println("\t\t$"+setfoodMenu.Calculator());
				setdrinkMenu.ShowSelectionMenu("Drink","==============================\n");
				double b = setdrinkMenu.Calculator();
				System.out.println("\t\t$"+setdrinkMenu.Calculator());
				System.out.println("Total:\t\t$"+(a+b));
				folder =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x));
				if(!folder.exists()){folder.mkdir();}
				setfoodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu",Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetFoodOrder");
				setdrinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu",Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetDrinkOrder");
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"SET");
				break;
			case "4":ReadOrderBill();
				System.out.println("\nYour order no. is: " + OrderNumber +" (Please show it when you take your food)\n");
				System.out.print("(press Enter to continue)");
				input.nextLine();
				break;
			case "5":ReadOrderBill();
				z = 0;
				while (z == 0) {
					try {
						System.out.print("Enter the Order number to remove it.");
						z = Integer.parseInt(input.nextLine());
					} catch (NumberFormatException ie)
					{
						z = 0;
						System.out.println("Please try again...");
					}
				}
						   File remove = new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\"+RemoveMenu.get(z)+"\\SetFoodOrder.txt");remove.delete();
						   		remove = new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\"+RemoveMenu.get(z)+"\\SetDrinkOrder.txt");remove.delete();
						   		remove = new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\"+RemoveMenu.get(z)+"\\FoodOrder.txt");remove.delete();
						   		remove = new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\"+RemoveMenu.get(z)+"\\DrinkOrder.txt");remove.delete();
						   		remove = new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order\\"+Integer.toString(OrderNumber)+"\\"+RemoveMenu.get(z));remove.delete();
				break;
			case "6":quit = true;
				break;
			default:System.out.println("Please Try Again... :");
			}

	}
}
}

