package ALLJava;
import java.util.Scanner;
import java.util.ArrayList;

public class PreOrder {
  public static void main(String[] args) {
	  
		HashMapRestaurantMenu foodMenu = new HashMapRestaurantMenu();
		HashMapRestaurantMenu drinkMenu = new HashMapRestaurantMenu();
		HashMapRestaurantMenu setMenu = new HashMapRestaurantMenu();
		foodMenu.EditRestaurantMenu("Food");	
		foodMenu.ShowRestaurantMenu();
		foodMenu.test();
		foodMenu.RemoveRestaurantMenu();
		foodMenu.ShowRestaurantMenu();
		drinkMenu.EditRestaurantMenu("Drink");}}
		
		
  /*	int role = getRole();// å•�ä½¿ç”¨è€…ä¿‚åº—ä¸»é‚„æ˜¯é¡§å®¢

    if (role == 1) { //å¦‚æžœæ˜¯åº—ä¸»
      int addSetChoice = askAddSetOrNot(); //å•�åº—ä¸»æ˜¯å�¦å¢žè¨­set
      ArrayList setList = new ArrayList(); //é–‹ä¸€å€‹setçš„list
      while (addSetChoice == 1) { //å¦‚æžœåº—ä¸»æƒ³å¢žè¨­set
        setList.add(addSet()); //inputæ¯�ä¸€å€‹setå†�å°‡æ¯�ä¸€å€‹setæ”¾å…¥setçš„list
        int addComponentChoice = askAddComponentOrNot(); //å•�åº—ä¸»æ˜¯å�¦å¢žè¨­component
        while (addComponentChoice == 1) { //å¦‚æžœåº—ä¸»æƒ³å¢žè¨­component
          setList.add(addComponent()); // inputæ¯�ä¸€å€‹componentå†�å°‡æ¯�ä¸€å€‹componentåŠ å…¥setçš„list
          System.out.println(setList);// æ¯”è‡ªå·±ç�‡ä¸‹æˆ�å””æˆ�åŠŸonly
        }
      }
      PrintStream out = new PrintStream(new FileOutputStream("Output.txt"));
      System.setOut(out);
    }
  }

  private static int getRole() {
    System.out.println("What is your role?");
    System.out.println("1) Store owners\n2) customers");
    System.out.println("1 or 2?");
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  private static int askAddSetOrNot() {
    System.out.println("Type 1 if you want to add set for your restaurant\notherwise type 0");
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  private static ArrayList addSet() {
    ArrayList set = new ArrayList();
    Scanner input = new Scanner(System.in);
    System.out.println("Input the name of the set.");
    String setName = input.nextLine();
    System.out.println("Input the price of the set.");
    float setPrice = input.nextFloat();
    set.add(setName);
    set.add(setPrice);
    return set;
  }

  private static int askAddComponentOrNot() {
    System.out.println("Type 1 if you want to add component\notherwise type 0");
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  private static ArrayList addComponent() {
  	ArrayList componentList = new ArrayList();
  	System.out.println("What is the type of component?");
    Scanner input = new Scanner(System.in);
  	String componentType = input.nextLine();
  	componentList.add(componentType);
  	int option = 0;
  	while (option != 1) {
  		System.out.println("Component name: ");
  		String component = input.nextLine();
  		System.out.println("Price: ");
  		float price = input.nextFloat();
  		componentList.add(component);
  		componentList.add(price);
  		System.out.println("Type 1 to continue adding\nType 0 for not adding");
  		option = input.nextInt();
  	}
    return componentList;
  }
}*/
