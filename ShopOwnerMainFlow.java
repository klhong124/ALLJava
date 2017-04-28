/**
 * Show the main flow of restaurant owners
 * @author ALL Boys Project Team
 * @version 1.0
 */
package ALLJava;

import java.io.File;
import java.io.IOException;

public class ShopOwnerMainFlow extends PreOrder{
	boolean quit = false;
	int x;double y;int z;
	
	/**
	 * This method show the procedure of the main flow of restaurant owners
	 * And show what method are called in the main flow of restaurant owners
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void mainflow() throws IOException, ClassNotFoundException{
		while (quit != true){
	    System.out.print("\n[1]Login\t[2]Sign up\t[3]Exit\n"
	    		+ "Select by Entering number:");
	    String LoginSignUp=input.nextLine();
	    switch(LoginSignUp){
	    case "1" :
	    	while(true){
			System.out.print("Enter a ShopID.");
		  	  ShopID=input.nextLine();
		  	  File folder=new File(OneDrivePath+"\\"+ShopID);
				  if(!folder.exists()&&!folder.isDirectory()){System.out.println("Try again, ShopID doesn't exist");}
				  else{break;}}
	    	Login("welcome back, "+ShopID);
	    	quit = true;break;
	    case  "2" :SignUp();
	    quit = true;break;
	    case  "3" :
	    	quit = true;break;
	    default:System.out.println("Please Try Again... :");}
	    }
	}

	/**
	 * This is the method for restaurant owners who have already signed up a restaurant
	 * This method prompt restaurant owners to do action for their account in HereRice
	 * They can edit menu, edit shop information and start operating their business
	 * @param welcome
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void Login(String welcome) throws IOException, ClassNotFoundException{
		foodMenu.InputTextFile(OneDrivePath,ShopID,"RestaurantMenu","FoodMenu");
		drinkMenu.InputTextFile(OneDrivePath,ShopID,"RestaurantMenu","DrinkMenu");
		setfoodMenu.InputTextFile(OneDrivePath, ShopID, "RestaurantMenu","FoodSetMenu");
		setdrinkMenu.InputTextFile(OneDrivePath, ShopID, "RestaurantMenu","DrinkSetMenu");
		shopInfo.InputTextFile(OneDrivePath, ShopID, "ShopInfo"," ");
		boolean quit = false;
		 System.out.println(welcome);
		 while (quit != true){
			 System.out.print("\n[1]Edit Food Menu\n"
			 				+ "[2]Edit Drink Menu\n"
			 				+ "[3]Edit Set Menu\n"
			 				+ "[4]Edit Shop Information\n"
			 				+ "[5]Operate my business\n"
			 				+ "[6]LogOut\n"
			 				+ "Select by Entering a number:");
		 String option=input.nextLine();
		 switch (option){
		 case "1" :LoginSwitchFood();
			 break;
		 case "2" :LoginSwitchDrink();
			 break;
		 case "3" :LoginSwitchSet();
			 break;
		 case "4":shopInfo.ShowShopInformation();
		 		shopInfo.EditStringStringHashMap("info","OneDrivePath","","");
		 		System.out.println("Updated :");
		 		shopInfo.ShowShopInformation();
		 		shopInfo.OutputTextFile(OneDrivePath, ShopID, "ShopInfo", null);
			 break;
		 case "5" :try {while(true){
			 	Operating();
			    Thread.sleep(5000);}
		 } catch (InterruptedException ie)
		 {System.out.println("Scanning...");}
		 	 break;
		 case "6" :quit = true; System.out.println("You have been LogOut.");
			 break;
		 default:System.out.println("Please Try Again... :");
		  }
		 }
		}

	private void LoginSwitchSet() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("\n[EDIT MODE]-Set Menu\n"
					 		+ "[1]Create Set Menu(s)\n"
					 		+ "[2]Remove Set\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Exit\n"
					 		+ "Select by Entering a number:");
		 String option=input.nextLine();
		 switch (option){
		 case "1" :
			 	 foodMenu.SelectRestaurantMenuHelper("Select the food to create a set with drink","Food");
		 		 foodMenu.SelectRestaurantMenu("Food");
				 setfoodMenu.CreateSetFoodMenu(foodMenu.ReadSelectionMenu());
				 setdrinkMenu.CreateSetDrinkMenu(drinkMenu.ReadSelectionMenu());
				 setfoodMenu.ShowRestaurantMenu("==========Set Menu===========");
				 setdrinkMenu.ShowRestaurantMenu("==========Drink Menu=========");
				 setfoodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodSetMenu");
				 setdrinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkSetMenu");
			 break;
		 case "2" :setfoodMenu.RemoveRestaurantMenu("Set");
		 		 setfoodMenu.OutputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu", "FoodSetMenu");
			 break;
		 case "3" :setfoodMenu.ShowRestaurantMenu("==========Set Menu===========");
		 		 setdrinkMenu.ShowRestaurantMenu("==========Drink Menu=========");
			 break;
		 case "4" : quit = true;
			 break;
		 default:System.out.println("Please Try Again... :");
			 }
		 }
	}
	private void LoginSwitchFood() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("\n[EDIT MODE]- FoodMenu\n"
					 		+ "[1]Add item(s)\n"
					 		+ "[2]Remove item\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Exit\n"
					 		+ "Select by Entering a number:");
		 String option=input.nextLine();
		 switch (option){
		 case "1" :foodMenu.AddRestaurantMenu("Food");
		 		 foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu","FoodMenu");
			 break;
		 case "2" :foodMenu.RemoveRestaurantMenu("Food");
		 		 foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodMenu");
			 break;
		 case "3" :foodMenu.ShowRestaurantMenu("==========Food Menu==========");
			 break;
		 case "4" : quit = true;
			 break;
		 default:System.out.println("Please Try Again... :");
			 }
		 }
	}
	private void LoginSwitchDrink() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("\n[EDIT MODE]- DrinkMenu\n"
					 		+ "[1]Add item(s)\n"
					 		+ "[2]Remove item\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Create Cold Drink\n"
					 		+ "[5]Exit\n"
					 		+ "Select by Entering a number:");
		 String option=input.nextLine();
		 switch (option){
		 case "1" :drinkMenu.AddRestaurantMenu("Food");
		 		 drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu","DrinkMenu");
			 break;
		 case "2" :drinkMenu.RemoveRestaurantMenu("Drink");
		 		 drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkMenu");
			 break;
		 case "3" :drinkMenu.ShowRestaurantMenu("==========Drink Menu=========");
			 break;
		 case "4" :drinkMenu.CreateColdDrinkMenu();
			 break;
		 case "5" : quit = true;
			 break;
		 default:System.out.println("Please Try Again... :");
			 }
		 }
	}
	
	private void Operating() throws ClassNotFoundException, IOException{
		OrderNumber=10000;
		quit = false;
	      while (quit != true){
	      	File folder=new File (OneDrivePath+"\\"+ShopID+"\\Order\\"+Integer.toString(OrderNumber));
	      	if(folder.exists()){OrderNumber++;}else{OrderNumber=OrderNumber-1;quit=true;}};
		System.out.println("\nHere is your Order:");
		x=0;y=0;z=1;double[][] calculator={{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		
		while (true){
			File file =new File(OneDrivePath+"\\"+ShopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x));
			if(file.exists()){
				foodMenu.InputTextFile(OneDrivePath, ShopID, "SelectionMenu", Integer.toString(OrderNumber)+"\\FoodMenuOrder"+String.valueOf(x)+"\\FoodOrder");
				System.out.println("Order ["+z+"]");z++;
				foodMenu.ShowSelectionMenu("Food","");
				calculator[0][x]=foodMenu.Calculator();
				x++;}else{x=0;break;}}
		while (true){
			File file =new File(OneDrivePath+"\\"+ShopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x));
			if(file.exists()){
				drinkMenu.InputTextFile(OneDrivePath, ShopID, "SelectionMenu", Integer.toString(OrderNumber)+"\\DrinkMenuOrder"+String.valueOf(x)+"\\DrinkOrder");
				System.out.println("\nOrder ["+z+"]");z++;
				drinkMenu.ShowSelectionMenu("Drink","");
				calculator[1][x]=drinkMenu.Calculator();
				x++;}else{x=0;break;}}
		while (true){
			File file =new File(OneDrivePath+"\\"+ShopID+"\\Order\\"+Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x));
			if(file.exists()){
				setfoodMenu.InputTextFile(OneDrivePath, ShopID, "SelectionMenu", Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetFoodOrder");
				setdrinkMenu.InputTextFile(OneDrivePath, ShopID, "SelectionMenu", Integer.toString(OrderNumber)+"\\SetMenuOrder"+String.valueOf(x)+"\\SetDrinkOrder");
				System.out.println("\nOrder ["+z+"]");z++;
				setfoodMenu.ShowSelectionMenu(" Set ","");
				setdrinkMenu.ShowSelectionMenu("Drink","");
				calculator[2][x]=setfoodMenu.Calculator()+setdrinkMenu.Calculator();
					x++;}else{x=0;break;}}
			for(y=0;x<10;x++){y=y+calculator[0][x]+calculator[1][x]+calculator[2][x];}
		System.out.println("==============================\n\n"
				+ "Total:\t\t$"+y);	
		
		}

	public void SignUp() throws IOException, ClassNotFoundException{
	  selectShop.InputTextFile(OneDrivePath,"", "SelectShop", "");
	  ShopID=selectShop.EditStringStringHashMap("select",OneDrivePath,"","");
	  System.out.println("Welcome,"+ShopID+".\n"
	  		+ "HereRice can makes you and your restaurant become famous.\n"
	  		+ "Customers are able to order your food and pay on HereRice.\n"
	  		+ "To start with, Please enter some information of your shop below.");
	  ShopName=shopInfo.EditStringStringHashMap("info","OneDrivePath","","");
	  selectShop.EditStringStringHashMap("",OneDrivePath,ShopID,ShopName);
	  selectShop.OutputTextFile("",OneDrivePath,"","");
	  shopInfo.OutputTextFile(OneDrivePath, ShopID, "ShopInfo", null);
	  System.out.println("Great! Your Shop Information have been updated.\n"
			+ "It is time to create a food Menu now.\n"
	  		+ "You can edit your menu as long as you login with your ShopID\n"
	  		+ "please remember your ShopID. ARE YOU READY??\n"
	  		+ "press Enter to continue");
	  input.nextLine();
	  foodMenu.AddRestaurantMenu("Food");
	  foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodMenu");
	  System.out.println("Congratulation!!\n"
	  		+ "you have been created a Food Menu\n"
	  		+ "Let's move on the next part - To create a Drink Menu\n"
	  		+ "We will generate an Cold Drink Menu with extra-payment later on\n"
	  		+ "there is no needed to enter a drink twice for cold and hot.\n"
	  		+ "press Enter to continue");
	  input.nextLine();
	  drinkMenu.AddRestaurantMenu("Drink");	
	  drinkMenu.CreateColdDrinkMenu();
	  drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkMenu");
	  System.out.println("Congratulation!!\n"
    	  		+ "you have been created a Drink Menu\n"
    	  		+ "Now, you can combine your Food Menu and Drink as a Set\n"
    	  		+ "At first we default all drinks in a set are free\n"
    	  		+ "you may select some Special drink to add an extra-payment");
	  foodMenu.SelectRestaurantMenuHelper("Select the food to create a set with drink","Food");
	  foodMenu.SelectRestaurantMenu("Food");
	  setfoodMenu.CreateSetFoodMenu(foodMenu.ReadSelectionMenu());
	  setdrinkMenu.CreateSetDrinkMenu(drinkMenu.ReadRestaurantMenu());
	  setfoodMenu.ShowRestaurantMenu("==========Set Menu===========");
	  setdrinkMenu.ShowRestaurantMenu("==========Drink Menu=========");
	  setfoodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodSetMenu");
	  setdrinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkSetMenu");
	  System.out.println("Well done!!\n"
	  		+ "your food Menu , Drink Menu and Set were created successfully.");
	  Login("you are now entering to our setting page...");
	}
}
