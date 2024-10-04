import java.util.*;

class Example {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|                         SALARY INFORMATION SYSTEM                            |");
		System.out.println("--------------------------------------------------------------------------------");

		System.out.println("\n        [1] Calculate Income Tax");
		System.out.println("        [2] Calculate Annual Bonus");
		System.out.println("        [3] Calculate Loan amount");

		System.out.print("\nEnter an option to continue > ");
		int userOption = input.nextInt();
		input.nextLine();

		if (userOption == 1) { // Calculate Income Tax
			System.out.println("\n--------------------------------------------------------------------------------");
			System.out.println("|                            Calculate Income Tax                              |");
			System.out.println("--------------------------------------------------------------------------------");

			System.out.print("\nInput Employee name\t - ");
			String name = input.nextLine();
			
			System.out.print("Input Employee salary\t - ");
			double salary = input.nextDouble();

			double tax = 0;

			if (salary < 100000) {
				tax = 0;
			} else if (salary < 141667) {
				tax = (salary - 100000) * 0.06;
			} else if (salary < 183333) {
				tax = (salary - 141667) * 0.12 + 41667 * 0.06;
			} else if (salary < 225000) {
				tax = (salary - 141666) * 0.18; // tax = (salary - 183333) * 0.18 + 41667 * (0.06 + 0.12);
			} else if (salary < 266667) {
				tax = (salary - 225000) * 0.24 + 41667 * 0.36; // tax = (salary - 225000) * 0.24 + 41667 * (0.06 + 0.12 + 0.18)
			} else if (salary < 308333) {
				tax = (salary - 266667) * 0.3 + 41667 * 0.6; // tax = (salary - 266667) * 0.3 + 41667 * (0.06 + 0.12 + 0.18 + 0.24)
			} else {
				tax = (salary - 308333) * 0.36 + 41667 * 0.9; // tax = (salary - 308333) * 0.36 + 41667 * (0.06 + 0.12 + 0.18 + 0.24 + 0.3)
			}

			System.out.println("\nYou have to pay Income Tax per month: " + tax);
		} else if (userOption == 2) { // Calculate Annual Bonus
			System.out.println("\n--------------------------------------------------------------------------------");
			System.out.println("|                          Calculate Annual Bonus                              |");
			System.out.println("--------------------------------------------------------------------------------");

			System.out.print("\nInput Employee name\t - ");
			String name = input.nextLine();
			
			System.out.print("Input Employee salary\t - ");
			double salary = input.nextDouble();

			double bonus = 0;

			if (salary < 100000) {
				bonus = 5000;
			} else if (salary < 200000) {
				bonus = salary * 0.1;
			} else if (salary < 300000) {
				bonus = salary * 0.15;
			} else if (salary < 400000) {
				bonus = salary * 0.2;
			} else {
				bonus = salary * 0.35;
			}

			System.out.println("\nAnnual Bonus\t- " + bonus);
		} else if (userOption == 3) {
			System.out.println("\n--------------------------------------------------------------------------------");
			System.out.println("|                           Calculate Loan amount                              |");
			System.out.println("--------------------------------------------------------------------------------");

			System.out.print("\nInput Employee name\t - ");
			String name = input.nextLine();
			
			System.out.print("Input Employee salary\t - ");
			double salary = input.nextDouble();

			System.out.print("Enter number of year : ");
			int years = input.nextInt();

			if (years > 5) {
				System.out.println("\nYou can only have a loan for up to 5 years. The loan will be showed for 5 years.");
				years = 5;
			}

			if (salary >= 50000) {
				double monthlyInstallment = salary * 0.6;
				double interestRate = 0.15;
				int noOfMonths = years * 12;
				
				double loanAmount = monthlyInstallment * (1 - (1 / Math.pow(1 + (interestRate / 12), noOfMonths))) / (interestRate / 12);
				
				int roundedLoan = (int) (loanAmount / 1000) * 1000;
				// int roundedLoan = (int) Math.floor(loanAmount / 1000) * 1000;
				System.out.println("\nYou can get Loan Amount : " + roundedLoan);
			} else {
				System.out.println("\n\t\tYou can not get a loan because your salary less than Rs.50 000...");
			}
		} else {
			System.out.println("Wrong choise");
		}
	}
}
