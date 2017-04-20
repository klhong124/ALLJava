import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

class ParserException extends Exception {
	String errStr;

	public ParserException(String str) {
		errStr = str;
	}

	public String toString() {
		return errStr;
	}
}

public class Readtxt {
	public static String storeInput = new String();
	public static int counter = 0;
	public static HashMap<StringBuilder,StringBuilder> RestaurantMenu = new HashMap<StringBuilder,StringBuilder>();
	public static int endPlace = 0;
	public static void main(String [] argv) throws IOException {
		FileReader fr = new FileReader("FoodMenu.txt");
		BufferedReader br = new BufferedReader(fr);
		while (br.ready()) {
			//System.out.println(br.readLine());
			storeInput = br.readLine();
			System.out.println(storeInput);
			readEach();
		}
		fr.close();
	}

	private static void readEach() {
		char op;

		while((op = storeInput.charAt(0)) == '{') {
			counter++;
			checkNext(counter);
		}
		checkEnd(endPlace);
	}

	private static void checkNext(int counterPlusOne) {
		char op;
		int charPlace = 0;
		int intPlace = 0;
		StringBuilder name = new StringBuilder("");
		StringBuilder price = new StringBuilder("");
		while (Character.isLetter(storeInput.charAt(counterPlusOne))) { //check是咪letter
			name.append(storeInput.charAt(counterPlusOne)); // 將個字加落name
			charPlace = counterPlusOne++; //去下一格
			while (Character.isWhitespace(storeInput.charAt(counterPlusOne))) {
				counterPlusOne++;
			}
			/*while ((op = storeInput.charAt(counterPlusOne)) != '}' || (op != ',')) {
				price.append(storeInput.charAt(counterPlusOne));
				System.out.println("789");
				counterPlusOne++;
			}*/
			while ((op = storeInput.charAt(counterPlusOne)) == '=') {
				counterPlusOne++;
			}
			while (Character.isDigit(storeInput.charAt(counterPlusOne))) {
				price.append(storeInput.charAt(counterPlusOne));
				intPlace = counterPlusOne++;
				while ((op = storeInput.charAt(counterPlusOne)) == '.') {
					price.append(storeInput.charAt(counterPlusOne));
					counterPlusOne++;
				}
			}
			RestaurantMenu.put(name, price);
			System.out.println(RestaurantMenu);
			counterPlusOne++;
		}
		endPlace = counterPlusOne;
	}

	private static void checkEnd(int end) {
		char op;
		if ((op = storeInput.charAt(endPlace)) == '}') {
			System.out.println("The end");
		}
	}
}