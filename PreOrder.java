package ALLJava;
import java.util.Scanner;
import java.io.IOException;

public class PreOrder {
	static RestaurantMenu foodMenu 	   = new RestaurantMenu();
	static RestaurantMenu drinkMenu    = new RestaurantMenu();
	static RestaurantMenu setfoodMenu  = new RestaurantMenu();
	static RestaurantMenu setdrinkMenu = new RestaurantMenu();
	static RestaurantMenu shopInfo	   = new RestaurantMenu();
	static RestaurantMenu selectShop   = new RestaurantMenu();
	static ShopOwnerMainFlow shopOwnerMainFlow = new ShopOwnerMainFlow();
	static CustomerMainFlow customerMainFlow = new CustomerMainFlow();
	public static Scanner input;
	public static String ShopID;
	public static String ShopName;
	public static String OneDrivePath;
  public static void main(String[] args) throws IOException, ClassNotFoundException {
	    input = new Scanner(System.in);
	    System.out.println("Welcome to HereRice.\n"
	    		+ "Enter OneDrivePath To get Started");
	    OneDrivePath=input.nextLine();
	    while (true){
	    System.out.println("[1]Customer\t[2]ShopOwner");
	    String customerORshopowner=input.nextLine();
	    switch (customerORshopowner){
	    case "1":
	    	customerMainFlow.mainflow();
	    	break;
	    case "2":
	    	shopOwnerMainFlow.mainflow();
	    	break;
	    default :
	    	System.out.println("Try Again...");
	    	break;
	    }
	 }
  }
}
