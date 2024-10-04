import java.util.*;

class Example {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		String spacing = "          ";

		// Render the title
		System.out.println(spacing + "  _____                      _     ______        _     _");
		System.out.println(spacing + " / ____|                    | |   |  ____|      | |   (_)");
		System.out.println(spacing + "| (___  _ __ ___   __ _ _ __| |_  | |__ __ _ ___| |__  _  ___  _ __");
		System.out.println(spacing + " \\___ \\| '_ ' _ \\ / _' | '__| __| |  __/ _' / __| '_ \\| |/ _ \\| '_ \\");
		System.out.println(spacing + " ____) | | | | | | (_| | |  | |_  | | | (_| \\__ \\ | | | | ( ) | | | |");
		System.out.println(spacing + "|_____/|_| |_| |_|\\__,_|_|   \\__| |_|  \\__,_|___/_| |_|_|\\___/|_| |_|");
		System.out.println();

		System.out.print(spacing + "Date : ");
		String date = input.nextLine();
		System.out.println();

		System.out.print(spacing + "Customer Name : ");
		String name = input.nextLine();
		System.out.println();

		System.out.println(spacing + "_________________________________________________________________________");
		System.out.println();
		System.out.println();
		System.out.println();

		// Render T-Shirt
		System.out.println(spacing + "                 _____    ___ _    _     _");
		System.out.println(spacing + "                |_   _|__/ __| |_ (_)_ _| |_ ___");
		System.out.println(spacing + "                  | ||___\\__ \\ ' \\| | '_|  _(_-<");
		System.out.println(spacing + "                  |_|    |___/_||_|_|_|  \\__/__/");
		System.out.println();
		System.out.println();

		System.out.print(spacing + "Number of T-Shirts : ");
		int tshirtCount = input.nextInt();
		System.out.println();

		double tshirtPrice = 900.0;
		System.out.println(spacing + "Unit Price of T-Shirt : " + tshirtPrice);
		System.out.println();

		double disRate = 0.05;
		double totalTshirt = tshirtPrice * (1 - disRate) * tshirtCount;

		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Description      |   QTY   |   Unit Price   |    Amount    |");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| T-Shirt          |" + padCenter(tshirtCount + "", 9, ' ') + "|" + padCenter(tshirtPrice + "", 16, ' ') + "|" + padCenter(totalTshirt + "", 14, ' ') + "|");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");

		System.out.println();
		System.out.println();
		System.out.println(spacing + "_________________________________________________________________________");
		System.out.println();
		System.out.println();

		// Render Trouser
		System.out.println(spacing + "			    _____");
		System.out.println(spacing + "			   |_   _| _ ___ _  _ ___ ___ _ _ ___");
		System.out.println(spacing + "			     | || '_/ _ \\ || (_-</ - ) '_(_-<");
		System.out.println(spacing + "			     |_||_| \\___/\\_,_/__/\\___|_| /__/");
		System.out.println();
		System.out.println();

		System.out.print(spacing + "Number of Trousers : ");
		int trouserCount = input.nextInt();
		System.out.println();

		double trouserPrice = 1200.0;
		System.out.println(spacing + "Unit Price of Trouser : " + trouserPrice);
		System.out.println();

		disRate = 0;
		double totalTrouser = trouserPrice * (1 - disRate) * trouserCount;

		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Description      |   QTY   |   Unit Price   |    Amount    |");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Trouser          |" + padCenter(trouserCount + "", 9, ' ') + "|" + padCenter(trouserPrice + "", 16, ' ') + "|" + padCenter(totalTrouser + "", 14, ' ') + "|");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");

		System.out.println();
		System.out.println();
		System.out.println(spacing + "_________________________________________________________________________");
		System.out.println();
		System.out.println();

		// Render Shirt
		System.out.println(spacing + "			    ___ _    _     _");
		System.out.println(spacing + "			   / __| |_ (_)_ _| |_ ___");
		System.out.println(spacing + "			   \\__ \\ ' \\| | '_|  _(_-<");
		System.out.println(spacing + "			   |___/_||_|_|_|  \\__/__/");
		System.out.println();
		System.out.println();

		System.out.print(spacing + "Number of T-Shirts : ");
		int shirtCount = input.nextInt();
		System.out.println();

		double shirtPrice = 900.0;
		System.out.println(spacing + "Unit Price of T-Shirt : " + shirtPrice);
		System.out.println();

		disRate = 0.05;
		double totalShirt = shirtPrice * (1 - disRate) * shirtCount;

		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Description      |   QTY   |   Unit Price   |    Amount    |");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Shirt            |" + padCenter(shirtCount + "", 9, ' ') + "|" + padCenter(shirtPrice + "", 16, ' ') + "|" + padCenter(totalShirt + "", 14, ' ') + "|");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");

		System.out.println();
		System.out.println();
		System.out.println(spacing + "_________________________________________________________________________");
		System.out.println();
		System.out.println();

		// Render Short
		System.out.println(spacing + "			    ___ _           _");
		System.out.println(spacing + "			   / __| |_  ___ _ _| |_ ___");
		System.out.println(spacing + "			   \\__ \\ ' \\/ _ \\ '_|  _(_-<");
		System.out.println(spacing + "			   |___/_||_\\___/_|  \\__/__/");
		System.out.println();
		System.out.println();

		System.out.print(spacing + "Number of T-Shirts : ");
		int shortCount = input.nextInt();
		System.out.println();

		double shortPrice = 900.0;
		System.out.println(spacing + "Unit Price of T-Shirt : " + shortPrice);
		System.out.println();

		disRate = 0.03;
		double totalShort = shortPrice * (1 - disRate) * shortCount;

		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Description      |   QTY   |   Unit Price   |    Amount    |");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");
		System.out.println(spacing + "| Shirt            |" + padCenter(shortCount + "", 9, ' ') + "|" + padCenter(shortPrice + "", 16, ' ') + "|" + padCenter(totalShort + "", 14, ' ') + "|");
		System.out.println(spacing + "+------------------+---------+----------------+--------------+");

		System.out.println();
		System.out.println();
		System.out.println(spacing + "_________________________________________________________________________");
		System.out.println();
		System.out.println();

		double total = totalTshirt + totalTrouser + totalShirt + totalShort;

		// Render the bill
		System.out.println(spacing + "+--------------------------------------------------------------------------+");
		System.out.println(spacing + "|                                                                          |");
		System.out.println(spacing + "|              ___ _ _ _   ___                                             |");
		System.out.println(spacing + "|             | _ |_) | | / __|_  _ _ __  _ __  __ _ _ _ _  _              |");
		System.out.println(spacing + "|             | _ \\ | | | \\__ \\ || | '  \\| '  \\/ _' | '_| || |             |");
		System.out.println(spacing + "|             |___/_|_|_| |___/\\_,_|_|_|_|_|_|_\\__,_|_|  \\_, |             |");
		System.out.println(spacing + "|                                                        |__/              |");
		System.out.println(spacing + "|                                                                          |");
		System.out.println(spacing + "|  Customer : " + padEnd(name + "", 42, ' ') + "Date : " + date + "  |");
		System.out.println(spacing + "|                                                                          |");
		System.out.println(spacing + "+--------------------+---------+---------------------+---------------------+");
		System.out.println(spacing + "| Description        |   QTY   |      Unit Price     |        Amount       |");
		System.out.println(spacing + "+--------------------+---------+---------------------+---------------------+");
		System.out.println(spacing + "|                    |         |                     |                     |");
		System.out.println(spacing + "| T-Shirt            |" + padCenter(tshirtCount + "", 9, ' ') + "|"+ padCenter(tshirtPrice + "", 21, ' ') + "|"+ padCenter(totalTshirt + "", 21, ' ') + "|");
		System.out.println(spacing + "|                    |         |                     |                     |");
		System.out.println(spacing + "| Trouser            |" + padCenter(trouserCount + "", 9, ' ') + "|"+ padCenter(trouserPrice + "", 21, ' ') + "|"+ padCenter(totalTrouser + "", 21, ' ') + "|");
		System.out.println(spacing + "|                    |         |                     |                     |");
		System.out.println(spacing + "| Shirt              |" + padCenter(shirtCount + "", 9, ' ') + "|"+ padCenter(shirtPrice + "", 21, ' ') + "|"+ padCenter(totalShirt + "", 21, ' ') + "|");
		System.out.println(spacing + "|                    |         |                     |                     |");
		System.out.println(spacing + "| Short              |" + padCenter(shortCount + "", 9, ' ') + "|"+ padCenter(shortPrice + "", 21, ' ') + "|"+ padCenter(totalShort + "", 21, ' ') + "|");
		System.out.println(spacing + "|                    |         |                     |                     |");
		System.out.println(spacing + "+--------------------+---------+---------------------+---------------------+");
		System.out.println(spacing + "| Total                                              |"+ padCenter(total + "", 21, ' ') + "|");
		System.out.println(spacing + "+----------------------------------------------------+---------------------+");
		
		System.out.println();
		System.out.println("----------------------------");
	}

	// I've created few methods to modify string to pad strings. There are padStart to add pad to start, padEnd to add pad to end  and padCenter to add pad to both start and end. So, I can make aligning in tables and the bill to be always alighn perfectly with any type of contemt in them.
	// Also don't worry, I've just created them on myself. I know making these functions bit unnessasery. Even adding comment about what I've done or what's my own opinion is bit odd. But I just want to make sure that no one makes bad image in there mind about me.

	public static String getPadStr (int len, int strLen, char character) {
		int deltaLen = len - strLen;
		String padStr = "";
		
		for (int i = 0; i < deltaLen; i++) {
			padStr += character;
		}

		return padStr;
	}

	public static String padStart (String str, int len, char character) {
		if (str.length() >= len) {
			return str;
		}

		return getPadStr(len, str.length(), character) + str;
	}

	public static String padEnd (String str, int len, char character) {
		if (str.length() >= len) {
			return str;
		}

		return str + getPadStr(len, str.length(), character);
	}

	public static String padCenter (String str, int len, char character) {
		if (str.length() >= len) {
			return str;
		}

		int startLen = (len - str.length()) / 2;
		int endLen = len - (str.length() + startLen);

		String startStr = "";
		String endStr = "";

		for (int i = 0; i < startLen; i++) {
			startStr += character;
		}

		for (int i = 0; i < endLen; i++) {
			endStr += character;
		}

		return startStr + str + endStr;
	}
}
