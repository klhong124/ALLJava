package ALLJava;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class HashMapRestaurantMenu {
	private Scanner input;
	private String type;
	private int number = 1;
	HashMap<String, Integer> EditRestaurantMenu = new HashMap<String, Integer>();
	public void test(){
		System.out.println(EditRestaurantMenu.size());
		String[] keyset = EditRestaurantMenu.keySet().toArray(new String[EditRestaurantMenu.size()]);
		System.out.println(keyset);
	}
	
	public void RemoveRestaurantMenu(){
		input = new Scanner(System.in);
		System.out.println("You're now able to remove any unwanted item on "+type+" menu.\n"
				+ "Enter the item number to Delete:");
		System.out.println("---   " +type+" Menu\t   ---");
	    for (String items : EditRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+EditRestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------");
		int item = Integer.parseInt(input.nextLine());
		String[] keyset = EditRestaurantMenu.keySet().toArray(new String[EditRestaurantMenu.size()]);
		//EditRestaurantMenu.remove(keyset[]);
	}
	
	public void ShowRestaurantMenu(){
	    System.out.println("---   " +type+" Menu\t   ---");
	    for (String items : EditRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+EditRestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("----------------------");};
	    
	public void EditRestaurantMenu(String typename) {
		type=typename;
		input = new Scanner(System.in);
		System.out.println
		("You're now editing the list of "+type+" menu.\n"
				+ "Enter the NUMBER of item wanted to add:");
		int NumberOfItemToAdd = Integer.parseInt(input.nextLine());
		for(int looptimes = 1; looptimes<NumberOfItemToAdd;looptimes++){
		System.out.println("What kind of "+type+" would you like you put on the menu?:");
		String item = input.nextLine();
		System.out.println("How much does *"+item+"* cost?");
		int price = Integer.parseInt(input.nextLine());
	    EditRestaurantMenu.put(item,price);	
	    System.out.println("-----   Preview\t -----");
	    for (String items : EditRestaurantMenu.keySet()) {
	    	System.out.println(number+") "+items+"	$"+EditRestaurantMenu.get(items));number++;};
	    	number = 1 ;
	    System.out.println("-----     End  \t -----");}
		System.out.println("What kind of "+type+" would you like you put on the menu?:");
		String item = input.nextLine();
		System.out.println("How much does *"+item+"* cost?");
		int price = Integer.parseInt(input.nextLine());
	    EditRestaurantMenu.put(item,price);	
	    System.out.println("Your "+type+" menu is saved as:");}

}


