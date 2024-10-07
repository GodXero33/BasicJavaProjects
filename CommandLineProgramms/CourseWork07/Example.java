import java.util.Scanner;

class Example {
	final public static Scanner input = new Scanner(System.in);
	final public static String[] pages = {
		"home", // 0
		"place-order", // 1
		"search-customer", // 2
		"search-order", // 3
		"view-reports", // 4
		"set-order-status", // 5
		"delete-order", // 6
		"customer-reports", // 7
		"item-reports", // 8
		"order-reports", // 9
		"best-customers", // 10
		"view-customers", // 11
		"all-customers-report", // 12
		"qty-sort-item-report",  // 13
		"amount-sort-item-report", // 14
		"all-orders", // 15
		"orders-by-amount" // 16
	};
	final public static String[] shirtSizes = { "xs", "s", "m", "l", "xl", "xxl" };
	final public static double[] shirtPrices = { 600, 800, 900, 1000, 1100, 1200 };
	final public static String spacing = "     ";
	public static int curOrderID = 1;
	public static int[] idList = new int[0];
	public static int[] statusList = new int[0];
	public static String[] phoneList = new String[0];
	public static int[] sizesList = new int[0];
	public static int[] qtyList = new int[0];
	public static double[] amountList = new double[0];

	// final public static 

	public static void main (String[] args) {
		// insertSampleData();
		goToPage("home");
	}


	// ---------------- Console helper methods -----------------------

	public static void clearConsole () {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearLines (int lineCount) {
		System.out.printf("\033[%dA\033[0J", lineCount);
	}


	// ---------------- Other helper methods ----------------

	public static void insertSampleData () {
		idList = pushToArray(idList, 1);
		idList = pushToArray(idList, 2);
		idList = pushToArray(idList, 3);
		idList = pushToArray(idList, 4);
		idList = pushToArray(idList, 5);
		idList = pushToArray(idList, 6);
		idList = pushToArray(idList, 7);
		idList = pushToArray(idList, 8);

		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);
		statusList = pushToArray(statusList, 0);

		phoneList = pushToArray(phoneList, "0776198410");
		phoneList = pushToArray(phoneList, "0776198410");
		phoneList = pushToArray(phoneList, "0703859852");
		phoneList = pushToArray(phoneList, "0703859852");
		phoneList = pushToArray(phoneList, "0703859852");
		phoneList = pushToArray(phoneList, "0769854321");
		phoneList = pushToArray(phoneList, "0775544336");
		phoneList = pushToArray(phoneList, "0712002200");

		sizesList = pushToArray(sizesList, 0);
		sizesList = pushToArray(sizesList, 2);
		sizesList = pushToArray(sizesList, 2);
		sizesList = pushToArray(sizesList, 4);
		sizesList = pushToArray(sizesList, 5);
		sizesList = pushToArray(sizesList, 5);
		sizesList = pushToArray(sizesList, 1);
		sizesList = pushToArray(sizesList, 2);

		qtyList = pushToArray(qtyList, 3);
		qtyList = pushToArray(qtyList, 3);
		qtyList = pushToArray(qtyList, 6);
		qtyList = pushToArray(qtyList, 4);
		qtyList = pushToArray(qtyList, 1);
		qtyList = pushToArray(qtyList, 1);
		qtyList = pushToArray(qtyList, 2);
		qtyList = pushToArray(qtyList, 3);

		amountList = pushToArray(amountList, 1800.0);
		amountList = pushToArray(amountList, 2700.0);
		amountList = pushToArray(amountList, 5400.0);
		amountList = pushToArray(amountList, 4400.0);
		amountList = pushToArray(amountList, 1200.0);
		amountList = pushToArray(amountList, 1200.0);
		amountList = pushToArray(amountList, 1600.0);
		amountList = pushToArray(amountList, 2700.0);

		curOrderID += 8;
	}

	public static String generateOrderID (int num) {
		final int len = 5;
		final char fillChar = '0';
		String str = num + "";

		if (str.length() >= len) return str;

		int deltaLen = len - str.length();
		String pad = "";

		for (int i = 0; i < deltaLen; i++) {
			pad += fillChar;
		}

		return "ODR#" + pad + str;
	}

	
	// --------------------- Array update methods -------------------------

	public static int findIndexFromArray (String[] arr, String value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) return i;
		}

		return -1;
	}

	public static int findIndexFromArray (int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) return i;
		}

		return -1;
	}

	public static int[] findAllIndicesFromArray (String[] arr, String value) {
		int[] tmp = new int[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) {
				tmp = pushToArray(tmp, i);
			}
		}

		return tmp;
	}

	public static int[] copyOfArray (int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		return b;
	}

	public static double[] copyOfArray (double[] a, double[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		return b;
	}

	public static String[] copyOfArray (String[] a, String[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		return b;
	}

	public static int[] pushToArray (int[] arr, int value) {
		final int n = arr.length;
		int[] tmp = new int[n + 1];

		copyOfArray(arr, tmp);

		tmp[n] = value;
		return tmp;
	}

	public static double[] pushToArray (double[] arr, double value) {
		final int n = arr.length;
		double[] tmp = new double[n + 1];

		copyOfArray(arr, tmp);

		tmp[n] = value;
		return tmp;
	}

	public static String[] pushToArray (String[] arr, String value) {
		final int n = arr.length;
		String[] tmp = new String[n + 1];

		copyOfArray(arr, tmp);

		tmp[n] = value;
		return tmp;
	}

	public static int[] removeElementFromArray (int[] arr, int index) {
		final int n = arr.length;
		int[] tmp = new int[n - 1];

		for (int i = 0; i < index; i++) {
			tmp[i] = arr[i];
		}

		for (int i = index + 1; i < n; i++) {
			tmp[i - 1] = arr[i];
		}

		return tmp;
	}

	public static double[] removeElementFromArray (double[] arr, int index) {
		final int n = arr.length;
		double[] tmp = new double[n - 1];

		for (int i = 0; i < index; i++) {
			tmp[i] = arr[i];
		}

		for (int i = index + 1; i < n; i++) {
			tmp[i - 1] = arr[i];
		}

		return tmp;
	}

	public static String[] removeElementFromArray (String[] arr, int index) {
		final int n = arr.length;
		String[] tmp = new String[n - 1];

		for (int i = 0; i < index; i++) {
			tmp[i] = arr[i];
		}

		for (int i = index + 1; i < n; i++) {
			tmp[i - 1] = arr[i];
		}

		return tmp;
	}

	public static int[] getCopyOfArray (int[] arr) {
		final int n = arr.length;
		int[] tmp = new int[n];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}

		return tmp;
	}

	public static double[] getCopyOfArray (double[] arr) {
		final int n = arr.length;
		double[] tmp = new double[n];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}

		return tmp;
	}

	public static String[] getCopyOfArray (String[] arr) {
		final int n = arr.length;
		String[] tmp = new String[n];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}

		return tmp;
	}

	public static String[] removeValueFromArray (String[] arr, String value) {
		String[] tmp = new String[0];

		for (String val : arr) {
			if (!val.equals(value)) {
				tmp = pushToArray(tmp, val);
			}
		}

		return tmp;
	}

	public static void sortArrayDoubleWithIntString (double[] dArr, int[] iArr, String[] sArr) {
		final int n = dArr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (dArr[j] < dArr[j + 1]) {
					double tmpD = dArr[j];
					dArr[j] = dArr[j + 1];
					dArr[j + 1] = tmpD;

					iArr[j] ^= iArr[j + 1];
					iArr[j + 1] ^= iArr[j];
					iArr[j] ^= iArr[j + 1];

					String tmpS = sArr[j];
					sArr[j] = sArr[j + 1];
					sArr[j + 1] = tmpS;
				}
			}
		}
	}

	public static void sortArrayIntWithDoubleString (int[] iArr, double[] dArr, String[] sArr) {
		final int n = iArr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (iArr[j] < iArr[j + 1]) {
					iArr[j] ^= iArr[j + 1];
					iArr[j + 1] ^= iArr[j];
					iArr[j] ^= iArr[j + 1];

					double tmpD = dArr[j];
					dArr[j] = dArr[j + 1];
					dArr[j + 1] = tmpD;

					String tmpS = sArr[j];
					sArr[j] = sArr[j + 1];
					sArr[j + 1] = tmpS;
				}
			}
		}
	}

	public static void sortArrayForOrdersReport (int[] orderIDArr, String[] phoneArr, int[] sizesArr, int[] qtyArr, double[] amountArr, int[] statusArr) {
		final int n = orderIDArr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (orderIDArr[j] < orderIDArr[j + 1]) {
					orderIDArr[j] ^= orderIDArr[j + 1];
					orderIDArr[j + 1] ^= orderIDArr[j];
					orderIDArr[j] ^= orderIDArr[j + 1];

					String tmpPhone = phoneArr[j];
					phoneArr[j] = phoneArr[j + 1];
					phoneArr[j + 1] = tmpPhone;

					sizesArr[j] ^= sizesArr[j + 1];
					sizesArr[j + 1] ^= sizesArr[j];
					sizesArr[j] ^= sizesArr[j + 1];

					qtyArr[j] ^= qtyArr[j + 1];
					qtyArr[j + 1] ^= qtyArr[j];
					qtyArr[j] ^= qtyArr[j + 1];

					double tmpAmount = amountArr[j];
					amountArr[j] = amountArr[j + 1];
					amountArr[j + 1] = tmpAmount;

					statusArr[j] ^= statusArr[j + 1];
					statusArr[j + 1] ^= statusArr[j];
					statusArr[j] ^= statusArr[j + 1];
				}
			}
		}
	}

	public static void sortArrayForOrdersReport (double[] amountArr, int[] orderIDArr, String[] phoneArr, int[] sizesArr, int[] qtyArr, int[] statusArr) {
		final int n = qtyArr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (amountArr[j] < amountArr[j + 1]) {
					double tmpAmount = amountArr[j];
					amountArr[j] = amountArr[j + 1];
					amountArr[j + 1] = tmpAmount;

					orderIDArr[j] ^= orderIDArr[j + 1];
					orderIDArr[j + 1] ^= orderIDArr[j];
					orderIDArr[j] ^= orderIDArr[j + 1];

					String tmpPhone = phoneArr[j];
					phoneArr[j] = phoneArr[j + 1];
					phoneArr[j + 1] = tmpPhone;

					sizesArr[j] ^= sizesArr[j + 1];
					sizesArr[j + 1] ^= sizesArr[j];
					sizesArr[j] ^= sizesArr[j + 1];

					qtyArr[j] ^= qtyArr[j + 1];
					qtyArr[j + 1] ^= qtyArr[j];
					qtyArr[j] ^= qtyArr[j + 1];

					statusArr[j] ^= statusArr[j + 1];
					statusArr[j + 1] ^= statusArr[j];
					statusArr[j] ^= statusArr[j + 1];
				}
			}
		}
	}

	public static int[][] pushArrayToArray (int[][] arr1, int[] arr2) {
		final int n = arr1.length;
		int[][] tmp = new int[n + 1][0];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr1[i];
		}

		tmp[n] = arr2;
		return tmp;
	}

	
	// ------------------ Program helper methods ----------------------

	public static void goToPage (String pageName) {
		clearConsole();

		if (pageName.equals(pages[0])) {
			homePage();
			return;
		}

		if (pageName.equals(pages[1])) {
			orderPlacePage();
			return;
		}

		if (pageName.equals(pages[2])) {
			searchCustomerPage();
			return;
		}

		if (pageName.equals(pages[3])) {
			searchOrderPage();
			return;
		}

		if (pageName.equals(pages[4])) {
			viewReportsPage();
			return;
		}

		if (pageName.equals(pages[5])) {
			setOrderStatusPage();
			return;
		}

		if (pageName.equals(pages[6])) {
			deleteOrderPage();
			return;
		}

		if (pageName.equals(pages[7])) {
			customerReportPage();
			return;
		}
		
		if (pageName.equals(pages[8])) {
			itemReportPage();
			return;
		}
		
		if (pageName.equals(pages[9])) {
			orderReportPage();
			return;
		}

		if (pageName.equals(pages[10])) {
			bestCustomersPage();
			return;
		}

		if (pageName.equals(pages[11])) {
			viewCustomersPage();
			return;
		}

		if (pageName.equals(pages[12])) {
			allCustomerReportPage();
			return;
		}

		if (pageName.equals(pages[13])) {
			qtySortItemReportPage();
			return;
		}

		if (pageName.equals(pages[14])) {
			amountSortItemReportPage();
			return;
		}

		if (pageName.equals(pages[15])) {
			allOrdersPage();
			return;
		}

		if (pageName.equals(pages[16])) {
			ordersByAmountPage();
		}
	}

	public static String getStatusString (int status) {
		return status == 0 ? "processing" : status == 1 ? "delivering" : "delivered";
	}

	public static boolean getValidYesOrNo (String message) {
		System.out.print(message);

		final String responseStr = input.nextLine();

		if (responseStr.equals("")) {
			clearLines(1);
			return getValidYesOrNo(message);
		}

		final char response = responseStr.charAt(0);

		if (response == 'y' || response == 'Y') return true;
		if (response == 'n' || response == 'N') return false;

		clearLines(1);
		return getValidYesOrNo(message);
	}

	public static String getValidPhoneNumber (boolean isTopLvlCall) {
		if (!isTopLvlCall) {
			System.out.println("\n" + spacing + "          Invalid Phone Number.. Try again\n");
			
			boolean response = getValidYesOrNo(spacing + "  Do you want to place this order? (y/n) : ");

			if (response) {
				clearLines(6);
			} else {
				return "";
			}
		}

		System.out.print(spacing + "  Enter Customer Phone Number : ");
		String phone = input.nextLine();
		System.out.println();

		final int len = phone.length();

		if (len > 10 || len < 9) return getValidPhoneNumber(false);
		
		if (phone.length() == 9) {
			phone = '0' + phone;
		}

		for (int i = 0; i < 10; i++) {
			char character = phone.charAt(i);

			if (character < 48 || character > 57) return getValidPhoneNumber(false);
		}

		if (phone.charAt(0) != '0') return getValidPhoneNumber(false);

		return phone;
	}

	public static int getValidTShirtSize () {
		System.out.print(spacing + "  Enter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
		String shirtSize = input.nextLine().toLowerCase();
		System.out.println();

		final int shirtSizeIndex = findIndexFromArray(shirtSizes, shirtSize);

		if (shirtSizeIndex != -1) return shirtSizeIndex;

		clearLines(2);
		return getValidTShirtSize();
	}

	public static int getValidQty () {
		System.out.print(spacing + "  Enter QTY : ");
		int qty = input.nextInt();
		input.nextLine();
		System.out.println();

		if (qty > 0) return qty;

		clearLines(2);
		return getValidQty();
	}

	public static double getAmountOfOrder (int sizeIndex, int qty) {
		return shirtPrices[sizeIndex] * qty;
	}

	public static int convertOrderIDStr2Int (String id) {
		final int len = id.length() - 4;

		if (len != 5) return -1;
		if (!id.substring(0, 4).equals("ODR#")) return -1;

		id = id.substring(4);

		int startIndex = -1;
		
		for (int i = 0; i < len; i++) {
			if (id.charAt(i) != '0') {
				startIndex = i;
			}
		}

		if (startIndex == -1) return -1;

		return Integer.parseInt(id.substring(startIndex));
	}

	public static int getValidOrderID () {
		System.out.print(spacing + "Enter order ID : ");
		String searchId = input.nextLine();

		int id = convertOrderIDStr2Int(searchId);

		if (findIndexFromArray(idList, id) == -1) id = -1; 

		if (id == -1) {
			System.out.println("\n" + spacing + "          Invalid id..\n");
			boolean response = getValidYesOrNo(spacing + "Do you want to search another order? (y/n) : ");
			
			if (response) {
				clearLines(5);
				return getValidOrderID();
			} else {
				return -1;
			}
		}

		return id;
	}

	public static boolean deleteOrder (int index) {
		if (idList.length <= index) return false;

		idList = removeElementFromArray(idList, index);
		statusList = removeElementFromArray(statusList, index);
		phoneList = removeElementFromArray(phoneList, index);
		sizesList = removeElementFromArray(sizesList, index);
		qtyList = removeElementFromArray(qtyList, index);
		amountList = removeElementFromArray(amountList, index);

		return true;
	}


	// Search result printing methods

	public static void printSearchCustomerDetails (String phone) {
		final int[] indicesList = findAllIndicesFromArray(phoneList, phone);
		final int n = indicesList.length;
		final String margin = spacing + "                   ";
		double total = 0;

		System.out.println(margin + "+----------+----------+---------------+");
		System.out.println(margin + "|   Size   |    QTY   |     Amount    |");
		System.out.println(margin + "+----------+----------+---------------+");

		for (int i = 0; i < n; i++) {
			final int index = indicesList[i];
			String size = shirtSizes[sizesList[index]];
			int qty = qtyList[index];
			double amount = amountList[index];
			total += amount;

			System.out.println(margin + "|          |          |               |");
			System.out.printf(
				"%s| %-9s| %-9d| %13f |\n",
				margin,
				size,
				qty,
				amount
			);
		}

		System.out.println(margin + "|          |          |               |");
		System.out.println(margin + "+----------+----------+---------------+");
		System.out.printf("%s| Total Amount        | %13f |\n", margin, total);
		System.out.println(margin + "+----------+----------+---------------+\n\n");

		System.out.println();
	}

	public static void printSearchOrderDetails (int orderID) {
		final int orderIndex = findIndexFromArray(idList, orderID);
		final String phone = phoneList[orderIndex];
		final String size = shirtSizes[sizesList[orderIndex]];
		final int qty = qtyList[orderIndex];
		final double amount = amountList[orderIndex];
		final String status = getStatusString(statusList[orderIndex]);

		System.out.println();
		System.out.println(spacing + "Phone Number : " + phone);
		System.out.println(spacing + "Size         : " + size);
		System.out.println(spacing + "QTY          : " + qty);
		System.out.println(spacing + "Amount       : " + amount);
		System.out.println(spacing + "Status       : " + status);
		System.out.println("\n");
	}

	public static void printCustomersReport (boolean enableSorting) {
		final int n = idList.length;
		final String margin = spacing + "                       ";
		String[] tmpPhoneList = getCopyOfArray(phoneList);
		int[] tmpQtyList = new int[0];
		double[] tmpAmoutList = new double[0];

		for (int i = 0; i < n; i++) {
			String phone = tmpPhoneList[i];

			if (phone.equals("")) continue;

			int[] indices = findAllIndicesFromArray(tmpPhoneList, phone);
			int qty = qtyList[i];
			double amount = amountList[i];

			for (int j = i + 1; j < n; j++) {
				if (tmpPhoneList[j].equals(phone)) {
					qty += qtyList[j];
					amount += amountList[j];
				}
			}

			tmpQtyList = pushToArray(tmpQtyList, qty);
			tmpAmoutList = pushToArray(tmpAmoutList, amount);

			if (indices.length > 1) {
				for (int j = 1; j < indices.length; j++) {
					tmpPhoneList[indices[j]] = "";
				}
			}
		}

		tmpPhoneList = removeValueFromArray(tmpPhoneList, "");

		if (enableSorting) sortArrayDoubleWithIntString(tmpAmoutList, tmpQtyList, tmpPhoneList);

		System.out.println(margin + "+-----------------+---------+------------------+");
		System.out.println(margin + "|   Customer ID   | All QTY |   Total Amount   |");
		System.out.println(margin + "+-----------------+---------+------------------+");

		for (int i = 0; i < tmpPhoneList.length; i++) {
			System.out.println(margin + "|                 |         |                  |");
			System.out.printf(
				"%s|   %s    | %5d   | %15f  |\n",
				margin,
				tmpPhoneList[i],
				tmpQtyList[i],
				tmpAmoutList[i]
			);
		}

		System.out.println(margin + "|                 |         |                  |");
		System.out.println(margin + "+-----------------+---------+------------------+\n");
	}

	public static void printAllCustomersReport () {
		final int n = idList.length;
		final String margin = spacing + "    ";
		String[] tmpPhoneList = getCopyOfArray(phoneList);
		int[][] tmpSizesList = new int[0][0];
		double[] tmpAmoutList = new double[0];

		for (int i = 0; i < n; i++) {
			String phone = tmpPhoneList[i];

			if (phone.equals("")) continue;

			int[] indices = findAllIndicesFromArray(tmpPhoneList, phone);
			int size = sizesList[i];
			int[] tmpQtyList = new int[6];
			double amount = amountList[i];
			
			tmpQtyList[size] = qtyList[i];

			for (int j = i + 1; j < n; j++) {
				if (tmpPhoneList[j].equals(phone)) {
					size = sizesList[j];
					tmpQtyList[size] += qtyList[j];
					amount += amountList[j];
				}
			}

			tmpSizesList = pushArrayToArray(tmpSizesList, tmpQtyList);
			tmpAmoutList = pushToArray(tmpAmoutList, amount);

			if (indices.length > 1) {
				for (int j = 1; j < indices.length; j++) {
					tmpPhoneList[indices[j]] = "";
				}
			}
		}

		tmpPhoneList = removeValueFromArray(tmpPhoneList, "");

		System.out.println(margin + "+-----------------+--------+--------+--------+--------+--------+--------+------------------+");
		System.out.println(margin + "|  Phone Number   |   XS   |    S   |    M   |    L   |   XL   |   XXL  |       Total      |");
		System.out.println(margin + "+-----------------+--------+--------+--------+--------+--------+--------+------------------+");

		for (int i = 0; i < tmpPhoneList.length; i++) {
			System.out.println(margin + "|                 |        |        |        |        |        |        |                  |");
			System.out.printf(
				"%s|   %s    | %5d  | %5d  | %5d  | %5d  | %5d  | %5d  | %15f  |\n",
				margin,
				tmpPhoneList[i],
				tmpSizesList[i][0],
				tmpSizesList[i][1],
				tmpSizesList[i][2],
				tmpSizesList[i][3],
				tmpSizesList[i][4],
				tmpSizesList[i][5],
				tmpAmoutList[i]
			);
		}

		System.out.println(margin + "+-----------------+--------+--------+--------+--------+--------+--------+------------------+\n");
	}

	public static void printItemReport (boolean sortingState) {
		final int n = qtyList.length;
		final String margin = spacing + "           ";
		int[] tmpQtyList = new int[6];
		double[] tmpAmoutList = new double[6];
		String[] tmpShirtSizesList = getCopyOfArray(shirtSizes);

		for (int i = 0; i < n; i++) {
			int qty = qtyList[i];
			int size = sizesList[i];
			double amount = getAmountOfOrder(size, qty);

			tmpQtyList[size] += qty;
			tmpAmoutList[size] += amount;
		}

		if (sortingState) {
			sortArrayIntWithDoubleString(tmpQtyList, tmpAmoutList, tmpShirtSizesList);
		} else {
			sortArrayDoubleWithIntString(tmpAmoutList, tmpQtyList, tmpShirtSizesList);
		}

		System.out.println(margin + "+----------+----------+--------------+");
		System.out.println(margin + "|   Size   |   QTY    | Total Amount |");
		System.out.println(margin + "+----------+----------+--------------+");
		
		for (int i = 0; i < 6; i++) {
			System.out.println(margin + "|          |          |              |");
			System.out.printf(
				"%s|  %3s     |  %5d   |  %10.2f  |\n",
				margin,
				tmpShirtSizesList[i].toUpperCase(),
				tmpQtyList[i],
				tmpAmoutList[i]
			);
		}

		System.out.println(margin + "+----------+----------+--------------+\n");
	}

	public static void printOrdersReport (boolean sortingState) {
		final int n = qtyList.length;
		final String margin = spacing + "           ";
		int[] tmpOrderIDList = getCopyOfArray(idList);
		String[] tmpPhoneList = getCopyOfArray(phoneList);
		int[] tmpSizesList = getCopyOfArray(sizesList);
		int[] tmpQtyList = getCopyOfArray(qtyList);
		double[] tmpAmoutList = getCopyOfArray(amountList);
		int[] tmpStatusList = getCopyOfArray(statusList);

		if (sortingState) {
			sortArrayForOrdersReport(tmpOrderIDList, tmpPhoneList, tmpSizesList, tmpQtyList, tmpAmoutList, tmpStatusList); // This must work if it simply reversed. (No need to sort at all) But I stick with this because course work tells it use to sorting.
		} else {
			sortArrayForOrdersReport(tmpAmoutList, tmpOrderIDList, tmpPhoneList, tmpSizesList, tmpQtyList, tmpStatusList);
		}

		System.out.println(margin + "+----------+---------------+--------+----------+---------------+---------------+");
		System.out.println(margin + "| Order ID |  Customer ID  |  Size  |   QTY    |     Amount    |     Status    |");
		System.out.println(margin + "+----------+---------------+--------+----------+---------------+---------------+");

		for (int i = 0; i < n; i++) {
			System.out.println(margin + "|          |               |        |          |               |               |");
			System.out.printf(
				"%s| %s|  %s   |  %4s  |  %5d   |  %11.2f  |  %-11s  |\n",
				margin,
				generateOrderID(tmpOrderIDList[i]),
				tmpPhoneList[i],
				shirtSizes[tmpSizesList[i]].toUpperCase(),
				tmpQtyList[i],
				tmpAmoutList[i],
				getStatusString(tmpStatusList[i])
			);
		}

		System.out.println(margin + "+----------+---------------+--------+----------+---------------+---------------+\n");
	}

	
	// -------------------- Pages methods ---------------------

	public static void homePage () {
		System.out.println();
		System.out.println(spacing + "    /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$");
		System.out.println(spacing + "   | $$_____/                | $$      |__/                           /$$__  $$| $$");
		System.out.println(spacing + "   | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$");
		System.out.println(spacing + "   | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println(spacing + "   | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println(spacing + "   | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println(spacing + "   | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println(spacing + "   |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/");
		System.out.println(spacing + "                                                                                                   | $$");
		System.out.println(spacing + "                                                                                                   | $$");
		System.out.println(spacing + "                                                                                                   |__/\n");
		System.out.println(spacing + "----------------------------------------------------------------------------------------------------------------\n");
		System.out.println(spacing + "          [1] Place Order                                          [2] Search Customer\n");
		System.out.println(spacing + "          [3] Search Order                                         [4] View Reports\n");
		System.out.println(spacing + "          [5] Set Order Status                                     [6] Delete Order\n\n");
		System.out.print(spacing + "           Input Option : ");

		int option = input.nextInt();
		input.nextLine();
		
		if (option < 1 || option > 6) {
			goToPage("home");
			return;
		}

		goToPage(pages[option]);
	}

	public static void orderPlacePage () {
		System.out.println();
		System.out.println(spacing + "    ____  _                   ___          _");
		System.out.println(spacing + "   |  _ \\| | __ _  ___ ___   / _ \\ _ __ __| | ___ _ __ ");
		System.out.println(spacing + "   | |_) | |/ _` |/ __/ _ \\ | | | | '__/ _` |/ _ \\ '__|");
		System.out.println(spacing + "   |  __/| | (_| | (_|  __/ | |_| | | | (_| |  __/ |");
		System.out.println(spacing + "   |_|   |_|\\__,_|\\___\\___|  \\___/|_|  \\__,_|\\___|_|\n");
		System.out.println(spacing + "---------------------------------------------------------\n");
		System.out.println(spacing + "  Enter Order ID : " + generateOrderID(curOrderID) + "\n");

		String phone = getValidPhoneNumber(true);

		if (phone.equals("")) {
			goToPage("home");
			return;
		}

		int shirtSizeIndex = getValidTShirtSize();
		int qty = getValidQty();
		double amount = getAmountOfOrder(shirtSizeIndex, qty);

		System.out.println(spacing + "  Amount : " + amount + "\n");
		
		boolean response = getValidYesOrNo(spacing + "  Do you want to place this order? (y/n) : ");

		if (response) {
			idList = pushToArray(idList, curOrderID);
			statusList = pushToArray(statusList, 0);
			phoneList = pushToArray(phoneList, phone);
			sizesList = pushToArray(sizesList, shirtSizeIndex);
			qtyList = pushToArray(qtyList, qty);
			amountList = pushToArray(amountList, amount);

			curOrderID++;
			System.out.println("\n" + spacing + "          Order Placed..!\n");
		}

		response = getValidYesOrNo(spacing + "  Do you want to place another order? (y/n) : ");

		if (response) {
			goToPage("place-order");
		} else {
			goToPage("home");
		}
	}

	public static void searchCustomerPage () {
		System.out.println();
		System.out.println(spacing + "     _____                     _        _____          _");
		System.out.println(spacing + "    / ____|                   | |      / ____|        | |");
		System.out.println(spacing + "   | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __");
		System.out.println(spacing + "    \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
		System.out.println(spacing + "    ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |");
		System.out.println(spacing + "   |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|\n");
		System.out.println(spacing + "---------------------------------------------------------------------------------------\n");

		String phone = getValidPhoneNumber(true);

		if (phone.equals("")) {
			goToPage("home");
			return;
		}

		if (findIndexFromArray(phoneList, phone) == -1) {
			System.out.println(spacing + "          Invalid input..\n\n");
		} else {
			printSearchCustomerDetails(phone);
		}

		boolean response = getValidYesOrNo(spacing + "  Do you want to search another customer report? (y/n) : ");

		if (response) {
			goToPage("search-customer");
		} else {
			goToPage("home");
		}
	}

	public static void searchOrderPage () {
		System.out.println();
		System.out.println(spacing + "     _____                     _        ____          _");
		System.out.println(spacing + "    / ____|                   | |      / __ \\        | |");
		System.out.println(spacing + "   | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __");
		System.out.println(spacing + "    \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println(spacing + "    ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |");
		System.out.println(spacing + "   |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|\n");
		System.out.println(spacing + "-------------------------------------------------------------------\n");

		int orderId = getValidOrderID();

		if (orderId == -1) {
			goToPage("home");
			return;
		}

		printSearchOrderDetails(orderId);
		
		boolean response = getValidYesOrNo(spacing + "Do you want to search another order? (y/n) : ");
		
		if (response) {
			goToPage("search-order");
		} else {
			goToPage("home");
		}
	}

	public static void viewReportsPage () {
		System.out.println(spacing + "    _____                       _");
		System.out.println(spacing + "   |  __ \\                     | |");
		System.out.println(spacing + "   | |__) |___ _ __   ___  _ __| |_ ___");
		System.out.println(spacing + "   |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(spacing + "   | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(spacing + "   |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println(spacing + "              | |");
		System.out.println(spacing + "              |_|\n");
		System.out.println(spacing + "-------------------------------------------\n");
		System.out.println(spacing + "          [1] Customer Reports\n");
		System.out.println(spacing + "          [2] Item Reports\n");
		System.out.println(spacing + "          [3] Order reports\n\n");
		System.out.print(spacing + "Enter option : ");

		int option = input.nextInt();
		input.nextLine();

		if (option < 1 || option > 3) {
			goToPage("view-reports");
			return;
		}

		goToPage(pages[option + 6]);
	}

	public static void setOrderStatusPage () {
		System.out.println();
		System.out.println(spacing + "     ____          _              _____ _        _");
		System.out.println(spacing + "    / __ \\        | |            / ____| |      | |");
		System.out.println(spacing + "   | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___");
		System.out.println(spacing + "   | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
		System.out.println(spacing + "   | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
		System.out.println(spacing + "    \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/\n");
		System.out.println(spacing + "------------------------------------------------------------------\n");

		int orderId = getValidOrderID();

		if (orderId == -1) {
			goToPage("home");
			return;
		}

		printSearchOrderDetails(orderId);

		final int orderIndex = findIndexFromArray(idList, orderId);
		final int orderStatus = statusList[orderIndex];

		if (orderStatus != 2) {
			boolean response = getValidYesOrNo(spacing + "Do you want to change this order status? (y/n) : ");

			if (response) {
				if (orderStatus == 0) {
					System.out.println("\n" + spacing + "      [1] Order Delivering\n\n" + spacing + "      [2] Order Delivered\n");
					System.out.print(spacing + "Enter option : ");

					int option = input.nextInt();
					input.nextLine();

					if (option < 1 || option > 2) {
						goToPage("set-order-status");
						return;
					}

					statusList[orderIndex] = option;
				} else {
					System.out.println("\n" + spacing + "      [1] Order Delivered\n");
					System.out.print(spacing + "Enter option : ");

					int option = input.nextInt();
					input.nextLine();

					if (option != 1) {
						goToPage("set-order-status");
						return;
					}

					statusList[orderIndex] = 2;
				}
			}
		} else {
			System.out.println("\n" + spacing + "        Can't change this order status, Order already delivered..!\n");
		}

		boolean response = getValidYesOrNo("\n" + spacing + "Do you want to change another order status? (y/n) : ");

		if (response) {
			goToPage("set-order-status");
		} else {
			goToPage("home");
		}
	}

	public static void deleteOrderPage () {
		System.out.println();
		System.out.println(spacing + "    _____       _      _          ____          _");
		System.out.println(spacing + "   |  __ \\     | |    | |        / __ \\        | |");
		System.out.println(spacing + "   | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __");
		System.out.println(spacing + "   | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println(spacing + "   | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |");
		System.out.println(spacing + "   |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|\n");
		System.out.println(spacing + "-------------------------------------------------------------\n");

		int orderId = getValidOrderID();

		if (orderId == -1) {
			goToPage("home");
			return;
		}

		printSearchOrderDetails(orderId);

		boolean response = getValidYesOrNo(spacing + "Do you want to delete this order? (y/n) : ");
		System.out.println();

		if (response) {
			final int orderIndex = findIndexFromArray(idList, orderId);
			boolean isDeleted = deleteOrder(orderIndex);

			if (isDeleted) {
				System.out.println(spacing + "          Order Deleted..!\n");
			}
		}
		
		response = getValidYesOrNo(spacing + "Do you want to delete another order? (y/n) : ");
		
		if (response) {
			goToPage("delete-order");
		} else {
			goToPage("home");
		}
	}

	public static void customerReportPage () {
		System.out.println();
		System.out.println(spacing + "     _____          _                              _____                       _");
		System.out.println(spacing + "    / ____|        | |                            |  __ \\                     | |");
		System.out.println(spacing + "   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___");
		System.out.println(spacing + "   | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(spacing + "   | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(spacing + "    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println(spacing + "                                                             | |");
		System.out.println(spacing + "                                                             |_|\n");
		System.out.println(spacing + "------------------------------------------------------------------------------------------\n");
		System.out.println(spacing + "          [1] Best in Customers\n");
		System.out.println(spacing + "          [2] View Customers\n");
		System.out.println(spacing + "          [3] All Customer Report\n\n");
		System.out.print(spacing + "Enter option : ");

		int option = input.nextInt();
		input.nextLine();

		if (option < 1 || option > 3) {
			goToPage("customer-reports");
			return;
		}

		goToPage(pages[option + 9]);
	}

	public static void itemReportPage () {
		System.out.println();
		System.out.println(spacing + " _____ _                   _____                       _");
		System.out.println(spacing + "|_   _| |                 |  __ \\                     | |");
		System.out.println(spacing + "  | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___");
		System.out.println(spacing + "  | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(spacing + " _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(spacing + "|_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println(spacing + "                                     | |");
		System.out.println(spacing + "                                     |_|\n");
		System.out.println(spacing + "-----------------------------------------------------------------------\n");
		System.out.println(spacing + "          [1] Best Selling Categories Sorted by QTY\n");
		System.out.println(spacing + "          [2] Best Selling Categories Sorted by Amount\n");
		System.out.print(spacing + "Enter option : ");

		int option = input.nextInt();
		input.nextLine();

		if (option < 1 || option > 2) {
			goToPage("item-reports");
			return;
		}

		goToPage(pages[option + 12]);
	}
	
	public static void orderReportPage () {
		System.out.println();
		System.out.println(spacing + "     ____          _             _____                       _");
		System.out.println(spacing + "    / __ \\        | |           |  __ \\                     | |");
		System.out.println(spacing + "   | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___");
		System.out.println(spacing + "   | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
		System.out.println(spacing + "   | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
		System.out.println(spacing + "    \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
		System.out.println(spacing + "                                           | |");
		System.out.println(spacing + "                                           |_|\n");
		System.out.println(spacing + "------------------------------------------------------------------------\n");
		System.out.println(spacing + "          [1] All orders\n");
		System.out.println(spacing + "          [2] Orders by Amount\n");
		System.out.print(spacing + "Enter option : ");

		int option = input.nextInt();
		input.nextLine();

		if (option < 1 || option > 2) {
			goToPage("order-reports");
			return;
		}

		goToPage(pages[option + 14]);
	}

	public static void bestCustomersPage () {
		System.out.println();
		System.out.println(spacing + "    ____            _     _____          _____          _");
		System.out.println(spacing + "   |  _ \\          | |   |_   _|        / ____|        | |");
		System.out.println(spacing + "   | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___");
		System.out.println(spacing + "   |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println(spacing + "   | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println(spacing + "   |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\n");
		System.out.println(spacing + "-------------------------------------------------------------------------------------------\n");

		printCustomersReport(true);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("best-customers");
	}

	public static void viewCustomersPage () {
		System.out.println();
		System.out.println(spacing + "   __      ___                  _____          _");
		System.out.println(spacing + "   \\ \\    / (_)                / ____|        | |");
		System.out.println(spacing + "    \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___");
		System.out.println(spacing + "     \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println(spacing + "      \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println(spacing + "       \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\n");
		System.out.println(spacing + "-----------------------------------------------------------------------------------\n");

		printCustomersReport(false);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("best-customers");
	}

	public static void allCustomerReportPage () {
		System.out.println();
		System.out.println(spacing + "             _ _    _____          _                              _____                       _");
		System.out.println(spacing + "       /\\   | | |  / ____|        | |                            |  __ \\                     | |");
		System.out.println(spacing + "      /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_");
		System.out.println(spacing + "     / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
		System.out.println(spacing + "    / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_");
		System.out.println(spacing + "   /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
		System.out.println(spacing + "                                                                            | |");
		System.out.println(spacing + "                                                                            |_|\n");
		System.out.println(spacing + "------------------------------------------------------------------------------------------------------\n");
		
		printAllCustomersReport();
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("best-customers");
	}

	public static void qtySortItemReportPage () {
		System.out.println();
		System.out.println(spacing + "     _____            _           _   ____           ____ _________     __");
		System.out.println(spacing + "    / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /");
		System.out.println(spacing + "   | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ /");
		System.out.println(spacing + "    \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /");
		System.out.println(spacing + "    ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |");
		System.out.println(spacing + "   |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|");
		System.out.println(spacing + "                                             __/ |");
		System.out.println(spacing + "                                            |___/\n");
		System.out.println(spacing + "-----------------------------------------------------------------------------\n");

		printItemReport(true);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("qty-sort-item-report");
	}

	public static void amountSortItemReportPage () {
		System.out.println();
		System.out.println(spacing + "     _____            _           _   ____                                               _");
		System.out.println(spacing + "    / ____|          | |         | | |  _ \\            /\\                               | |");
		System.out.println(spacing + "   | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_");
		System.out.println(spacing + "    \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println(spacing + "    ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_");
		System.out.println(spacing + "   |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println(spacing + "                                             __/ |");
		System.out.println(spacing + "                                            |___/\n");
		System.out.println(spacing + "-------------------------------------------------------------------------------------------------\n");

		printItemReport(false);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("amount-sort-item-report");
	}

	public static void allOrdersPage () {
		System.out.println();
		System.out.println(spacing + "   __      ___                  ____          _");
		System.out.println(spacing + "   \\ \\    / (_)                / __ \\        | |");
		System.out.println(spacing + "    \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___");
		System.out.println(spacing + "     \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
		System.out.println(spacing + "      \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
		System.out.println(spacing + "       \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/\n");
		System.out.println(spacing + "----------------------------------------------------------------\n");

		printOrdersReport(true);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("all-orders");
	}

	public static void ordersByAmountPage () {
		System.out.println();
		System.out.println(spacing + "     ____          _                 ____                                               _");
		System.out.println(spacing + "    / __ \\        | |               |  _ \\            /\\                               | |");
		System.out.println(spacing + "   | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_");
		System.out.println(spacing + "   | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
		System.out.println(spacing + "   | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_");
		System.out.println(spacing + "    \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
		System.out.println(spacing + "                                            __/ |");
		System.out.println(spacing + "                                           |___/\n");
		System.out.println(spacing + "-----------------------------------------------------------------------------------------------\n");

		printOrdersReport(false);
		System.out.print(spacing + "To access the main Menu, please enter 0 : ");

		int option = input.nextInt();
		input.nextLine();

		if (option == 0) {
			goToPage("home");
			return;
		}

		goToPage("orders-by-amount");
	}
}
