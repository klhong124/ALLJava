package ALLJava;

import java.io.IOException;

public class CustomerMainFlow extends PreOrder{
	
	public void mainflow() throws ClassNotFoundException, IOException{
	      selectShop.InputTextFile(OneDrivePath,"", "SelectShop", "");
	      selectShop.ShowRestaurant();
	}
}
