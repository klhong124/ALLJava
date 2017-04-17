package ALLJava;

import java.io.File;
import java.io.IOException;

public class ShopOwnerMainFlow extends PreOrder{
	public void mainflow() throws IOException{
	    System.out.println("Select by entering the number,\n"
	    		+ "[1]Login\t[2]Sign up");
	    String LoginSignUp=input.nextLine();
	    switch(LoginSignUp){
	    case "1":Login();
	    	break;
	    case "2":SignUp();
	    	break;  
	    }
	}
	public void Login() throws IOException{
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
	  		+ "HereRice is an API that makes you and your restaurant famous.\n"
	  		+ "Customers are able to order your food through HereRice."
	  		+ "To start with, Let's create a food Menu.\n"
	  		+ "You can edit your menu later on. ARE YOU READY??\n"
	  		+ "plase Enter to continue");
	  input.nextLine();
	  foodMenu.AddRestaurantMenu("Food");
	  foodMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "FoodMenu");
	  System.out.println("Congratulation!!\n"
	  		+ "you have been created a Food Menu\n"
	  		+ "Let's create a Drink Menu\n"
	  		+ "plase Enter to continue");
	  input.nextLine();
	  drinkMenu.AddRestaurantMenu("Drink");	
	  drinkMenu.OutputTextFile(OneDrivePath, ShopID, "RestaurantMenu", "DrinkMenu");
	  System.out.println("Congratulation!!\n"
    	  		+ "you have been created a Drink Menu\n"
    	  		+ "Now, you can combine your Food Menu and ");
	  setMenu.CreateSetMenu(foodMenu.ReadRestaurantMenu(), drinkMenu.ReadRestaurantMenu());
	}
}
