import java.util.Scanner;

/**
 * Utility class to parse through user input and return valid input
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */
public class InputSearches {

    /**
     * Method to get a valid int input
     * @param sc scanner to read input
     * @return valid int output
     */
    public static int readInt(Scanner sc) {
        String in = sc.nextLine();
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e) {
            System.out.println("Oops! that was not a valid input, please try again");
            return readInt(sc);
        }
    }

    /**
     * Method to return a valid character which is a member of the alphabet, upper or lower case
     * @param sc scanner to read input
     * @return character or recursive call
     */
    public static char readChar(Scanner sc) {
        String in = sc.nextLine();
        // if input is more than 1 character, is immediately an invalid input
        if (in.length() > 1) {
            // inform user and recursively call
            System.out.println("Oops! that was not a valid input, please try again");
            return readChar(sc);
        }
        // get char version of input
        char temp = in.charAt(0);
        // check if character is within the bounds of either the larger case or lower case set
        if ((temp >= 65 && temp <= 90) || (temp >= 97 && temp <= 122)) {
            // if is in sets then return valid input
            return temp;
        }
        // else inform user and try again
        System.out.println("Oops! that was not a valid input, please try again");
        return readChar(sc);
    }
}
