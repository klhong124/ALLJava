package ALLJava;

import java.io.File;
import java.io.IOException;

public class ShopOwnerMainFlow extends PreOrder{
	
	public void mainflow() throws IOException{
	    System.out.println("Select by entering the number,\n"
	    		+ "[1]Login\t[2]Sign up\t[3]Exit");
	    int LoginSignUp=Integer.parseInt(input.nextLine());
	    switch(LoginSignUp){
	    case  1 :Login("welcome back, "+ShopID);
	    	break;
	    case  2 :SignUp();
	    	break;  
	    case  3 :
	    	break;
	    }
	}
	public void Login(String welcome) throws IOException{
	  	  while(true){
		System.out.print("Enter a ShopID.");
  	  ShopID=input.nextLine();
  	  File folder=new File(OneDrivePath+"\\"+ShopID);
		  if(!folder.exists()&&!folder.isDirectory()){System.out.println("Try again, ShopID doesn't exist");}
		  else{break;}}
		foodMenu.InputTextFile(OneDrivePath,ShopID,"RestaurantMenu","FoodMenu");
		boolean quit = false;
		 System.out.println(welcome);
		 while (quit != true){
			 System.out.print("[1]Edit Food Menu\n"
			 				+ "[2]Edit Drink Menu\n"
			 				+ "[3]Edit Set Menu\n"
			 				+ "[4]Exit\n"
			 				+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :LoginSwitch(foodMenu,"FoodMenu");
			 break;
		 case 2 :LoginSwitch(drinkMenu,"DrinkMenu");
			 break;
		 case 3 :LoginSwitchSet();
			 break;
		 case 4 :quit = true;
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
		 case 1 :foodMenu.SelectRestaurantMenuHelper("Select the food to create a set with drink");
		 		 foodMenu.SelectRestaurantMenu();
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
	private void LoginSwitch(Object Menu,String type) throws IOException{
		boolean quit = false;
		 while (quit != true){
			 System.out.print("[EDIT MODE]-"+type+"\n"
					 		+ "[1]Add item(s)\n"
					 		+ "[2]Remove item\n"
					 		+ "[3]Read Menu\n"
					 		+ "[4]Exit\n"
					 		+ "Enter a number:");
		 int option=Integer.parseInt(input.nextLine());
		 switch (option){
		 case 1 :((ShopOwner) Menu).AddRestaurantMenu(type);
		 		 ((ShopOwner) Menu).OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", type);
			 break;
		 case 2 :((ShopOwner) Menu).RemoveRestaurantMenu();
		 		 ((ShopOwner) Menu).OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", type);
			 break;
		 case 3 :((ShopOwner) Menu).ShowRestaurantMenu("---   " +type+" Menu   ---");
			 break;
		 case 4 : quit = true;
			 break;
			 }
		 }
	}
	public void SignUp() throws IOException{
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
	  shopInfo.ShopInformation();
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
	  foodMenu.SelectRestaurantMenuHelper("Select the food to create a set with drink");
	  foodMenu.SelectRestaurantMenu();
	  setMenu.CreateSetMenu(foodMenu.ReadSelectionMenu(),drinkMenu.ReadRestaurantMenu());
	  setMenu.OutputTextFile(OneDrivePath, ShopID, "SubRestaurantMenu", "FoodSetMenu");
	  setMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkSetMenu");
	  System.out.println("Well done!!\n"
	  		+ "your food Menu , Drink Menu and Set were created successfully.");
	  Login("you are now entering to our setting page...");
	}
}
