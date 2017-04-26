package ALLJava;

import java.io.File;
import java.io.IOException;

public class CustomerMainFlow extends PreOrder{  
	int number;
	boolean quit = false;
	public boolean payORnot(String shopID,String Menu,String SetDrinkOrder){
		while (quit != true){
		System.out.print("\n[1]continue [2]cancel [3]confirm(pay)\n"
				+ "Select by Entering number:");
		String option=input.nextLine();
		switch (option){
		case "1":quit = true;break;
		case "2":File file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Menu+".txt");
			file.delete();
			if(!SetDrinkOrder.equals("NO")){file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+SetDrinkOrder+".txt");
			file.delete();}
			quit = true;break;
		case "3":System.out.println("Your Order are sent to the restaurantMenu");quit = true;break;
		default:System.out.println("Please Try Again... :");}
		}
		return !quit;}
	public void mainflow() throws ClassNotFoundException, IOException{
		foodMenu.CLEAR();
		drinkMenu.CLEAR();
		setfoodMenu.CLEAR();
		setdrinkMenu.CLEAR();
		shopInfo.CLEAR();
		selectShop.CLEAR();
		System.out.println("\nWelcome to HereRice !\n"
				+ "Choose a Restaurant below:");
	      selectShop.InputTextFile(OneDrivePath,"", "SelectShop", "");
	      selectShop.ShowRestaurant();
	      System.out.print("Select a Restaurant by Entering a number:");
	      number=Integer.parseInt(input.nextLine());
			foodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","FoodMenu");
			drinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","DrinkMenu");
			setfoodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","FoodSetMenu");
			setdrinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","DrinkSetMenu");
			shopInfo.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "ShopInfo"," ");
			quit = false;
			while (quit != true){ 
				shopInfo.ShowShopInformation();
			System.out.print("<<<<<<<<<<< "+selectShop.ReadStringStringHashMapSelectionNAME(number)+" >>>>>>>>>>>\n"
					+ "[1]Food Menu\n"
					+ "[2]Drink Menu\n"
					+ "[3]Set Menu\n"
					+ "[4]Read OrderBill"
					+ "[5]Quit\n"
					+"Select the options by Entering a number:");
			String option=input.nextLine();
			int x;
			switch (option){
			case "1":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order"+"\\FoodOrder"+String.valueOf(x)+".txt");
				if(file.exists()){x++;}else{break;}}
				foodMenu.SelectRestaurantMenuHelper("Select your food","Food");
				foodMenu.SelectRestaurantMenu("Food");
				foodMenu.ShowSelectionMenu("Food");
				foodMenu.ShowTotal();
				foodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","FoodOrder"+String.valueOf(x));
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"FoodOrder"+String.valueOf(x),"NO");
				break;
			case "2":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order"+"\\DrinkOrder"+String.valueOf(x)+".txt");
				if(file.exists()){x++;}else{break;}}
				drinkMenu.SelectRestaurantMenuHelper("Select your drink","Drink");
				drinkMenu.SelectRestaurantMenu("Drink");
				drinkMenu.ShowSelectionMenu("Drink");
				drinkMenu.ShowTotal();
				drinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","DrinkOrder"+String.valueOf(x));
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"DrinkOrder"+String.valueOf(x),"NO");
				break;
			case "3":x=0;
				while (true){
				File file =new File(OneDrivePath+"\\"+selectShop.ReadStringStringHashMapSelectionID(number)+"\\Order"+"\\SetFoodOrder"+String.valueOf(x)+".txt");
				if(file.exists()){x++;}else{break;}}
				setfoodMenu.SelectRestaurantMenuHelper("Select your Set","Set");
				setfoodMenu.SelectRestaurantMenu("Set");
				for(String items : setfoodMenu.ReadSelectionMenu().keySet()){
					System.out.println("choose a drink for "+items+".");
					setdrinkMenu.ShowRestaurantMenu("----      DrinkMenu      ----");
					int Option=Integer.parseInt(input.nextLine());
					setdrinkMenu.ReadSelectReadSetDrinkMenu(setdrinkMenu.ReadSetDrinkMenu()[Option-1],setdrinkMenu.ReadRestaurantMenu().get(setdrinkMenu.ReadSetDrinkMenu()[Option-1]));}
				setfoodMenu.ShowRestaurantMenu("---       SetMenu       ---");
				double a = setfoodMenu.Calculator();
				System.out.println("\t\t\t$"+setfoodMenu.Calculator());
				setdrinkMenu.ShowSelectionMenu("Drink");
				double b = setdrinkMenu.Calculator();
				System.out.println("\t\t\t$"+setdrinkMenu.Calculator());
				System.out.println("Total:\t\t$"+(a+b));
				setfoodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","SetFoodOrder"+String.valueOf(x));
				setdrinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","SetDrinkOrder"+String.valueOf(x));
				quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"SetFoodOrder"+String.valueOf(x),"SetDrinkOrder"+String.valueOf(x));
					break;
			case "4":break;
			case "5":quit = true;
				break;
			default:System.out.println("Please Try Again... :");
			}

	}
}
}

