package ALLJava;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapRestaurantMenu {
	private Scanner input;
	private String type;
	private int number = 1;
	HashMap<String,Double> RestaurantMenu 	  = new HashMap<String,Double>();
	HashMap<String,Double> SaveRestaurantMenu = new HashMap<String,Double>();
	
	public void CreateColdDrinkMenu(){
		System.out.println("Enter the extra-payment for Cold Drink.");
		double extrapayment = Double.parseDouble(input.nextLine());
		for (String items : RestaurantMenu.keySet()) {
			String item = items+" (Cold)";
			double price = RestaurantMenu.get(items)+extrapayment;
			SaveRestaurantMenu.put(item,price);};
		for (String items : SaveRestaurantMenu.keySet()) {
			String item = items;
			double price = SaveRestaurantMenu.get(items);
			RestaurantMenu.put(item,price);}
		SaveRestaurantMenu.keySet().clear();}
				
	public String[] ReadOrderItem(){
		String[] OrderItem  = new String [RestaurantMenu.size()];
		int item = 0;
		for(String items : RestaurantMenu.keySet()){
			OrderItem[item] = items;item++;};
		return OrderItem;}
	
	public Double[] ReadOrderPrice(){
		Double[] OrderPrice = new Double[RestaurantMenu.size()];
		int item = 0;
		for(String items : RestaurantMenu.keySet()){
			OrderPrice[item] = RestaurantMenu.get(items);item++;};
		return OrderPrice;}
	
	public void RemoveRestaurantMenu(){
		input = new Scanner(System.in);
		System.out.println("You're now able to remove any unwanted item on "+type+" menu.\n"+
				           "Enter the item number to Delete:");
		System.out.println("---   " +type+" Menu\t   ---");
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------");
		int OrderNumber = Integer.parseInt(input.nextLine())-1;
		String[] OrderItem = RestaurantMenu.keySet().toArray(new String[RestaurantMenu.size()]);
		RestaurantMenu.remove(OrderItem[OrderNumber]);}
	
	//public void SelectRestaurantMenu(){
	
	public void ShowRestaurantMenu(){
	    System.out.println("---   " +type+" Menu\t   ---");
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------");};
	    
	public void EditRestaurantMenu(String typename) {
		type=typename;
		input = new Scanner(System.in);
		System.out.println
		("You're now editing the list of "+type+" menu.\n"+
		 "Enter the NUMBER of item wanted to add:");
		int NumberOfItemToAdd = Integer.parseInt(input.nextLine());
		for(int looptimes = 1; looptimes<NumberOfItemToAdd;looptimes++){
		System.out.println("What kind of "+type+" would you like you put on the menu?:");
		String item = input.nextLine();
		System.out.println("How much does *"+item+"* cost?");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    System.out.println("-----   Preview\t -----");
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("-----     End  \t -----");}
		System.out.println("What kind of "+type+" would you like you put on the menu?:");
		String item = input.nextLine();
		System.out.println("How much does *"+item+"* cost?");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");}

}


