/*
 * Andrei Cojocaru
 * Prof James Mwangi
 * 8132 Object-Oriented Programming
 * Section 311
 */
import java.util.Scanner;

/**
 * Utility class to read integer input from user
 */
public class NumberReader {

    /**
     * Static method to read input from user, recursively runs until valid value given
     * @param scanner the scanner to intake user input
     * @return the valid input
     */
    public static int readInt(Scanner scanner) {
        // holder variable
        int out;
        // try to intake value, if not number or outside accepted range, throw error
        try {
            out = Integer.parseInt(scanner.nextLine());
            if (out < 1 || out > 7) throw new NumberFormatException();
        // if error is thrown from try, inform user and rerun
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid input, please try again: ");
            return readInt(scanner);
        }
        return out;
    }
}
