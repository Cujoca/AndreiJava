import java.io.IOException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
 */
public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		boolean keepGoing = true;
		Scanner sc = new Scanner(System.in);
		Numbers numbers = new Numbers();

		String menu = """
				Please select an option:
				1. Initialize a default array
				2. Specify max size of array
				3. Add value to array
				4. Display array
				5. Display average, max, min, the max modulus of min, and the factorial of the max
				6. Enter multiple values
				7. Read values from a file
				8. Write values to a file
				9. exit""";
		while (keepGoing) {
			System.out.println(menu);
			int choice = getInt(sc);
			switch (choice) {
				case 1:
					numbers = new Numbers();
					System.out.println("new array with default size of 10 has been created.");
					break;
				case 2:
					System.out.println("Please enter size of new array: ");
					int temp = getInt(sc);
					if (temp <= 0) {
						System.out.println("Invalid value for size");
						break;
					}
					numbers = new Numbers(temp);
					System.out.println("new array with size of " + temp + " has been created.");
					break;
				case 3:
					System.out.println("Please enter the value you'd like to add: ");
					numbers.getValue(sc);
					System.out.println("number has been added to array");
					break;
				case 4:
					System.out.println(numbers.toString());
					break;
				case 5:
					Float[] tempArr = numbers.maxMinMod();
					if (tempArr == null) {
						System.out.println("Oops! something went wrong.");
						break;
					}
					float maxfac = numbers.maxFac();
					boolean goodFac = true;
					if (maxfac < 1) {
						goodFac = false;
					}
					System.out.print("Max = " + tempArr[0] +
							" Min = " + tempArr[1] + " Average = " + numbers.calcAverage() + " Mod = " + tempArr[2]);
					if (goodFac) { System.out.println(" Max Factorial = " + maxfac + "."); }
					else System.out.println(" Oops! there was a problem with the factorial.");
					break;
				case 6:
					System.out.print("How many numbers would you like to add? ");
					int add = getInt(sc);
					System.out.println();
					if (add > numbers.spacesLeft()) {
						System.out.println("Your array isn't big enough!");
						break;
					}
					for (int i = 0; i < add; i++) {
						System.out.print("Enter an number: ");
						numbers.getValue(sc);
						System.out.println();
					}
					break;
				case 7:
					System.out.print("What file would you like to read from? ");
					String fileName = sc.nextLine();
					numbers.readFile(fileName);
					break;
				case 8:
					System.out.print("What file would you like to write to?");
					String fileWrite = sc.nextLine();
					numbers.writeFile(fileWrite);
					break;
				case 9:
					keepGoing = false;
					break;
				default:
					System.out.println("Invalid option.");
			}
		}
		System.out.println("Thank you for using Lab 1!");
	}
	/**
	 * Method to get a valid int input for menu
	 * @return valid int input
	 */
	private static int getInt(Scanner sc) {
		int out = -1;
		try {
			out = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid choice");
		}
		return out;
	}
}
