import java.util.Scanner;

class Example {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		clearConsole();
		int page = mainPage(input);
		
		while (page != -1) {
			page = openPage(page, input);
		}

		endPage();
		System.exit(0);
	}

	/*

	pages
		-1 - |--> end page
		 0 - |--> main page

		0 - main page
			1 -  |--> withholding page
			2 -  |--> payable page
			3 -  |--> income page
			4 -  |--> sscl page
			5 -  |--> leasing page

			1 - withholding page
				6  - |--> rent page
				7  - |--> bank interest page
				8  - |--> dividend page

			5 - leasing page
				9  - |--> monthly installment page
				10 - |--> search leasing category page
				11 - |--> leasing amount find page

	*/
	public static int openPage (int page, Scanner input) {
		clearConsole();

		switch (page) {
			case 0:
				page = mainPage(input);
				break;

			case 1:
				page = withholdingPage(input);
				break;
			
			case 2:
				page = payablePage(input);
				break;
			
			case 3:
				page = incomePage(input);
				break;
			
			case 4:
				page = ssclPage(input);
				break;
			
			case 5:
				page = leasingPage(input);
				break;
			
			case 6:
				page = rentPage(input);
				break;
			
			case 7:
				page = bankInterestPage(input);
				break;

			case 8:
				page = dividendPage(input);
				break;

			case 9:
				page = monthlyInstallmentPage(input);
				break;
			
			case 10:
				page = searchLeasingCatPage(input);
				break;

			case 11:
				page = leasingAmountFindPage(input);
		}

		return page;
	}

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

	public static double fixedToTwoDecimal (double value) {
		// 2.354 --> round (2.354 * 100) --> round 235.4 --> 235 --> 235 / 100 --> 2.35
		// Cast Math.round to double because Math.round returns a long value.
		return (double) Math.round(value * 100) / 100;
	}

	public static double getPositiveDouble (Scanner input) {
		double value = input.nextDouble();
		input.nextLine();

		if (value < 0) {
			System.out.println("\n          Invalid input...");
			System.out.print("\n\nDo you want to enter the correct value again (Y/N): ");

			char response = input.nextLine().charAt(0);

			if (response == 'y' || response == 'Y') {
				return -1; // When user wants to re-enter value.
			}
			
			return -2; // When user wants to go to home page.
		}

		return value;
	}

	public static int mainPage (Scanner input) {
		System.out.println("\n                              __   ______   ________  ________");
		System.out.println("                             |  \\ /      \\ |        \\|        \\");
		System.out.println("                              \\$$|  $$$$$$\\| $$$$$$$$ \\$$$$$$$$");
		System.out.println("                             |  \\| $$   \\$$| $$__       | $$");
		System.out.println("                             | $$| $$      | $$  \\      | $$");
		System.out.println("                             | $$| $$   __ | $$$$$      | $$");
		System.out.println("                             | $$| $$__/  \\| $$_____    | $$");
		System.out.println("                             | $$ \\$$    $$| $$     \\   | $$");
		System.out.println("                              \\$$  \\$$$$$$  \\$$$$$$$$    \\$$");
		System.out.println("\n\n      _____  _   __  __   ____    _    _     ____ _   _ _        _  _____ ___  ____");
		System.out.println("     |_   _|/ \\  \\ \\/ /  / ___|  / \\  | |   / ___| | | | |      / \\|_   _/ _ \\|  _ \\");
		System.out.println("       | | / _ \\  \\  /  | |     / _ \\ | |  | |   | | | | |     / _ \\ | || | | | |_) |");
		System.out.println("       | |/ ___ \\ /  \\  | |___ / ___ \\| |__| |___| |_| | |___ / ___ \\| || |_| |  _ <");
		System.out.println("       |_/_/   \\_/_/\\_\\  \\____/_/   \\_|_____\\____|\\___/|_____/_/   \\_|_| \\___/|_| \\_\\");
		System.out.println("\n\n===========================================================================================");
		System.out.println("\n\n          [1] Withholding Tax");
		System.out.println("          [2] Payable Tax");
		System.out.println("          [3] Income Tax");
		System.out.println("          [4] Social Security Contrbution (SSCL) Tax");
		System.out.println("          [5] Leasing Tax");
		System.out.println("          [6] Exit");
		System.out.print("\nEnter an option to continue -> ");

		int option = input.nextInt();
		input.nextLine();

		if (option > 0 && option < 6) return option; // Go to the selected page.
		
		if (option != 6) {
			System.out.println("Invalid Input!");
		}

		return -1; // Go to the end page.
	}

	public static int rentPage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |                  RENT TAX                   |");
		System.out.println(" +---------------------------------------------+");
		System.out.print("\n\n  Enter your rent          : ");

		double rent = getPositiveDouble(input);
		System.out.println("Fuck " + rent);

		if (rent == -1) return 6; // Return to the rent page.
		if (rent == -2) return 0; // Go to the main page.

		if (rent >= 100000) {
			System.out.println("\n  You have to pay Rent Tax : " + ((rent - 100000) * 0.1));
		} else {
			System.out.println("\n          You don\'t have to pay Rent Tax...");
		}

		System.out.print("\n\nDo you want to calculate another Rent Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 6; // Return to the rent page.
		
		return 0; // Go to the main page.
	}

	public static int bankInterestPage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |              BANK INTEREST TAX              |");
		System.out.println(" +---------------------------------------------+");
		System.out.print("\n\n  Enter your bank interest per year          : ");

		double bankInterest = getPositiveDouble(input);

		if (bankInterest == -1) return 7; // Return to the bank interest page.
		if (bankInterest == -2) return 0; // Go to the main page.

		System.out.println("\n\n  You have to pay Bank Interest Tax per year : " + (bankInterest * 0.05));
		System.out.print("\n\nDo you want to calculate another Bank Interest Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 7; // Return to the bank interest page.
		
		return 0; // Go to the main page.
	}

	public static int dividendPage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |                DIVIDEND TAX                 |");
		System.out.println(" +---------------------------------------------+");
		System.out.print("\n\n  Enter your total dividend per year    : ");

		double dividend = getPositiveDouble(input);

		if (dividend == -1) return 8; // Return to the dividend page.
		if (dividend == -2) return 0; // Go to the main page.

		if (dividend >= 100000) {
			System.out.println("\n\n  You have to pay Dividend Tax per year : " + ((dividend - 100000) * 0.14));
		} else {
			System.out.println("\n          You don\'t have to pay Dividend Tax...");
		}

		System.out.print("\n\nDo you want to calculate another Dividend Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 8; // Return to the dividend page.
		
		return 0; // Go to the main page.
	}

	public static int withholdingPage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |               WITHHOLDING TAX               |");
		System.out.println(" +---------------------------------------------+");
		System.out.println("\n\n          [1] Rent Tax");
		System.out.println("          [2] Bank Interest Tax");
		System.out.println("          [3] Dividend Tax");
		System.out.println("          [4] Exit");
		System.out.print("\nEnter an option to continue -> ");

		int option = input.nextInt();
		input.nextLine();

		if (option > 0 && option < 4) return option + 5; // Go to the selected page.
		if (option == 4) return 0; // Go to the main page.

		System.out.println("Invalid Input!");
		return -1; // Go to the end page.
	}

	// I haven't run the many test cases. But all seven tests returned the correct answer. The test class commented at the end of the code.
	public static double findPayableTax (double payment) {
		// If payment below 100000, means no tax.
		if (payment < 100000) return 0;

		double over35 = 0;
		
		// If payment is greater than 350000, witch means no divition of 41667 coming up. So simply get the different of payemnt and 350000 and set 36% tax to it and remove different from the payment for the rest of calculation.
		if (payment > 350000) {
			double over35Val = payment - 350000;
			over35 = over35Val * 0.36;
			payment -= over35Val;
		}

		payment -= 100000; // Remove first 100000 from the payment.
		double remaining = payment % 41667; // Take end most remainder that comes when payemnt divided by 41667.
		payment -= remaining;
		int count = (int) (payment / 41667); // Take that how much 41667 parts for remaining payment.
		double rate = 0.06;
		double tax = 0;

		// Add 41667 * TaxRate and increas tax rate by 0.06 in each iteration.
		for (int i = 0; i < count; i++) {
			tax += 41667 * rate;
			rate += 0.06;
		}

		// Calculate and return final tax.
		return fixedToTwoDecimal(tax + remaining * rate + over35);
	}

	public static int payablePage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |                 PAYABLE TAX                 |");
		System.out.println(" +---------------------------------------------+");
		System.out.print("\n  Enter your employee payment per month : ");

		double payment = getPositiveDouble(input);

		if (payment == -1) return 2; // Return to the payable page.
		if (payment == -2) return 0; // Go to the main page.

		if (payment >= 100000) {
			System.out.print("\n  You have to pay Payable Tax per month : " + findPayableTax(payment));
		} else {
			System.out.print("\n          You don\'t have to pay Payable Tax...");
		}
		
		System.out.print("\n\nDo you want to calculate another Payable Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 2; // Return to the payable page.
		
		return 0; // Go to the main page.
	}

	// Same logic from payable tax finder. (findPayableTax)
	public static double findIncomeTax (double payment) {
		if (payment < 1200000) return 0;

		double over35 = 0;

		if (payment > 3700000) {
			double over35Val = payment - 3700000;
			over35 = over35Val * 0.36;
			payment -= over35Val;
		}

		payment -= 1200000;
		double remaining = payment % 500000;
		payment -= remaining;
		int count = (int) (payment / 500000);
		double rate = 0.06;
		double tax = 0;

		for (int i = 0; i < count; i++) {
			tax += 500000 * rate;
			rate += 0.06;
		}

		return tax + remaining * rate + over35;
	}

	public static int incomePage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |                 INCOME TAX                  |");
		System.out.println(" +---------------------------------------------+");
		System.out.print("\n  Enter your total income per year : ");

		double payment = getPositiveDouble(input);

		if (payment == -1) return 3; // Return to the income page.
		if (payment == -2) return 0; // Go to the main page.

		if (payment >= 100000) {
			System.out.print("\n  You have to pay Income Tax per year : " + findIncomeTax(payment));
		} else {
			System.out.print("\n          You don\'t have to pay Income Tax...");
		}
		
		System.out.print("\n\nDo you want to calculate another Income Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 3; // Return to the income page.
		
		return 0; // Go to the main page.
	}

	public static double findSSCLTax (double value) {
		double saleTax = value * 0.025;
		double vat = value * 1.025 * 0.15;
		return saleTax + vat;
	}

	public static int ssclPage (Scanner input) {
		System.out.println("\n +-------------------------------------------------------------------------+");
		System.out.println(" |                 SOCIAL SECURITY CONTRIBUTION (SSCL) TAX                 |");
		System.out.println(" +-------------------------------------------------------------------------+");
		System.out.print("\n  Enter value of Good or Service : ");

		double value = getPositiveDouble(input);

		if (value == -1) return 4; // Return to the sscl page.
		if (value == -2) return 0; // Go to the main page.
		
		System.out.print("\n  You have to pay SSCL Tax : " + fixedToTwoDecimal(findSSCLTax(value)));
		System.out.print("\n\nDo you want to calculate another SSCL Tax (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 4; // Return to the sscl page.

		return 0; // Go to the main page.
	}

	public static double getAnnualInterestRate (Scanner input) {
		System.out.print("\n  Enter anual interest rate : ");
		double rate = input.nextDouble();
		input.nextLine();

		if (rate < 0) {
			System.out.print("\n          Invalid input... Enter the correct value again...\n");
			return getAnnualInterestRate(input);
		}

		return rate;
	}

	public static int getYearsCount (Scanner input) {
		System.out.print("\n  Enter number of year      : ");
		int year = input.nextInt();
		input.nextLine();

		if (year < 0 || year > 5) {
			System.out.print("\n          Invalid no of year... Enter the correct value again...\n");
			return getYearsCount(input);
		}

		return year;
	}

	public static double findMonthlyInstallment (double leaseAmount, double interestRate, int years) {
		interestRate /= 1200; // First convert percentage to decimal --> interestRate / 100. Then divid it by 12 because equation use i / 12. (1 / 1200 = 1 / 12 * 1 / 100).
		return fixedToTwoDecimal(leaseAmount * interestRate / (1 - (1 / Math.pow(interestRate + 1, years * 12))));
	}

	public static int monthlyInstallmentPage (Scanner input) {
		System.out.println("\n +-------------------------------------------------------+");
		System.out.println(" |               CALCULATE LEASING PAYMENT               |");
		System.out.println(" +-------------------------------------------------------+");

		System.out.print("\n  Enter lease amount        : ");
		double leaseAmount = getPositiveDouble(input);

		if (leaseAmount == -1) return 9; // Return to the monthly interest page.
		if (leaseAmount == -2) return 0; // Go to the main page.

		double interestRate = getAnnualInterestRate(input);
		int years = getYearsCount(input);

		System.out.print("\n  Your monthly instalment   : " + findMonthlyInstallment(leaseAmount, interestRate, years));
		System.out.print("\n\nDo you want to calculate another monthly instalment (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 9; // Return to the monthly interest page.
		
		return 0; // Go to the main page.
	}

	public static int searchLeasingCatPage (Scanner input) {
		System.out.println("\n +-----------------------------------------------------+");
		System.out.println(" |               SEARCH LEASING CATEGORY               |");
		System.out.println(" +-----------------------------------------------------+");

		System.out.print("\n  Enter lease amount        : ");
		double leaseAmount = getPositiveDouble(input);

		if (leaseAmount == -1) return 10; // Return to the leasing category page.
		if (leaseAmount == -2) return 0; // Go to the main page.

		double interestRate = getAnnualInterestRate(input);

		System.out.println("\n  Your monthly instalment for 3 year leasing plan - " + findMonthlyInstallment(leaseAmount, interestRate, 3));
		System.out.println("  Your monthly instalment for 4 year leasing plan - " + findMonthlyInstallment(leaseAmount, interestRate, 4));
		System.out.print("  Your monthly instalment for 5 year leasing plan - " + findMonthlyInstallment(leaseAmount, interestRate, 5));
		System.out.print("\n\nDo you want to calculate another Leasing Category (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 10; // Return to the leasing category page.
		
		return 0; // Go to the main page.
	}

	public static double findLeaseAmoundByAffordablePayment (double affordablePayment, double interestRate, int years) {
		interestRate /= 1200;
		return fixedToTwoDecimal(affordablePayment * (1 - (1 / Math.pow(interestRate + 1, years * 12))) / interestRate);
	}

	public static int leasingAmountFindPage (Scanner input) {
		System.out.println("\n +-------------------------------------------------+");
		System.out.println(" |               FIND LEASING AMOUNT               |");
		System.out.println(" +-------------------------------------------------+");

		System.out.print("\n  Enter the monthly lease payment\n  amount you can afford : ");

		double affordablePayment = getPositiveDouble(input);

		if (affordablePayment == -1) return 11; // Return to the leasing amount page.
		if (affordablePayment == -2) return 0; // Go to the main page.

		int years = getYearsCount(input);
		double interestRate = getAnnualInterestRate(input);

		System.out.print("\n  Youcan get Lease Amount   : " + findLeaseAmoundByAffordablePayment(affordablePayment, interestRate, years));
		System.out.print("\n\nDo you want to calculate another Leasing Category (Y/N): ");

		char response = input.nextLine().charAt(0);

		if (response == 'y' || response == 'Y') return 11; // Return to the leasing amount page.
		
		return 0; // Go to the main page.
	}

	public static int leasingPage (Scanner input) {
		System.out.println("\n +---------------------------------------------+");
		System.out.println(" |               LEASING PAYMENT               |");
		System.out.println(" +---------------------------------------------+");
		System.out.println("\n\n          [1] Calculate Monthly Installment");
		System.out.println("          [2] Search Leasing Category");
		System.out.println("          [3] Find Leasing Amount");
		System.out.println("          [4] Exit");
		System.out.print("\nEnter an option to continue -> ");

		int option = input.nextInt();
		input.nextLine();

		if (option > 0 && option < 4) return option + 8; // Go to the selected page.
		if (option == 4) return 0; // Go to the main page.

		System.out.println("Invalid Input!");
		return -1; // Go to the end page.
	}

	public static void endPage () {
		System.out.println("\n\n      _______  __      __  ________");
		System.out.println("     |       \\|  \\    /  \\|        \\");
		System.out.println("     | $$$$$$$\\\\$$\\  /  $$| $$$$$$$$");
		System.out.println("     | $$__/ $$ \\$$\\/  $$ | $$__");
		System.out.println("     | $$    $$  \\$$  $$  | $$  \\");
		System.out.println("     | $$$$$$$\\   \\$$$$   | $$$$$");
		System.out.println("     | $$__/ $$   | $$    | $$_____");
		System.out.println("     | $$    $$   | $$    | $$     \\");
		System.out.println("      \\$$$$$$$     \\$$     \\$$$$$$$$\n\n");
	}
}



/*
 * The test class that I wrote for the 'findPayableTax' method.

class Example {
	public static double findPayableTax (double payment) {
		if (payment < 100000) return 0;

		double over35 = 0;
		
		if (payment > 350000) {
			double over35Val = payment - 350000;
			over35 = over35Val * 0.36;
			payment -= over35Val;
		}

		payment -= 100000;
		double remaining = payment % 41667;
		payment -= remaining;
		int count = (int) (payment / 41667);
		double rate = 0.06;
		double tax = 0;

		System.out.println("payment " + payment);
		System.out.println("remaining " + remaining);
		System.out.println("count " + count);
		System.out.println("over35 " + over35);

		for (int i = 0; i < count; i++) {
			tax += 41667 * rate;
			rate += 0.06;
		}

		tax += remaining * rate + over35;
		return tax;
	}

	public static void printTax (double payment) {
		double tax = findPayableTax(payment);
		System.out.println(payment + " --> " + tax + '\n');
	}

	public static void main (String args[]) {
		printTax(100001);
		printTax(141667);
		printTax(141668);
		printTax(183333);
		printTax(225000);
		printTax(350000);
		printTax(450000);
	}
}


*/
