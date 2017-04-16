package ALLJava;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PreOrder {
	static HashMapRestaurantMenu foodMenu   = new HashMapRestaurantMenu();
	static HashMapRestaurantMenu drinkMenu  = new HashMapRestaurantMenu();
	static HashMapRestaurantMenu setMenu    = new HashMapRestaurantMenu();
	private static Scanner input;
  public static void main(String[] args) throws IOException {
	    input = new Scanner(System.in);
	    System.out.println("Welcome to HereRice.\n"
	    		+ "Enter OneDrivePath To get Started");
	    String OneDrivePath=input.nextLine();
	    System.out.println("If you want to edit your RestaurantMenu,\n"
	    		+ "Enter your ShopID to login.\n"
	    		+ "otherwise, Enter \"i am new\" to sign up.");
	    String LoginSignUp=input.nextLine();
	    if(LoginSignUp.equals("i am new")){
	    	  System.out.print("Enter a ShopID.");
	    	  String ShopID=input.nextLine();
	    	  File folder=new File(OneDrivePath+ShopID);
	    	  while(true){
	    	  if(!folder.exists()){new File(OneDrivePath+"\\"+ShopID).mkdir();break;}
	    	  else{System.out.print("This ShopID is already used.");}}
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
		
  
	    }}}
