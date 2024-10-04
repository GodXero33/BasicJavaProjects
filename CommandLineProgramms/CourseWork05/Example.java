import java.util.Scanner;

class Example {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		int page = 0; // 0 - home page | 1 - decimal | 2 - binary | 3 - octal | 4 - hexadecimal | 5 - roman number | 6 - decimal2roman | 7 - roman2decimal

		MAINLOOP:
		while (true) {
			// Home Page
			if (page == 0) {
				System.out.print("\033\143"); // Clear the Console (https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java)
				System.out.println("\n\n                                        __   ______             __ ");
				System.out.println("                                       |  \\ /      \\           |  \\");
				System.out.println("                                        \\$$|  $$$$$$\\  ______  | $$  _______");
				System.out.println("                                       |  \\| $$   \\$$ |      \\ | $$ /       \\");
				System.out.println("                                       | $$| $$        \\$$$$$$\\| $$|  $$$$$$$");
				System.out.println("                                       | $$| $$   __  /      $$| $$| $$");
				System.out.println("                                       | $$| $$__/  \\|  $$$$$$$| $$| $$_____");
				System.out.println("                                       | $$ \\$$    $$ \\$$    $$| $$ \\$$     \\");
				System.out.println("                                        \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$");
				System.out.println();
				System.out.println("  _   _                       _                        _____                                         _");
				System.out.println(" | \\ | |                     | |                      / ____|                                       | |");
				System.out.println(" |  \\| |  _   _   _ __ ___   | |__     ___   _ __    | |        ___    _ __   __   __   ___   _ __  | |_    ___   _ __");
				System.out.println(" | . ` | | | | | | '_ ` _ \\  | '_ \\   / _ \\ | '__|   | |       / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|");
				System.out.println(" | |\\  | | |_| | | | | | | | | |_) | |  __/ | |      | |____  | (_) | | | | |  \\ v /  |  __/ | |    | |_  |  __/ | |");
				System.out.println(" |_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|       \\_____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|");
				System.out.println("========================================================================================================================");
				System.out.println("\n\n        [01] Decimal Converter");
				System.out.println("        [02] Binary Converter");
				System.out.println("        [03] Octal Converter");
				System.out.println("        [04] Hexadecimal Converter");
				System.out.println("        [05] Roman Number Converter");
				System.out.print("\nEnter Option -> ");
				
				int option = input.nextInt();
				input.nextLine();
				System.out.print("\033\143"); // Clear the Console

				if (option > 0 && option < 6) {
					page = option;
				} else {
					System.out.println("\nInvalid input!");
					break MAINLOOP;
				}
			}
			
			// Decimal Page
			if (page == 1) {
				System.out.println("+------------------------------------------+");
				System.out.println("|            Decimal Converter             |");
				System.out.println("+------------------------------------------+");

				System.out.print("\n\nEnter a Decimal number: ");
				int number = input.nextInt();
				input.nextLine();

				// If the number is positive then do the conversions and print values, otherwise print a warning.
				if (number >= 0) {
					String binary = "";
					String octal = "";
					String hexDecimal =  "";
					int numberCalc = number;

					// Convert decimal to binary by dividing the number by 2 in each iteration until the number becomes 0.
					do {
						binary = numberCalc % 2 + binary;
						numberCalc /= 2;
					} while (numberCalc != 0);

					// Convert decimal to octal by dividing the number by 8 in each iteration until the number becomes 0.
					numberCalc = number;

					do {
						octal = numberCalc % 8 + octal;
						numberCalc /= 8;
					} while (numberCalc != 0);

					// Convert decimal to binary by dividing the number by 16 in each iteration until the number becomes 0.
					// If the remainder of any iteration greater than 9[10-15] convert them to symbols[a-f] and do the concatenation to build the hexadecimal value.
					numberCalc = number;

					do {
						int remainder = numberCalc % 16;
						String remainderStr = remainder == 10 ? "a" : remainder == 11 ? "b" : remainder == 12 ? "c" : remainder == 13 ? "d" : remainder == 14 ? "e" : remainder == 15 ? "f" : remainder + "";
						hexDecimal = remainderStr + hexDecimal;
						numberCalc /= 16;
					} while (numberCalc != 0);

					System.out.println("\n        Binary number: " + binary);
					System.out.println("        Octal number: " + octal);
					System.out.println("        Hexadecimal number: " + hexDecimal);
				} else {
					System.out.println("\n		Invalid input...");
				}

				System.out.print("\n\nDo you want to go to homepage (Y/N)->");
				String homePage = input.nextLine();

				// If user input is yes(Y|y) then change page to home page(0) and continue the main while loop.
				if (homePage.equals("Y") || homePage.equals("y")) {
					page = 0;
					continue;
				} else if (!homePage.equals("N") && !homePage.equals("n")) { // If user input is not no(N|n), then print a warning.
					System.out.println("\nInvalid Input!");
				}

				// If user input is no(N|n) then break the main loop. This will ends the program.
				break MAINLOOP;
			}
			
			// Binary Page
			if (page == 2) {
				System.out.println("+------------------------------------------+");
				System.out.println("|             Binary Converter             |");
				System.out.println("+------------------------------------------+");
				
				System.out.print("\n\nEnter a Binary number: ");
				long number = input.nextLong();
				input.nextLine();
				boolean isValidBinary = true;

				// If the number is positive or zero then check if any digit in number is not 0 or 1, otherwise set isValidBinary flag to false.
				if (number >= 0) {
					long checkNumber = number;

					// Loop until temporary check number becomes 0. Each iteration the check number divided by 10 and get remainder of that divition.
					// If the remainder digit is not 0 or 1 then the number is not a valid binary and the isValidBinary flag is changed to false and break the loop.
					while (checkNumber != 0) {
						long digit = checkNumber % 10;
						checkNumber /= 10;

						if (digit != 0 && digit != 1) {
							isValidBinary = false;
							break;
						}
					}
				} else {
					isValidBinary = false;
				}

				// If the isValidBinary falg is true then do the conversions and print values, otherwise send the warning.
				if (isValidBinary) {
					int decimal = 0;
					String octal = "";
					String hexDecimal =  "";
					long numberCalc = number;

					// Convert binary to decimal.
					// Loop until temporary number boceomes 0.
					// Each iteration the number is divided by 10 and takes the remainder. The remainder on any iteration must be 0 or 1.
					// Increase exp by one on each iteration and add two to the power of exp on each iteration.
					int exp = 0;

					do {
						long digit = numberCalc % 10;
						numberCalc /= 10;
						
						// If the remainder digit is 1 assign the value of two to the power of exp to the digit.
						if (digit == 1) {
							for (int i = 0; i < exp; i++) {
								digit *= 2;
							}
						}

						exp++;
						decimal += digit;
					} while (numberCalc != 0);

					// Convert binary to octal.
					// Loop until temporary number becomes 0.
					// Each iteration the number divided by 1000 to seperate number to partition of three. (1011001101 --> 001011001101 --> 001 | 011 | 001 | 101)
					// Take each partition and convert them to decimal and each partition replace with their decimal values. (001 | 011 | 001 | 101 --> 1 + 3 + 1 + 5 --> 1315)
					numberCalc = number;

					do {
						long digit = numberCalc % 1000;
						numberCalc /= 1000;
						int expTmp = 1;
						int tempDecimal = 0;

						// Convert current partition of three to decimal
						do {
							int tempDigit = (int) digit % 10;

							// If the temporary digit is 1 then takes the power of two acording to the place. (101 --> 1 - 2^2 + (0) + 2^0 --> 4 + 0 + 1 = 5)
							if (tempDigit == 1) {
								// Find the expTmp'th power of two.
								for (int i = 0; i < expTmp - 1; i++) {
									tempDigit *= 2;
								}
							}

							digit /= 10;
							expTmp++;
							tempDecimal += tempDigit;
						} while (digit != 0);
						
						// Replace partition of three with it's decimal value. (The actual octal value)
						octal = tempDecimal + octal;
					} while (numberCalc != 0);

					// Convert binary to hexadecimal.
					// Loop until temporary number becomes 0.
					// Each iteration the number divided by 10000 to seperate number to partition of four. (1011001101 --> 001011001101 --> 0010 | 1100 | 1101)
					// Take each partition and convert them to decimal and each partition replace with their decimal values. (0010 | 1100 | 1101 --> 2 + 12 + 13 --> 2 + C + D --> 2CD)
					numberCalc = number;

					do {
						long digit = numberCalc % 10000;
						numberCalc /= 10000;
						int expTmp = 1;
						int tempDecimal = 0;

						// Convert current partition of three to decimal
						do {
							int tempDigit = (int) (digit % 10);

							// If the temporary digit is 1 then takes the power of two acording to the place. (1101 --> 1 - 2^3 + 2^2 + (0) + 2^0 --> 8 + 4 + 0 + 1 = 13)
							if (tempDigit == 1) {
								// Find the expTmp'th power of two.
								for (int i = 0; i < expTmp - 1; i++) {
									tempDigit *= 2;
								}
							}

							digit /= 10;
							expTmp++;
							tempDecimal += tempDigit;
						} while (digit != 0);
						
						// Replace partition of three with it's hexadecimal value.
						String tempDesimalStr = tempDecimal + "";

						if (tempDecimal > 9) {
							switch (tempDecimal % 10) {
								case 0:
									tempDesimalStr = "A";
									break;
								
								case 1:
									tempDesimalStr = "B";
									break;
								
								case 2:
									tempDesimalStr = "C";
									break;
								
								case 3:
									tempDesimalStr = "D";
									break;
								
								case 4:
									tempDesimalStr = "E";
									break;
								
								default:
									tempDesimalStr = "F";
							}	
						}

						hexDecimal = tempDesimalStr + hexDecimal;
					} while (numberCalc != 0);

					System.out.println("\n        Decimal number: " + decimal);
					System.out.println("        Octal number: " + octal);
					System.out.println("        Hexadecimal number: " + hexDecimal);
				} else {
					System.out.println("\n		Invalid input...");
				}
				
				System.out.print("\n\nDo you want to go to homepage (Y/N)->");
				String homePage = input.nextLine();

				if (homePage.equals("Y") || homePage.equals("y")) {
					page = 0;
					continue;
				} else if (!homePage.equals("N") && !homePage.equals("n")) {
					System.out.println("\nInvalid Input!");
				}
				
				break MAINLOOP;
			}
			
			// Octal Page
			if (page == 3) {
				System.out.println("+------------------------------------------+");
				System.out.println("|              Octal Converter             |");
				System.out.println("+------------------------------------------+");
				
				System.out.print("\n\nEnter an Octal number: ");
				long number = input.nextLong();
				input.nextLine();
				boolean isValidOctal = true;

				// If the number is positive or zero then check if any digit in number is not out of [0 - 7] range, otherwise set isValidOctal flag to false.
				if (number >= 0) {
					long checkNumber = number;

					// Loop until temporary check number becomes 0. Each iteration the check number divided by 10 and get remainder of that divition.
					// If the remainder digit is not a digit between 0-7 then the number is not a valid octal and the isValidOctal flag is changed to false and break the loop.
					while (checkNumber != 0) {
						long digit = checkNumber % 10;
						checkNumber /= 10;

						if (digit > 7) {
							isValidOctal = false;
							break;
						}
					}
				} else {
					isValidOctal = false;
				}

				// If the isValidOctal falg is true then do the conversions and print values, otherwise send the warning.
				if (isValidOctal) {
					long decimal = 0;
					String binary = "";
					String hexDecimal =  "";
					long numberCalc = number;

					// Convert octal to decimal.
					// Loop until temporary number boceomes 0.
					// Each iteration the number is divided by 10 and takes the remainder. The remainder on any iteration must be between 0-7.
					// Increase exp by one on each iteration and add eight to the power of exp on each iteration.
					int exp = 0;

					do {
						long digit = numberCalc % 10;
						numberCalc /= 10;
						
						// If the remainder digit is 1 assign the value of eight to the power of exp to the digit.
						if (digit != 0) {
							for (int i = 0; i < exp; i++) {
								digit *= 8;
							}
						}

						exp++;
						decimal += digit;
					} while (numberCalc != 0);

					// Convert octal to binary.
					// Actualy, because of the decimal already calulated, decimal value can be used to this convertion.
					// Convert converted decimal value to binary.
					long tempDecimal = decimal;

					do {
						int digit = (int) (tempDecimal % 2);
						tempDecimal /= 2;
						binary = digit + binary;
					} while (tempDecimal != 0);

					// Convert octal to hexadecimal.
					// Convert decimal to hexadecimal.
					tempDecimal = decimal;

					do {
						int digit = (int) (tempDecimal % 16);
						tempDecimal /= 16;
						String symbol = digit + "";

						if (digit > 9) {
							switch (digit % 10) {
								case 0:
									symbol = "A";
									break;
								
								case 1:
									symbol = "B";
									break;
								
								case 2:
									symbol = "C";
									break;
								
								case 3:
									symbol = "D";
									break;
								
								case 4:
									symbol = "E";
									break;
								
								default:
									symbol = "F";
							}
						}

						hexDecimal = symbol + hexDecimal;
					} while (tempDecimal != 0);

					System.out.println("\n        Decimal number: " + decimal);
					System.out.println("        Binary number: " + binary);
					System.out.println("        Hexadecimal number: " + hexDecimal);
				} else {
					System.out.println("\n		Invalid input...");
				}
				
				System.out.print("\n\nDo you want to go to homepage (Y/N)->");
				String homePage = input.nextLine();

				if (homePage.equals("Y") || homePage.equals("y")) {
					page = 0;
					continue;
				} else if (!homePage.equals("N") && !homePage.equals("n")) {
					System.out.println("\nInvalid Input!");
				}
				
				break MAINLOOP;
			}
			
			// Hexadecimal Page
			if (page == 4) {
				System.out.println("+------------------------------------------+");
				System.out.println("|           Hexadecimal Converter          |");
				System.out.println("+------------------------------------------+");
				
				System.out.print("\n\nEnter a Hexadecimal number: ");
				String number = input.nextLine();
				boolean isValidHex = true;
				int numLen = number.length();

				// Iterate through number string to check each character value is in the range of hexadecimal [0-1A-F].
				// Cast each charater to integer to take it's ASCII value and check that value is in 0-9 or a-f or A-F.
				// If any value is not fit into any of above range set isValidHex falg to false and break the loop.
				for (int i = 0; i < numLen; i++) {
					int charCode = (int) number.charAt(i);
					boolean isValidChar = false;

					if (
						(charCode > 47 && charCode < 58) || // 0 - 9 ASCII
						(charCode > 96 && charCode < 103) || // a - f ASCII
						(charCode > 64 && charCode < 71) // A - F ASCII
					) {
						isValidChar = true;
					}

					if (!isValidChar) {
						isValidHex = false;
						break;
					}
				}

				// If the isValidHex falg is true then do the conversions and print values, otherwise send the warning.
				if (isValidHex) {
					long decimal = 0;
					String binary = "";
					String octal =  "";

					// Hexadecimal to decimal.
					int exp = 0;

					for (int i = numLen - 1; i >= 0; i--) {
						int charCode = (int) number.charAt(i);
						int powOf16 = 1;

						for (int j = 0; j < exp; j++) {
							powOf16 *= 16;
						}

						exp++;
						int digit = 0;

						if (charCode < 58) { // Case where the symbole is 0-9
							digit = charCode % 48;
						} else { // Case where the symbole is a-fA-F
							if (charCode == 65 || charCode == 97) {
								digit = 10;
							} else if (charCode == 66 || charCode == 98) {
								digit = 11;
							} else if (charCode == 67 || charCode == 99) {
								digit = 12;
							} else if (charCode == 68 || charCode == 100) {
								digit = 13;
							} else if (charCode == 69 || charCode == 101) {
								digit = 14;
							} else {
								digit = 15;
							}
						}

						decimal += digit * powOf16;
					}

					// Convert Hexadecimal to binary.
					// Because of the decimal value is already founded, the decimal value can be used to convert hexadecimal to binary.
					// Convert decimal to binary.
					long tempDecimal = decimal;

					do {
						int digit = (int) (tempDecimal % 2);
						tempDecimal /= 2;
						binary = digit + binary;
					} while (tempDecimal != 0);

					// Convert Hexadecimal to octal.
					// Because of the decimal value is already founded, the decimal value can be used to convert hexadecimal to octal.
					// Convert decimal to octal.
					tempDecimal = decimal;

					do {
						int digit = (int) (tempDecimal % 8);
						tempDecimal /= 8;
						octal = digit + octal;
					} while (tempDecimal != 0);

					System.out.println("\n        Decimal number: " + decimal);
					System.out.println("        Binary number: " + binary);
					System.out.println("        Octal number: " + octal);
				} else {
					System.out.println("\n		Invalid input...");
				}
				
				System.out.print("\n\nDo you want to go to homepage (Y/N)->");
				String homePage = input.nextLine();

				if (homePage.equals("Y") || homePage.equals("y")) {
					page = 0;
					continue;
				} else if (!homePage.equals("N") && !homePage.equals("n")) {
					System.out.println("\nInvalid Input!");
				}
				
				break MAINLOOP;
			}

			// Roman Number Page
			if (page == 5) {
				System.out.println("+------------------------------------------+");
				System.out.println("|           Roman Number Converter         |");
				System.out.println("+------------------------------------------+");
	
				System.out.println("\n\n        [01] Decimal Number to Roman Number Converter");
				System.out.println("        [02] Roman Number to Decimal Number Converter");
				System.out.print("\nEnter Option: ");
				int option = input.nextInt();
				input.nextLine();

				if (option == 1) {
					page = 6;
					System.out.print("\033\143"); // Clear the Console
					continue;
				}

				if (option == 2) {
					page = 7;
					System.out.print("\033\143"); // Clear the Console
					continue;
				}

				System.out.println("\nInvalid Input!");
				break MAINLOOP;
			}
			
			// Decimal to Roman Page
 			if (page == 6) {
				System.out.println("+-------------------------------------------------------------+");
				System.out.println("|           Decimal Number to Roman Number Converter          |");
				System.out.println("+-------------------------------------------------------------+");

				System.out.print("\n\nEnter a Decimal number: ");
				int number = input.nextInt();
				input.nextLine();
				String romanNumber = "";

				// If the decimal number is positive and not 0 then do the conversion and print values, otherwise print a warning.
				if (number > 0) {
					// Take only the part that below 10^3 place and count how many thousands are in the number
					int tempNumber = number % 1000;
					int thousends = number / 1000;
					int count = 0;

					// Loop until tempnumber becomes 0.
					// Each iterate the number is divided by 10 to get last digit.
					// Each iterate increase count by to keep track witch 10th power is the current iterate in.
					// According to the last digit and count a new roman value is added at the start to the romanNumber.
					do {
						int remainder = tempNumber % 10;
						tempNumber /= 10;
						String digit = "";

						if (count == 0) {
							if (remainder > 0 && remainder < 4) {
								for (int i = 0; i < remainder; i++) {
									digit += "I";
								}
							} else if (remainder == 4) {
								digit = "IV";
							} else if (remainder > 4 && remainder < 9) {
								digit += "V";

								for (int i = 0; i < remainder % 5; i++) {
									digit += "I";
								}
							} else if (remainder == 9) {
								digit = "IX";
							}
						} else if (count == 1) {
							if (remainder < 4) {
								for (int i = 0; i < remainder; i++) {
									digit += "X";
								}
							} else if (remainder == 4) {
								digit = "XL";
							} else if (remainder > 4 && remainder < 9) {
								digit += "L";

								for (int i = 0; i < remainder % 5; i++) {
									digit += "X";
								}
							} else if (remainder == 9) {
								digit = "XC";
							}
						} else {
							if (remainder < 4) {
								for (int i = 0; i < remainder; i++) {
									digit += "C";
								}
							} else if (remainder == 4) {
								digit = "CD";
							} else if (remainder > 4 && remainder < 9) {
								digit += "D";

								for (int i = 0; i < remainder % 5; i++) {
									digit += "C";
								}
							} else if (remainder == 9) {
								digit = "CM";
							}
						}

						count++;
						romanNumber = digit + romanNumber;
					} while (tempNumber != 0);

					// Create Thousands roman number by repeating 'M' by the times of thousends variable value and add it at the start of the roman number string.
					if (thousends != 0) {
						String thousendsStr = "";
						
						for (int i = 0; i < thousends; i++) {
							thousendsStr += "M";
						}

						romanNumber = thousendsStr + romanNumber;
					}

					System.out.println("        Roman numeral: " + romanNumber);
				} else {
					System.out.println("\nInvalid Input!");
				}

				System.out.print("\n\nDo you want to go to homepage (Y/N)->");
				String homePage = input.nextLine();

				if (homePage.equals("Y") || homePage.equals("y")) {
					page = 0;
					continue;
				} else if (!homePage.equals("N") && !homePage.equals("n")) {
					System.out.println("\nInvalid Input!");
				}

				break MAINLOOP;
			}

			// Roman to Decimal Page

			System.out.println("+-------------------------------------------------------------+");
			System.out.println("|           Roman Number to Decimal Number Converter          |");
			System.out.println("+-------------------------------------------------------------+");

			System.out.print("\n\nEnter a Roman number: ");
			String romanNumber = input.nextLine();
			int decimal = 0;
			boolean isValidRoman = true;

			// Loop through the number string and if any character of string is not equlas to roman digit (I,V,X,L,V,C,D,M) set isValidRoman flag to false.
			for (int i = 0; i < romanNumber.length(); i++) {
				char symbol = romanNumber.charAt(i);

				if (
					symbol != 'I' &&
					symbol != 'V' &&
					symbol != 'X' &&
					symbol != 'L' &&
					symbol != 'C' &&
					symbol != 'D' &&
					symbol != 'M' &&
					symbol != 'i' &&
					symbol != 'v' &&
					symbol != 'x' &&
					symbol != 'l' &&
					symbol != 'c' &&
					symbol != 'd' &&
					symbol != 'm'
				) {
					isValidRoman = false;
					break;
				}
			}

			// If isValidRoman flag is true do the convertion and print, otherwise print a warning.
			if (isValidRoman) {
				// Loop through every character in romanNumber and add perticuler value to decimal in each iteration.
				// To check cases like (iv --> 4 --> 5 - 1), every loop keep track the next character of the romanNumber usign 'next' variable.
				for (int i = 0; i < romanNumber.length(); i++) {
					int current = 0;
					int next = 0;
					char symbolCurrent = romanNumber.charAt(i);

					switch (symbolCurrent) {
						case 'i':
						case 'I':
							current = 1;
							break;

						case 'v':
						case 'V':
							current = 5;
							break;

						case 'x':
						case 'X':
							current = 10;
							break;

						case 'l':
						case 'L':
							current = 50;
							break;

						case 'c':
						case 'C':
							current = 100;
							break;

						case 'd':
						case 'D':
							current = 500;
							break;

						default:
							current = 1000;
					}

					// Cases the next character only valid. Means the last iteration has no next. So it can't be done as normal.
					if (i < romanNumber.length() - 1) {
						char symbolNxt = romanNumber.charAt(i + 1);
						
						switch (symbolNxt) {
							case 'i':
							case 'I':
								next = 1;
								break;
	
							case 'v':
							case 'V':
								next = 5;
								break;
	
							case 'x':
							case 'X':
								next = 10;
								break;
	
							case 'l':
							case 'L':
								next = 50;
								break;
	
							case 'c':
							case 'C':
								next = 100;
								break;
	
							case 'd':
							case 'D':
								next = 500;
								break;
	
							default:
								next = 1000;
						}

						// If next is greater than current (v is greater than i in iv) then get the different of both (5 - 1 = 4 (this is the actual value)) and add it to the decimal. Because of this process counted two symbols i manualy increase by one in here too.
						// Otherwise, just simply add current value to the decimal. 
						if (next > current) {
							decimal += next - current;
							i++;
						} else {
							decimal += current;
						}
					} else { // If there is no next value then add current to the decimal.
						decimal += current;
					}
				}

				System.out.println("        Decimal number: " + decimal);
			} else {
				System.out.println("\nInvalid Input!");
			}

			System.out.print("\n\nDo you want to go to homepage (Y/N)->");
			String homePage = input.nextLine();

			if (homePage.equals("Y") || homePage.equals("y")) {
				page = 0;
				continue;
			} else if (!homePage.equals("N") && !homePage.equals("n")) {
				System.out.println("\nInvalid Input!");
			}

			break; // MAINLOOP
		}
	}
}
