package ALLJava;
import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ShopOwner {
	private Scanner input;
	private String type;
	private int number = 1;
	private String ShopAddress;
	private String ShopNumber;
	HashMap<String,Double> RestaurantMenu 	  = new HashMap<String,Double>();
	HashMap<String,Double> SubRestaurantMenu  = new HashMap<String,Double>();
	HashMap<String,Double> SelectionMenu 	  = new HashMap<String,Double>();
	HashMap<String,String> SaveRestaurantMenu = new HashMap<String,String>();
	
	public void ShopInfoation(){
		System.out.println("Enter your Shop's phone number");
		ShopNumber=input.nextLine();
		System.out.println("Enter your Shop Address");
		ShopAddress=input.nextLine();
	}
	
	public void CreateColdDrinkMenu(){
		SaveRestaurantMenu.keySet().clear();
		System.out.print("Enter the extra-payment for Cold Drink.");
		double extrapayment = Double.parseDouble(input.nextLine());
		for (String items : ReadSelectionMenu().keySet()) {
			String item = items+" (Cold)";
			String price = String.valueOf(ReadSelectionMenu().get(items)+extrapayment);
			SaveRestaurantMenu.put(item,price);};
		for (String items : SaveRestaurantMenu.keySet()) {
			String item = items;
			double price = Double.parseDouble(SaveRestaurantMenu.get(items));
			RestaurantMenu.put(item,price);}
		System.out.println("Your Menu is now be like");
		ShowRestaurantMenu("---   " +type+" Menu   ---");}
		
	public HashMap<String,Double> ReadRestaurantMenu(){
		return RestaurantMenu;}
	public HashMap<String,Double> ReadSubRestaurantMenu(){
		return SubRestaurantMenu;}
	public HashMap<String,Double> ReadSelectionMenu(){
		return SelectionMenu;}
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
	public String ReadShopAddress(){
		return ShopAddress;}
	public String ReadShopNumber(){
		return ShopNumber;}
	
	public void RemoveRestaurantMenu(){
		SelectRestaurantMenuHelper();
		SelectRestaurantMenu("select TO REMOVE ITEM");
		for(String items : ReadSelectionMenu().keySet()){
			RestaurantMenu.remove(items);};
		System.out.println("Your Menu is now be like");
		ShowRestaurantMenu("---   " +type+" Menu   ---");}
	
	public void SelectRestaurantMenuHelper(){
		SelectionMenu.keySet().clear();
		String[] OrderItem  = new String [RestaurantMenu.size()];int item = 0;for(String items : RestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		Double[] OrderPrice = new Double[RestaurantMenu.size()];item = 0;for(String items : RestaurantMenu.keySet()){OrderPrice[item] = RestaurantMenu.get(items);item++;}
		for(int looptimes = 0;looptimes<OrderItem.length;looptimes++){
			String items = OrderItem[looptimes];
			String price = String.valueOf(OrderPrice[looptimes]);
			SaveRestaurantMenu.put(items,price);}
		ShowRestaurantMenu("---   " +type+" Menu   ---");
		}
	public void SelectRestaurantMenu(String Function){
		boolean InputCounter;
		boolean[] InputCounterArray = new boolean [SaveRestaurantMenu.size()]; for(int items=0 ;items<SaveRestaurantMenu.size();items++){InputCounterArray[items] = true;};
		while (true){
		String [] OrderItem  = new String [SaveRestaurantMenu.size()]; int item = 0 ;for(String items : SaveRestaurantMenu.keySet()){OrderItem   [item] = items;item++;};
		String [] OrderPrice = new String [SaveRestaurantMenu.size()];	   item = 0 ;for(String items : SaveRestaurantMenu.keySet()){OrderPrice  [item] = SaveRestaurantMenu.get(items);item++;}
		System.out.println(Function+"\n"+
				   "Enter ...number > select or cancel\n"+
				   "      ...\"all\"  > select all\n"+
				   "      ...\"done\" when you finished");
		String NumberDoneAll = input.nextLine(); 
		SaveRestaurantMenu.clear();
		switch (NumberDoneAll){
		case "done":InputCounter=true;break;
		case "all" :InputCounter=false;break;
		default:InputCounter=InputCounterArray[Integer.valueOf(NumberDoneAll)-1];break;}
		if(InputCounter==true){
		if (NumberDoneAll.equals("done")){break;}
	    else{
			for(int looptimes = 0;looptimes< Integer.valueOf(NumberDoneAll)-1;looptimes++){
				String items = OrderItem[looptimes];
				String price = OrderPrice[looptimes];
				SaveRestaurantMenu.put(items,price);}
			String items = OrderItem [Integer.valueOf(NumberDoneAll)-1];
				String price = OrderPrice[Integer.valueOf(NumberDoneAll)-1]+"[Selected]";
				SelectionMenu.put(OrderItem [Integer.valueOf(NumberDoneAll)-1],RestaurantMenu.get(items));
				SaveRestaurantMenu.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
				SaveRestaurantMenu.put(items,price);
			for(int looptimes = Integer.valueOf(NumberDoneAll);looptimes<OrderItem.length ;looptimes++){
				items = OrderItem[looptimes];
				price = OrderPrice[looptimes];
				SaveRestaurantMenu.put(items,price);}
			InputCounterArray[Integer.valueOf(NumberDoneAll)-1]=!InputCounterArray[Integer.valueOf(NumberDoneAll)-1];}
		ShowSaveRestaurantMenu("---   " +type+" Menu   ---");
	    for (int clearloop = 0; clearloop < OrderItem.length; clearloop++){
	    OrderItem[clearloop]= null;
	    OrderPrice[clearloop]=null;}}
		if(InputCounter==false){
			if (NumberDoneAll.equals("all")){ 
			for(int looptimes = 0;looptimes<OrderItem.length ;looptimes++){
				String items = OrderItem[looptimes];
				String price = Double.toString(RestaurantMenu.get(items))+"[Selected]";
				SaveRestaurantMenu.put(items,price);}
		    for (String items : RestaurantMenu.keySet()) {
		    	SelectionMenu.put(items,RestaurantMenu.get(items));};
		    for(int items=0 ;items<SaveRestaurantMenu.size();items++){InputCounterArray[items] = false;}}
			 else{
					for(int looptimes = 0;looptimes< Integer.valueOf(NumberDoneAll)-1;looptimes++){
						String items = OrderItem[looptimes];
						String price = OrderPrice[looptimes];
						SaveRestaurantMenu.put(items,price);}
					String items = OrderItem [Integer.valueOf(NumberDoneAll)-1];
						String price = Double.toString(RestaurantMenu.get(items));
						SelectionMenu.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
						SaveRestaurantMenu.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
						SaveRestaurantMenu.put(items,price);
					for(int looptimes = Integer.valueOf(NumberDoneAll);looptimes<OrderItem.length ;looptimes++){
						items = OrderItem[looptimes];
						price = OrderPrice[looptimes];
						SaveRestaurantMenu.put(items,price);}
					InputCounterArray[Integer.valueOf(NumberDoneAll)-1]=!InputCounterArray[Integer.valueOf(NumberDoneAll)-1];}
				ShowSaveRestaurantMenu("---   " +type+" Menu   ---");
			    for (int clearloop = 0; clearloop < OrderItem.length; clearloop++){
			    OrderItem [clearloop]= null;
			    OrderPrice[clearloop]=null;}}
	    }	
	}
	
	public void ShowSelectionMenu(){
		System.out.println("---   " +type+" Menu   ---");
    for (String items : SelectionMenu.keySet()) {
    	System.out.println(number+") "+items+"\t$"+SelectionMenu.get(items));number++;};
    	number = 1 ;
    System.out.println("----------------------\n");}
	public void ShowRestaurantMenu(String title){
	    System.out.println(title);
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------\n");
	    }
	public void ShowSubRestaurantMenu(String title){
	    System.out.println(title);
	    for (String items : SubRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t$"+SubRestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------\n");
	    }
	public void ShowSaveRestaurantMenu(String title){ 
		System.out.println(title);
    for (String items : SaveRestaurantMenu.keySet()) {
    	System.out.println(number+") "+items+"\t\t$"+SaveRestaurantMenu.get(items));number++;};
    	number = 1 ;
    System.out.println("----------------------\n");}
	    
	public void AddRestaurantMenu(String typename) {
		type=typename;
		input = new Scanner(System.in);
		System.out.println
		("You're now editing the list of "+type+" menu.\n"+
		 "Enter the NUMBER of Menu items:");
		int NumberOfItemToAdd = Integer.parseInt(input.nextLine());
		for(int looptimes = 1; looptimes<NumberOfItemToAdd;looptimes++){
		System.out.println("Enter "+type+" name to put on the menu:");
		String item = input.nextLine()+"\t";
		System.out.println("How much does it cost?");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    ShowRestaurantMenu("-----   Preview\t -----");}
		System.out.println("Enter "+type+" name to put on the menu:");
		String item = input.nextLine()+"\t";
		System.out.println("How much does it cost?");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");
	    ShowRestaurantMenu("---   " +type+" Menu   ---");}
	public void CreateSetMenu(HashMap<String,Double> foodMenu,HashMap<String,Double> drinkMenu){
		type="Drink";
		input = new Scanner(System.in);
		SaveRestaurantMenu.keySet().clear();
		for(String items : foodMenu.keySet()){
			System.out.println("Enter the Price of set for "+items);
			String item  = items+"(Set)";
			double price = Double.parseDouble(input.nextLine());
			SubRestaurantMenu.put(item,price);
			ShowSubRestaurantMenu("-----   Preview\t -----");}
		for(String items : drinkMenu.keySet()){
			String item  = items;
			double price = 0;
			RestaurantMenu.put(item,price);}
			SelectRestaurantMenuHelper();
			SelectRestaurantMenu("Select some drink for extrapayment");
			System.out.print("Enter the extrapayment:");
			double extrapayment = Double.parseDouble(input.nextLine());
			for(String items : ReadSelectionMenu().keySet()){
				RestaurantMenu.put(items,extrapayment);};
			System.out.println("Your SetMenu of is now be like");
			ShowSubRestaurantMenu("---   " +type+" Menu   ---");
			ShowRestaurantMenu("---   " +type+" Menu   ---");
			
		}
	
	
	public void OutputTextFile(String oneDrivePath,String shopID,String text,String Menu) throws IOException {
		switch (text){
		case "RestaurantMenu":
			FileOutputStream file = new FileOutputStream(new File(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			PrintStream print = new PrintStream(file);
			print.println(ReadRestaurantMenu());
			print.close();break;
		case "SubRestaurantMenu":
			file = new FileOutputStream(new File(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			print = new PrintStream(file);
			print.println(ReadSubRestaurantMenu());
			print.close();break;
		case "ShopAddress":
			file = new FileOutputStream(new File(oneDrivePath+"\\"+shopID+"\\ShopAddress.txt"));
			print = new PrintStream(file);
			print.println(ReadShopAddress());
			print.close();break;
		case "ShopNumber":
			file = new FileOutputStream(new File(oneDrivePath+"\\"+shopID+"\\ShopNumber.txt"));
			print = new PrintStream(file);
			print.println(ReadShopNumber());
			print.close();break;
			}
	}


}
