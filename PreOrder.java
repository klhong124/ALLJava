import java.util.Scanner;
import java.util.ArrayList;

public class PreOrder {
  public static void main(String[] args) {
  	int role = getRole();// 問使用者係店主還是顧客

    if (role == 1) { //如果是店主
      int addSetChoice = askAddSetOrNot(); //問店主是否增設set
      ArrayList setList = new ArrayList(); //開一個set的list
      while (addSetChoice == 1) { //如果店主想增設set
        setList.add(addSet()); //input每一個set再將每一個set放入set的list
        int addComponentChoice = askAddComponentOrNot(); //問店主是否增設component
        while (addComponentChoice == 1) { //如果店主想增設component
          setList.add(addComponent()); // input每一個component再將每一個component加入set的list
          System.out.println(setList);// 比自己睇下成唔成功only
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
}
