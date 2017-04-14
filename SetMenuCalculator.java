package ALLJava;
import java.util.Scanner;
public class SetMenuCalculator extends PreOrder{
	private Scanner input;
	
	public void SetMenuCalculatorHelper(){
		input = new Scanner(System.in);
		System.out.println("You are now defining a meal set,\n"+
						   "Select a food by entering the order number.");
		foodMenu.ShowRestaurantMenu();
			int OrderNumber = Integer.parseInt(input.nextLine())-1;
			System.out.println("Select Drinks and set a price with "+foodMenu.ReadOrderItem()[OrderNumber]+" as a meal set.\n"+
							   "Enter the number to select\n"+
							   "Enter \"done\" to comfirm the selection+"+
							   "Enter \"all\" to select all items.");
			
			for(int looptimes = 0;looptimes< drinkMenu.ReadOrderItem().length;looptimes++){
				drinkMenu.ShowRestaurantMenu();
				String NumberDoneAll = input.nextLine(); 
				if (NumberDoneAll.equals("done")){break;
				}	else if (NumberDoneAll.equals("all")){drinkMenu.SelectRestaurantMenu(NumberDoneAll);break;
				}	else{drinkMenu.SelectRestaurantMenu(NumberDoneAll);
				}
			}}}
		
	

