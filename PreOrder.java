/**
 * An API which do pre-order
 * <p>Restaurant owners can create menu here for customers to place orders
 * Customers can place orders through this API
 * <p>Main is included in this class
 * @author ALL Boys Project Team
 * @version 1.0
 */
package ALLJava;
import java.util.Scanner;
import java.io.File;
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
	public static int OrderNumber;
	public static String OneDrivePath;
  public static void main(String[] args) throws IOException, ClassNotFoundException {
	    input = new Scanner(System.in);
	    System.out.println("Welcome to HereRice.\n"
	    		+ "Enter OneDrivePath To get Started");
	    while (true) {OneDrivePath=input.nextLine();
	    File file =new File(OneDrivePath+"\\SelectShop.txt");
	    if(file.exists()){
	    	System.out.println("Correct Path !");break;
	    }else{System.out.println("Incorrect Path !\n"
	    		+ "Please Try Again... :");}}
	    boolean quit = false;
	    while (quit != true){
	    System.out.print("\n[1]Customer\t[2]ShopOwner\n"
	    		+ "Select by Entering a number:");
	    String customerORshopowner=input.nextLine();
	    switch (customerORshopowner){
	    case "1":
	    	customerMainFlow.mainflow();
	    	break;
	    case "2":
	    	shopOwnerMainFlow.mainflow();
	    	break;
	    default :
	    	System.out.println("Please Try Again... :");
	    }
	 }
  }
}
