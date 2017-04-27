package ALLJava;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RestaurantMenu {
	private Scanner input;
	private String type;
	private static int number = 1;
	HashMap<String,Double> RestaurantMenu 	   = new HashMap<String,Double>();
	HashMap<String,Double> SelectionMenu 	   = new HashMap<String,Double>();
	HashMap<String,String> StringStringHashMap = new HashMap<String,String>();

	public String EditStringStringHashMap(String infoORselect,String oneDrivePath,String ID,String NAME) throws IOException{
		input = new Scanner(System.in);
		String ShopID;
		String ShopName;
		if (infoORselect.equals("select")){
			 while(true){
				  System.out.print("Enter a ShopID.");
		    	  ShopID=input.nextLine();
		    	  File folder=new File(oneDrivePath+"\\"+ShopID);
				  if(!folder.exists()&&!folder.isDirectory())
				  {new File(oneDrivePath+"\\"+ShopID).mkdir();
				  new File(oneDrivePath+"\\"+ShopID+"\\Order").mkdir();
				  break;}
				  else{System.out.print("This ShopID is already used.\n"
				  		+ "please try again,");}}
			return ShopID;}
		else if (infoORselect.equals("info")){
		System.out.println("Enter the following information of your reataurant\n"
				+ "Restaurant Name:");
		StringStringHashMap.put("Restaurant Name: ",ShopName=input.nextLine());
		System.out.println("Shop Address:");
		StringStringHashMap.put("Shop Address: ", input.nextLine());
		System.out.println("About us:");
		StringStringHashMap.put("About us: ", input.nextLine());
		System.out.println("Contact us:");
		StringStringHashMap.put("Contact us: ", input.nextLine());
		return ShopName;}
		else {StringStringHashMap.put(NAME,ID);
		OutputTextFile(oneDrivePath,"","SelectShop","");}
		return null;
	}
	
	public void CreateColdDrinkMenu(){
		SelectRestaurantMenuHelper("Select the drink to copy as a cold drink with extra-payment","Drink");
		SelectRestaurantMenu("Drink");
		StringStringHashMap.keySet().clear();
		System.out.print("Enter the extra-payment for Cold Drink.");
		double extrapayment = 0;
		while (extrapayment == 0) {
			try {
				extrapayment = Double.parseDouble(input.nextLine());
			} catch (NumberFormatException ie) {
				extrapayment = 0; //back to start of while loop
				System.out.println("Please try again......");
				System.out.print("Enter the extra-payment for Cold Drink.");
			}
		}
		for (String items : ReadSelectionMenu().keySet()) {
			String item = items+"(Cold)";
			String price = String.valueOf(ReadSelectionMenu().get(items)+extrapayment);
			StringStringHashMap.put(item,price);};
		for (String items : StringStringHashMap.keySet()) {
			String item = items;
			double price = Double.parseDouble(StringStringHashMap.get(items));
			RestaurantMenu.put(item,price);}
		System.out.println("Your Menu is now be like");
		ShowRestaurantMenu("=========="+type+" Menu==========");}
		
	public HashMap<String,Double> ReadRestaurantMenu(){
		return RestaurantMenu;}
	public HashMap<String,Double> ReadSelectionMenu(){
		return SelectionMenu;}
	public HashMap<String,String> ReadStringStringHashMap(){
		return StringStringHashMap;}
	
	public String ReadStringStringHashMapSelectionID(int Number){
		String [] Restaurant  = new String [StringStringHashMap.size()]; int item = 0 ;for(String items : StringStringHashMap.keySet()){Restaurant[item] = items;item++;};
	    String Selection = StringStringHashMap.get(Restaurant[Number-1]);
	    return Selection;}
	public String ReadStringStringHashMapSelectionNAME(int Number){
		String [] Restaurant  = new String [StringStringHashMap.size()]; int item = 0 ;for(String items : StringStringHashMap.keySet()){Restaurant[item] = items;item++;};
	    String Selection = Restaurant[Number-1];
	    return Selection;}
	
	public void RemoveRestaurantMenu(String Type){
		SelectRestaurantMenuHelper("select TO REMOVE item(s)",Type);
		SelectRestaurantMenu(Type);
		for(String items : ReadSelectionMenu().keySet()){
			RestaurantMenu.remove(items);};
		System.out.println("Your Menu is now be like");
		ShowRestaurantMenu("----------" +Type+" Menu----------");}

	public void SelectRestaurantMenuHelper(String Function,String Type){
		SelectionMenu.keySet().clear();
		String[] OrderItem  = new String [RestaurantMenu.size()];int item = 0;for(String items : RestaurantMenu.keySet()){OrderItem[item] = items;item++;};
		Double[] OrderPrice = new Double[RestaurantMenu.size()];item = 0;for(String items : RestaurantMenu.keySet()){OrderPrice[item] = RestaurantMenu.get(items);item++;}
		for(int looptimes = 0;looptimes<OrderItem.length;looptimes++){
			String items = OrderItem[looptimes];
			String price = String.valueOf(OrderPrice[looptimes]);
			StringStringHashMap.put(items,price);}
		System.out.println("[Select Mode]"+Function+"\n"
				  + "Enter number > select or cancel\n"
				  + "Enter \"all\"  > select all\n"
				  + "Enter \"done\" > exit select mode");
		ShowRestaurantMenu("=========="+Type+" Menu==========");
		}
	public void SelectRestaurantMenu(String Type){
		input = new Scanner(System.in);
		boolean InputCounter;
		boolean[] InputCounterArray = new boolean [StringStringHashMap.size()]; for(int items=0 ;items<StringStringHashMap.size();items++){InputCounterArray[items] = true;};
		while (true){
		String [] OrderItem  = new String [StringStringHashMap.size()]; int item = 0 ;for(String items : StringStringHashMap.keySet()){OrderItem   [item] = items;item++;};
		String [] OrderPrice = new String [StringStringHashMap.size()];	   item = 0 ;for(String items : StringStringHashMap.keySet()){OrderPrice  [item] = StringStringHashMap.get(items);item++;}
		System.out.print("Command:");
			String NumberDoneAll = input.nextLine(); 
		StringStringHashMap.clear();
		boolean situation = true; //situation that following while loop will start
		while (situation == true) {
			if(NumberDoneAll.length()==0){//if input is empty
				System.out.println("Please try again...");
				System.out.print("Command:");
				NumberDoneAll = input.nextLine();
			}else if(Character.isLetter(NumberDoneAll.charAt(0))){//if input is letter
				switch (NumberDoneAll){
				case "done":InputCounter=true; situation=false;break;
				case "all" :InputCounter=false;situation=false;break;
				default: System.out.println("Please try again");System.out.print("Command:");NumberDoneAll = input.nextLine();
				}
			}else {//if input is digit
				try {
					InputCounter=InputCounterArray[Integer.valueOf(NumberDoneAll)-1];
					situation=false;
				}catch(ArrayIndexOutOfBoundsException ie){
					System.out.println("It is out of the array");
					System.out.print("Command:");
					NumberDoneAll = input.nextLine();
				}
			}
		}
		if(InputCounter==true){
		if (NumberDoneAll.equals("done")){break;}
	    else{
			for(int looptimes = 0;looptimes< Integer.valueOf(NumberDoneAll)-1;looptimes++){
				String items = OrderItem[looptimes];
				String price = OrderPrice[looptimes];
				StringStringHashMap.put(items,price);}
			String items = OrderItem [Integer.valueOf(NumberDoneAll)-1];
				String price = OrderPrice[Integer.valueOf(NumberDoneAll)-1]+"[Selected]";
				SelectionMenu.put(OrderItem [Integer.valueOf(NumberDoneAll)-1],RestaurantMenu.get(items));
				StringStringHashMap.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
				StringStringHashMap.put(items,price);
			for(int looptimes = Integer.valueOf(NumberDoneAll);looptimes<OrderItem.length ;looptimes++){
				items = OrderItem[looptimes];
				price = OrderPrice[looptimes];
				StringStringHashMap.put(items,price);}
			InputCounterArray[Integer.valueOf(NumberDoneAll)-1]=!InputCounterArray[Integer.valueOf(NumberDoneAll)-1];}
		ShowStringStringHashMap("----------" +Type+" Menu----------");
	    for (int clearloop = 0; clearloop < OrderItem.length; clearloop++){
	    OrderItem[clearloop]= null;
	    OrderPrice[clearloop]=null;}}
		if(InputCounter==false){
			if (NumberDoneAll.equals("all")){ 
			for(int looptimes = 0;looptimes<OrderItem.length ;looptimes++){
				String items = OrderItem[looptimes];
				String price = Double.toString(RestaurantMenu.get(items))+"[Selected]";
				StringStringHashMap.put(items,price);}
		    for (String items : RestaurantMenu.keySet()) {
		    	SelectionMenu.put(items,RestaurantMenu.get(items));};
		    for(int items=0 ;items<StringStringHashMap.size();items++){InputCounterArray[items] = false;}}
			 else{
					for(int looptimes = 0;looptimes< Integer.valueOf(NumberDoneAll)-1;looptimes++){
						String items = OrderItem[looptimes];
						String price = OrderPrice[looptimes];
						StringStringHashMap.put(items,price);}
					String items = OrderItem [Integer.valueOf(NumberDoneAll)-1];
						String price = Double.toString(RestaurantMenu.get(items));
						SelectionMenu.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
						StringStringHashMap.remove(OrderItem [Integer.valueOf(NumberDoneAll)-1]);
						StringStringHashMap.put(items,price);
					for(int looptimes = Integer.valueOf(NumberDoneAll);looptimes<OrderItem.length ;looptimes++){
						items = OrderItem[looptimes];
						price = OrderPrice[looptimes];
						StringStringHashMap.put(items,price);}
					InputCounterArray[Integer.valueOf(NumberDoneAll)-1]=!InputCounterArray[Integer.valueOf(NumberDoneAll)-1];}
				ShowStringStringHashMap("=========="+Type+" Menu==========");
			    for (int clearloop = 0; clearloop < OrderItem.length; clearloop++){
			    OrderItem [clearloop]= null;
			    OrderPrice[clearloop]=null;}}
	    }	
	}
	
	public void ShowSelectionMenu(String Type,String End){
		System.out.println("=========="+Type+" Menu==========");
    for (String items : ReadSelectionMenu().keySet()) {
    	System.out.println(number+") "+items+"\t$"+SelectionMenu.get(items));number++;};
    	number = 1 ;
    System.out.print(End);}
	public void ShowRestaurantMenu(String title){
	    System.out.println(title);
	    for (String items : RestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"\t$"+RestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------------");
	    }

	public void ShowStringStringHashMap(String title){ 
		System.out.println(title);
    for (String items : StringStringHashMap.keySet()) {
    	System.out.println(number+") "+items+"\t$"+StringStringHashMap.get(items));number++;};
    	number = 1 ;
    System.out.println("==============================");}
	public void ShowShopInformation(){
		System.out.println("\n==========Shop Info.==========");
	    for (String items : StringStringHashMap.keySet()) {
	    	System.out.println(items+StringStringHashMap.get(items));};
	    System.out.println("==============================");}
	public void ShowRestaurant(){
		System.out.println("==========Restauran==========");
	    for (String items : StringStringHashMap.keySet()) {
	    	System.out.println("["+number+"] "+items);number++;};
	    	number = 1 ;
	    System.out.println("==============================");}
	
	public void AddRestaurantMenu(String typename) {
		type=typename;
		input = new Scanner(System.in);
		System.out.print
		("[Edit mode]"+type+" menu.\n"+
		 "How many item(s) you would like to add?\n"
		 + "Enter a number:");
		int NumberOfItemToAdd = 0;
		while (NumberOfItemToAdd == 0) {
			try {
				NumberOfItemToAdd = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException ie)
			{
				NumberOfItemToAdd = 0;
				System.out.print
				("Please try again...\n\n"+
				"[Edit mode]"+type+" menu.\n"+
				 "How many item(s) you would like to add?\n"
				 + "Enter a number:"); 
			}
		}
		for(int looptimes = 0; looptimes<NumberOfItemToAdd-1;looptimes++){
		System.out.print("Step one: Name of "+type+"\n"
				+ "Step two: Price of it\n"
				+"["+Integer.toString(NumberOfItemToAdd-looptimes)+" left]Enter Name:");
		String item = input.nextLine()+"\t";
		System.out.print("\tEnter Cost:");
		double price = 0;
		while (price == 0) {
			try {
				price = Double.parseDouble(input.nextLine());
			} catch (NumberFormatException ie) {
				price = 0;
				System.out.print("\tEnter Cost:");
			}
		}
	    RestaurantMenu.put(item,price);	
	    ShowRestaurantMenu("==========Preview==========");}
		System.out.print("Step one: Name of "+type+"\n"
				+ "Step two: Price of it\n"
				+"[1 left]Enter Name:");
		String item = input.nextLine()+"\t";
		System.out.print("\tEnter Cost:");
		double price = 0;
		while (price == 0) {
			try {
				price = Double.parseDouble(input.nextLine());
			} catch (NumberFormatException ie) {
				price = 0;
				System.out.print("\tEnter Cost:");
			}
		}
	    RestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");
	    ShowRestaurantMenu("=========="+type+" Menu==========");}
	public void CreateSetFoodMenu(HashMap<String,Double> FoodMenu){
		input = new Scanner(System.in);
		StringStringHashMap.keySet().clear();
		for(String items : FoodMenu.keySet()){
			System.out.println("Enter the Price of "+items+"(Set)");
			String item  = items+"(Set)";
			double price = 0;
			while (price == 0) {
				try {
					price = Double.parseDouble(input.nextLine());
				} catch (NumberFormatException ie) {
					price = 0;
					System.out.println("Please try again");
					System.out.println("Enter the Price of "+items+"(Set)");
				}
			}
			RestaurantMenu.put(item,price);
			ShowRestaurantMenu("==========Preview==========");}}
	public void CreateSetDrinkMenu(HashMap<String,Double> DrinkMenu){
		input = new Scanner(System.in);
		StringStringHashMap.keySet().clear();
		for(String items : DrinkMenu.keySet()){
			String item  = items;
			double price = 0;
			RestaurantMenu.put(item,price);}
			SelectRestaurantMenuHelper("Select some drink for extra-payment","Drink");
			SelectRestaurantMenu("Drink");
			System.out.print("Enter the extra-payment:");
			double extrapayment = Double.parseDouble(input.nextLine());
			for(String items : ReadSelectionMenu().keySet()){
				RestaurantMenu.put(items,extrapayment);};
			System.out.println("Your SetMenu is now being like");
		}
	
	public double Calculator(){
	    double total = 0;
	    for (String items : ReadSelectionMenu().keySet()) {
	    total=total+	SelectionMenu.get(items);};
	    return total;
	}
	public void ShowTotal(){
		System.out.println("Total:\t\t$"+Calculator());
	}

	public String[] ReadSetDrinkMenu(){
		String [] Restaurant  = new String [RestaurantMenu.size()]; int item = 0 ;for(String items : RestaurantMenu.keySet()){Restaurant[item] = items;item++;};
	    return Restaurant;}
	public void ReadSelectReadSetDrinkMenu(String key,Double value){
		SelectionMenu.put(key, value);
	}
	
	public void OutputTextFile(String oneDrivePath,String shopID,String text,String  Menu) throws IOException {
		switch (text){
		case "RestaurantMenu":
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			file.writeObject(ReadRestaurantMenu());
			file.close();break;
		case "ShopInfo":
			file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\ShopInfo.txt"));
			file.writeObject(ReadStringStringHashMap());
			file.close();break;
		case "SelectShop":
			file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\SelectShop.txt"));
			file.writeObject(ReadStringStringHashMap());
			file.close();break;
		case "SelectionMenu":
			file = new ObjectOutputStream(new FileOutputStream(oneDrivePath+"\\"+shopID+"\\Order\\"+Menu+".txt"));
			file.writeObject(ReadSelectionMenu());
			file.close();break;
			}
	}
	public void InputTextFile(String oneDrivePath,String shopID,String text,String Menu)throws IOException, ClassNotFoundException{
		switch (text){
		case "RestaurantMenu":
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\"+Menu+".txt"));
			RestaurantMenu .clear();
			RestaurantMenu = (HashMap<String,Double>) file.readObject();
			StringStringHashMap.keySet().clear();
			for (String items : RestaurantMenu.keySet()) {
				String item = items;
				String price = String.valueOf(ReadSelectionMenu().get(items));
				StringStringHashMap.put(item,price);}
			file.close();break;
		case "ShopInfo":
			file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\ShopInfo.txt"));
			StringStringHashMap .clear();
			StringStringHashMap = (HashMap<String,String>) file.readObject();
			file.close();break;
		case "SelectShop":
			file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\SelectShop.txt"));
			StringStringHashMap .clear();
			StringStringHashMap = (HashMap<String,String>) file.readObject();
			file.close();break;
		case "SelectionMenu":
			file = new ObjectInputStream(new FileInputStream(oneDrivePath+"\\"+shopID+"\\Order\\"+Menu+".txt"));
			SelectionMenu.clear();
			SelectionMenu = (HashMap<String,Double>) file.readObject();
			file.close();break;
			}
	}
	}

