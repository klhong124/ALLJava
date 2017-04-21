package ALLJava;

import java.io.File;
import java.io.IOException;

public class ShopOwnerMainFlow extends PreOrder{
	
	public void mainflow() throws IOException, ClassNotFoundException{
	    System.out.println("Select by entering the number,\n"
	    		+ "[1]Login\t[2]Sign up\t[3]Exit");
	    int LoginSignUp=Integer.parseInt(input.nextLine());
	    switch(LoginSignUp){
	    case  1 :
	    	while(true){
			System.out.print("Enter a ShopID.");
		  	  ShopID=input.nextLine();
		  	  File folder=new File(OneDrivePath+"\\"+ShopID);
				  if(!folder.exists()&&!folder.isDirectory()){System.out.println("Try again, ShopID doesn't exist");}
				  else{break;}}
	    	Login("welcome back, "+ShopID);
	    	break;
	    case  2 :SignUp();
	    	break;  
	    case  3 :
	    	break;
	    }
	}

	public void Login(String welcome) throws IOException, ClassNotFoundException{
		foodMenu.InputTextFile(OneDrivePath,ShopID,"RestaurantMenu","FoodMenu");
		drinkMenu.InputTextFile(OneDrivePath,ShopID,"RestaurantMenu","DrinkMenu");
		setMenu.InputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu","FoodSetMenu");
		setMenu.InputTextFile(OneDrivePath, ShopID, "RestaurantMenu","DrinkSetMenu");
		shopInfo.InputTextFile(OneDrivePath, ShopID, "ShopInfo"," ");
		boolean quit = false;
		 System.out.println(welcome);
		 while (quit != true){
			 System.out.print("[1]Edit Food Menu\n"
			 				+ "[2]Edit Drink Menu\n"
			 				+ "[3]Edit Set Menu\n"
			 				+ "[4]Edit Shop Information\n"
			 				+ "[5]Exit\n"
			 				+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :LoginSwitchFood();
			 break;
		 case 2 :LoginSwitchDrink();
			 break;
		 case 3 :LoginSwitchSet();
			 break;
		 case 4:shopInfo.ShowShopInformation();
		 		shopInfo.EditShopInformation();
		 		System.out.println("Updated :");
		 		shopInfo.ShowShopInformation();
		 		shopInfo.OutputTextFile(OneDrivePath, ShopID, "ShopInfo", null);
			 break;
		 case 5 :quit = true;
			 break;
		  }
		 }
		}
	private void LoginSwitchSet() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("[EDIT MODE]-Set Menu\n"
					 		+ "[1]Create Set Menu(s)\n"
					 		+ "[2]Remove Set\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Exit\n"
					 		+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :
			 	 foodMenu.SelectRestaurantMenuHelper("Select the food to create a set with drink","Food");
		 		 foodMenu.SelectRestaurantMenu("Food");
				 setMenu.CreateSetMenu(foodMenu.ReadSelectionMenu(),drinkMenu.ReadRestaurantMenu());
				 setMenu.OutputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu", "FoodSetMenu");
				 setMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkSetMenu");
			 break;
		 case 2 :setMenu.RemoveRestaurantSetMenu();
		 		 setMenu.OutputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu", "FoodSetMenu");
			 break;
		 case 3 :setMenu.ShowSubRestaurantMenu("---   Set Menu   ---");
		 		 setMenu.ShowRestaurantMenu("---   Drink Menu   ---");
			 break;
		 case 4 : quit = true;
			 break;
			 }
		 }
	}
	private void LoginSwitchFood() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("[EDIT MODE]- FoodMenu\n"
					 		+ "[1]Add item(s)\n"
					 		+ "[2]Remove item\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Exit\n"
					 		+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :foodMenu.AddRestaurantMenu("Food");
		 		 foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu","FoodMenu");
			 break;
		 case 2 :foodMenu.RemoveRestaurantMenu("Food");
		 		 foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodMenu");
			 break;
		 case 3 :foodMenu.ShowRestaurantMenu("---   Food Menu   ---");
			 break;
		 case 4 : quit = true;
			 break;
			 }
		 }
	}
	private void LoginSwitchDrink() throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("[EDIT MODE]- FoodMenu\n"
					 		+ "[1]Add item(s)\n"
					 		+ "[2]Remove item\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Create Cold Drink\n"
					 		+ "[5]Exit\n"
					 		+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :drinkMenu.AddRestaurantMenu("Food");
		 		 drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu","DrinkMenu");
			 break;
		 case 2 :drinkMenu.RemoveRestaurantMenu("Drink");
		 		 drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkMenu");
			 break;
		 case 3 :drinkMenu.ShowRestaurantMenu("---   Drink Menu   ---");
			 break;
		 case 4 :drinkMenu.CreateColdDrinkMenu();
			 break;
		 case 5 : quit = true;
			 break;
			 }
		 }
	}
	
	public void SignUp() throws IOException, ClassNotFoundException{
  	  while(true){
		  System.out.print("Enter a ShopID.");
    	  ShopID=input.nextLine();
    	  File folder=new File(OneDrivePath+"\\"+ShopID);
		  if(!folder.exists()&&!folder.isDirectory()){new File(OneDrivePath+"\\"+ShopID).mkdir();break;}
		  else{System.out.print("This ShopID is already used.\n"
		  		+ "please try again,");}}
	  System.out.println("Welcome,"+ShopID+".\n"
	  		+ "HereRice can makes you and your restaurant become famous.\n"
	  		+ "Customers are able to order your food and pay on HereRice.\n"
	  		+ "To start with, Please enter some information of your shop below.");
	  shopInfo.EditShopInformation();
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
	  setMenu.CreateSetMenu(foodMenu.ReadSelectionMenu(),drinkMenu.ReadRestaurantMenu());
	  setMenu.OutputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu", "FoodSetMenu");
	  setMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkSetMenu");
	  System.out.println("Well done!!\n"
	  		+ "your food Menu , Drink Menu and Set were created successfully.");
	  Login("you are now entering to our setting page...");
	}
}
