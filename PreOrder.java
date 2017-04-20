package ALLJava;
import java.util.Scanner;
import java.io.IOException;

public class PreOrder {
	static ShopOwner foodMenu  = new ShopOwner();
	static ShopOwner drinkMenu = new ShopOwner();
	static ShopOwner setMenu   = new ShopOwner();
	static ShopOwner shopInfo  = new ShopOwner();
	static ShopOwnerMainFlow shopOwnerMainFlow = new ShopOwnerMainFlow();
	public static Scanner input;
	public static String ShopID;
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
	    	break;
	    case "2":
	    	shopOwnerMainFlow.mainflow();
	    	break;
	    }
	 }
  }
}
