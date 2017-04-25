package ALLJava;

import java.io.File;
import java.io.IOException;

public class CustomerMainFlow extends PreOrder{  
	int number;
	public boolean payORnot(String shopID,String Menu){
		System.out.println("[1]coutune [2]canel [3]pay");
		int option=Integer.parseInt(input.nextLine());
		switch (option){
		case 1:return false;
		case 2:File file = new File(OneDrivePath+"\\"+shopID+"\\Order\\"+Menu+".txt");
			file.delete();
			if(Menu.equals("SetFoodOrder")){file = new File(OneDrivePath+"\\"+shopID+"\\Order\\SetDrinkOrder.txt");
			file.delete();}
			return false;
		default:return true;
		}
	}
	public void mainflow() throws ClassNotFoundException, IOException{
		foodMenu.CLEAR();
		drinkMenu.CLEAR();
		setfoodMenu.CLEAR();
		setdrinkMenu.CLEAR();
		shopInfo.CLEAR();
		selectShop.CLEAR();
	      selectShop.InputTextFile(OneDrivePath,"", "SelectShop", "");
	      selectShop.ShowRestaurant();
	      System.out.print("Select a Restaurant by Entering number:");
	      number=Integer.parseInt(input.nextLine());
			foodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","FoodMenu");
			drinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number),"RestaurantMenu","DrinkMenu");
			setfoodMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","FoodSetMenu");
			setdrinkMenu.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "RestaurantMenu","DrinkSetMenu");
			shopInfo.InputTextFile(OneDrivePath,selectShop.ReadStringStringHashMapSelectionID(number), "ShopInfo"," ");
			boolean quit = false;  
			while (quit != true){ 
			System.out.println("        << "+selectShop.ReadStringStringHashMapSelectionNAME(number)+" >>\n"
					+ "[1]Food Menu\n"
					+ "[2]Drink Menu\n"
					+ "[3]Set Menu\n"
					+ "[4]Quit\n"
					+"Select the options by Entering number:");
			int option=Integer.parseInt(input.nextLine());
			switch (option){
			case 1 :foodMenu.SelectRestaurantMenuHelper("Select your food","Food");
					foodMenu.SelectRestaurantMenu("Food");
					foodMenu.ShowSelectionMenu("Food");
					foodMenu.ShowTotal();
					foodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","FoodOrder");
					quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"FoodOrder");
					break;
			case 2 :drinkMenu.SelectRestaurantMenuHelper("Select your drink","Drink");
					drinkMenu.SelectRestaurantMenu("Drink");
					drinkMenu.ShowSelectionMenu("Drink");
					drinkMenu.ShowTotal();
					drinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","DrinkOrder");
					quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"DrinkOrder");
				break;
			case 3 :setfoodMenu.SelectRestaurantMenuHelper("Select your Set","Set");
					setfoodMenu.SelectRestaurantMenu("Set");
					for(String items : setfoodMenu.ReadSelectionMenu().keySet()){
						System.out.println("choose a drink for "+items+".");
						setdrinkMenu.ShowRestaurantMenu("Drink");
						option=Integer.parseInt(input.nextLine());
						setdrinkMenu.ReadSelectReadSetDrinkMenu(setdrinkMenu.ReadSetDrinkMenu()[option-1],setdrinkMenu.ReadRestaurantMenu().get(setdrinkMenu.ReadSetDrinkMenu()[option-1]));}
					setfoodMenu.ShowRestaurantMenu("---    Set Menu    ---");
					double a = setfoodMenu.Calculator();
					System.out.println("\t\t\t$"+setfoodMenu.Calculator());
					setdrinkMenu.ShowSelectionMenu("Drink");
					double b = setdrinkMenu.Calculator();
					System.out.println("\t\t\t$"+setdrinkMenu.Calculator());
					System.out.println("Total:\t\t$"+(a+b));
					setfoodMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","SetFoodOrder");
					setdrinkMenu.OutputTextFile(OneDrivePath, selectShop.ReadStringStringHashMapSelectionID(number), "SelectionMenu","SetDrinkOrder");
					quit=payORnot(selectShop.ReadStringStringHashMapSelectionID(number),"SetFoodOrder");
						break;
			case 4 :quit = true;
				break;
			}

	}
}
}

