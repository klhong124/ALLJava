package ALLJava;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapRestaurantMenu {
	private Scanner input;
	private String type;
	private int number = 1;
	HashMap<String,Double> RestaurantMenu 	  = new HashMap<String,Double>();
	HashMap<String,String> SaveRestaurantMenu = new HashMap<String,String>();
	
	public void CreateColdDrinkMenu(){
		SaveRestaurantMenu.keySet().clear();
		System.out.println("Enter the extra-payment for Cold Drink.");
		double extrapayment = Double.parseDouble(input.nextLine());
		for (String items : RestaurantMenu.keySet()) {
			String item = items+" (Cold)";
			String price = String.valueOf(RestaurantMenu.get(items)+extrapayment);
			SaveRestaurantMenu.put(item,price);};
		for (String items : SaveRestaurantMenu.keySet()) {
			String item = items;
			double price = Double.parseDouble(SaveRestaurantMenu.get(items));
			RestaurantMenu.put(item,price);}}
				
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
	
	public void SelectRestaurantMenuHelper(){
		String[] OrderItem  = new String [RestaurantMenu.size()];int item = 0;for(String items : RestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		Double[] OrderPrice = new Double[RestaurantMenu.size()];item = 0;for(String items : RestaurantMenu.keySet()){OrderPrice[item] = RestaurantMenu.get(items);item++;}
		for(int looptimes = 0;looptimes<OrderItem.length;looptimes++){
			String items = OrderItem[looptimes];
			String price = String.valueOf(OrderPrice[looptimes]);
			SaveRestaurantMenu.put(items,price);}}
	public void SelectRestaurantMenu(String NumberDoneAll){
		String[] OrderItem  = new String [SaveRestaurantMenu.size()];int item = 0;for(String items : SaveRestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		String[] OrderPrice = new String[SaveRestaurantMenu.size()];item = 0;for(String items : SaveRestaurantMenu.keySet()){OrderPrice[item] = SaveRestaurantMenu.get(items);item++;}
		SaveRestaurantMenu.clear();
		if (NumberDoneAll.equals("all")){
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t\t$"+RestaurantMenu.get(items)+"[Selected]");number++;};
	    	number = 1 ;
	    System.out.println("----------------------");}
	    else{
			for(int looptimes = 0;looptimes< Integer.valueOf(NumberDoneAll)-1;looptimes++){
				String items = OrderItem[looptimes];
				String price = OrderPrice[looptimes];
				SaveRestaurantMenu.put(items,price);}
			String items = OrderItem [Integer.valueOf(NumberDoneAll)-1];
			String price = OrderPrice[Integer.valueOf(NumberDoneAll)-1]+"[Selected]";
			SaveRestaurantMenu.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
			SaveRestaurantMenu.put(items,price);
			for(int looptimes = Integer.valueOf(NumberDoneAll);looptimes<OrderItem.length ;looptimes++){
				items = OrderItem[looptimes];
				price = OrderPrice[looptimes];
				SaveRestaurantMenu.put(items,price);}
			}
	    System.out.println("---   " +type+" Menu   ---");
	    for (String items : SaveRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t\t$"+SaveRestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------");
			}
	
	public void ShowRestaurantMenu(){
	    System.out.println("---   " +type+" Menu   ---");
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t\t$"+RestaurantMenu.get(items));number++;};
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
	    	System.out.println(number+") "+items+"\t\t$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("-----     End  \t -----");}
		System.out.println("What kind of "+type+" would you like you put on the menu?:");
		String item = input.nextLine();
		System.out.println("How much does *"+item+"* cost?");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");}

}


