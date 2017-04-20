package ALLJava;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ShopOwner {
	private Scanner input;
	private String type;
	private static int number = 1;
	private String[] ShopInfo = new String [4];
	HashMap<String,Double> RestaurantMenu 	  = new HashMap<String,Double>();
	HashMap<String,Double> SubRestaurantMenu  = new HashMap<String,Double>();
	HashMap<String,Double> SelectionMenu 	  = new HashMap<String,Double>();
	HashMap<String,String> SaveRestaurantMenu = new HashMap<String,String>();
	
	public void ShopInformation(){
		input = new Scanner(System.in);
		System.out.println("Enter the following information of your reataurant\n"
				+ "Restaurant Name:");
		ShopInfo[0]="Restaurant Name:"+input.nextLine();
		System.out.println("Shop Address:");
		ShopInfo[1]=ShopInfo+"Shop Address:"+input.nextLine();
		System.out.println("About us:");
		ShopInfo[2]=ShopInfo+"About us:"+input.nextLine();
		System.out.println("Contact us:");
		ShopInfo[3]=ShopInfo+"Contact us:"+input.nextLine();
	}
	
	public void CreateColdDrinkMenu(){
		SelectRestaurantMenuHelper("Select the drink to copy as a cold drink with extra-payment");
		SelectRestaurantMenu();
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
	public String[] ReadShopInfo(){
		return ShopInfo;}

	public void RemoveRestaurantSetMenu(){
	SelectRestaurantSetMenuHelper("select TO REMOVE Set");
	SelectRestaurantMenu();
	for(String items : ReadSelectionMenu().keySet()){
		SubRestaurantMenu.remove(items);};
	System.out.println("Your Menu is now be like");
	ShowSubRestaurantMenu("---   Set Menu   ---");
	}
	public void RemoveRestaurantMenu(){
		SelectRestaurantMenuHelper("select TO REMOVE item(s)");
		SelectRestaurantMenu();
		for(String items : ReadSelectionMenu().keySet()){
			RestaurantMenu.remove(items);};
		System.out.println("Your Menu is now be like");
		ShowRestaurantMenu("---   " +type+" Menu   ---");}
	public void SelectRestaurantSetMenuHelper(String Function){
		SelectionMenu.keySet().clear();
		String[] OrderItem  = new String [SubRestaurantMenu.size()];int item = 0;for(String items : SubRestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		Double[] OrderPrice = new Double[SubRestaurantMenu.size()];item = 0;for(String items : SubRestaurantMenu.keySet()){OrderPrice[item] = SubRestaurantMenu.get(items);item++;}
		for(int looptimes = 0;looptimes<OrderItem.length;looptimes++){
			String items = OrderItem[looptimes];
			String price = String.valueOf(OrderPrice[looptimes]);
			SaveRestaurantMenu.put(items,price);}
		System.out.println("[Select Mode]"+Function+"\n"
				  + "Enter number > select or cancel\n"
				  + "Enter \"all\"  > select all\n"
				  + "Enter \"done\" > exit select mode");
		ShowSubRestaurantMenu("---   Set Menu   ---");
		}
	public void SelectRestaurantMenuHelper(String Function){
		SelectionMenu.keySet().clear();
		String[] OrderItem  = new String [RestaurantMenu.size()];int item = 0;for(String items : RestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		Double[] OrderPrice = new Double[RestaurantMenu.size()];item = 0;for(String items : RestaurantMenu.keySet()){OrderPrice[item] = RestaurantMenu.get(items);item++;}
		for(int looptimes = 0;looptimes<OrderItem.length;looptimes++){
			String items = OrderItem[looptimes];
			String price = String.valueOf(OrderPrice[looptimes]);
			SaveRestaurantMenu.put(items,price);}
		System.out.println("[Select Mode]"+Function+"\n"
				  + "Enter number > select or cancel\n"
				  + "Enter \"all\"  > select all\n"
				  + "Enter \"done\" > exit select mode");
		ShowRestaurantMenu("---   " +type+" Menu   ---");
		}
	public void SelectRestaurantMenu(){
		input = new Scanner(System.in);
		boolean InputCounter;
		boolean[] InputCounterArray = new boolean [SaveRestaurantMenu.size()]; for(int items=0 ;items<SaveRestaurantMenu.size();items++){InputCounterArray[items] = true;};
		while (true){
		String [] OrderItem  = new String [SaveRestaurantMenu.size()]; int item = 0 ;for(String items : SaveRestaurantMenu.keySet()){OrderItem   [item] = items;item++;};
		String [] OrderPrice = new String [SaveRestaurantMenu.size()];	   item = 0 ;for(String items : SaveRestaurantMenu.keySet()){OrderPrice  [item] = SaveRestaurantMenu.get(items);item++;}
		System.out.print("Command:");
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
    for (String items : ReadSelectionMenu().keySet()) {
    	System.out.println(number+") "+items+"\t\t$"+SelectionMenu.get(items));number++;};
    	number = 1 ;
    System.out.println("----------------------\n");}
	public void ShowRestaurantMenu(String title){
	    System.out.println(title);
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t\t$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------\n");
	    }
	public void ShowSubRestaurantMenu(String title){
	    System.out.println(title);
	    for (String items : SubRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t\t$"+SubRestaurantMenu.get(items));number++;};
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
		System.out.print
		("[Edit mode]"+type+" menu.\n"+
		 "How many item(s) you would like to add?\n"
		 + "Enter a number:");
		int NumberOfItemToAdd = Integer.parseInt(input.nextLine());
		for(int looptimes = 0; looptimes<NumberOfItemToAdd-1;looptimes++){
		System.out.print("Step one: Name of "+type+"\n"
				+ "Step two: Price of it\n"
				+"["+Integer.toString(NumberOfItemToAdd-looptimes)+" left]Enter Name:");
		String item = input.nextLine();
		System.out.print("\tEnter Cost:");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    ShowRestaurantMenu("-----   Preview\t -----");}
		System.out.print("Step one: Name of "+type+"\n"
				+ "Step two: Price of it\n"
				+"[1 left]Enter Name:");
		String item = input.nextLine();
		System.out.print("\tEnter Cost:");
		double price = Double.parseDouble(input.nextLine());
	    RestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");
	    ShowRestaurantMenu("---   " +type+" Menu   ---");}
	public void CreateSetMenu(HashMap<String,Double> foodMenu,HashMap<String,Double> drinkMenu){
		input = new Scanner(System.in);
		SaveRestaurantMenu.keySet().clear();
		for(String items : foodMenu.keySet()){
			System.out.println("Enter the Price of "+items+"(Set)");
			String item  = items+"(Set)";
			double price = Double.parseDouble(input.nextLine());
			SubRestaurantMenu.put(item,price);
			ShowSubRestaurantMenu("-----   Preview\t -----");}
		for(String items : drinkMenu.keySet()){
			String item  = items;
			double price = 0;
			RestaurantMenu.put(item,price);}
			SelectRestaurantMenuHelper("Select some drink for extra-payment");
			SelectRestaurantMenu();
			System.out.print("Enter the extra-payment:");
			double extrapayment = Double.parseDouble(input.nextLine());
			for(String items : ReadSelectionMenu().keySet()){
				RestaurantMenu.put(items,extrapayment);};
			System.out.println("Your SetMenu is now being like");
			ShowSubRestaurantMenu("---   Set Menu   ---");
			ShowRestaurantMenu("---   Drink Menu   ---");
			
		}
	
	public void OutputTextFile(String oneDrivePath,String shopID,String text,String Menu) throws IOException {
		switch (text){
		case "RestaurantMenu":
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\"+Menu));
			file.writeObject(ReadRestaurantMenu());
			file.close();break;
		case "SubRestaurantMenu":
			file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			file.writeObject(ReadSubRestaurantMenu());
			file.close();break;
		case "ShopInfo":
			file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\ShopInfo.txt"));
			file.writeObject(ReadShopInfo());
			file.close();break;
			}
	}
	public void InputTextFile(String oneDrivePath,String shopID,String text,String Menu)throws IOException, ClassNotFoundException{
		switch (text){
		case "RestaurantMenu":
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			RestaurantMenu = (HashMap<String,Double>) file.readObject();
			SaveRestaurantMenu.keySet().clear();
			for (String items : RestaurantMenu.keySet()) {
				String item = items;
				String price = String.valueOf(ReadSelectionMenu().get(items));
				SaveRestaurantMenu.put(item,price);}
			file.close();break;
		case "SubRestaurantMenu":
			file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			SubRestaurantMenu = (HashMap<String,Double>) file.readObject();
			SaveRestaurantMenu.keySet().clear();
			for (String items : SubRestaurantMenu.keySet()) {
				String item = items;
				String price = String.valueOf(ReadSelectionMenu().get(items));
				SaveRestaurantMenu.put(item,price);}
			file.close();break;
		case "ShopInfo":
			file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\ShopInfo.txt"));
			ShopInfo = (String[]) file.readObject();
			file.close();break;
			}
	}
	}

