import java.util.Scanner;

/**
 * Driver for the Searches class
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 *
 */
public class SearchesDriver {
    /**
     * Main method to execute code
     * @param args args from command line
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Searches arr = new Searches();
        boolean keepGoing = true;

        while (keepGoing) {
            // print options
            System.out.println("""
                    \n
                    Select option in the menu
                    1. Initialize and populate an array of 32 characters
                    2. Perform recursive binary and linear search
                    3. Perform imperative binary and linear search
                    4. Exit""");

            // get choice from user
            int option = InputSearches.readInt(sc);

            switch (option) {
                case 1: // populate array
                    // call populator method
                    arr.generateArray();
                    break;

                case 2: // perform recursive searches
                    // check if array has been populated, if not then inform user and restart
                    if (arr.arrLength() <= 0) {
                        System.out.println("Empty array");
                        break;
                    }
                    System.out.print("Enter a character you'd like to search for: ");
                    char searchRec = InputSearches.readChar(sc);

                    // take time in nanoseconds before search
                    long nanoRec = System.nanoTime();
                    // perform binary search
                    int indexRec = arr.binaryRecursive(searchRec, 0, 31);
                    // take time after search and calculate time in milliseconds
                    nanoRec = System.nanoTime() - nanoRec;
                    long milliRec = nanoRec/1000000;

                    System.out.println("Binary results: ");
                    // if index is -1 (<0) then means character was not found
                    if (indexRec < 0) {System.out.println("The character " + searchRec + " was not found");}
                    // else means character has been found
                    else {System.out.println("The character " + searchRec + " was found at index " + indexRec);}
                    // show user how long it took
                    System.out.println("Time taken: " + nanoRec + "ns (" + milliRec + "ms)");

                    // take time in nanoseconds before search
                    nanoRec = System.nanoTime();
                    // perform linear search
                    indexRec = arr.linearRecursive(searchRec, 0);
                    // take time after search and calculate time in milliseconds
                    nanoRec = System.nanoTime() - nanoRec;
                    milliRec = nanoRec/1000000;

                    System.out.println("\nLinear results: ");
                    // if index is -1 (<0) then means character was not found
                    if (indexRec < 0) {System.out.println("The character " + searchRec + " was not found");}
                    // else means character has been found
                    else {System.out.println("The character " + searchRec + " was found at index " + indexRec);}
                    // show user how long it took
                    System.out.println("Time taken: " + nanoRec + "ns (" + milliRec + "ms)");
                    break;

                case 3: // perform imperative sorts

                    // check if array has been populated, if not then inform user and restart
                    if (arr.arrLength() <= 0) {
                        System.out.println("Empty array");
                        break;
                    }

                    System.out.print("Enter a character you'd like to search for: ");
                    char searchImp = InputSearches.readChar(sc);

                    // take time in nanoseconds before search
                    long nanoImp = System.nanoTime();
                    // perform binary search
                    int indexImp = arr.binaryImperative(searchImp);
                    // take time after search and calculate time in milliseconds
                    nanoImp = System.nanoTime() - nanoImp;
                    long milli = nanoImp/1000000;

                    System.out.println("Binary results: ");
                    // if index is -1 (<0) then means character was not found
                    if (indexImp < 0) {System.out.println("The character " + searchImp + " was not found");}
                    // else means character has been found
                    else {System.out.println("The character " + searchImp + " was found at index " + indexImp);}
                    // show user how long it took
                    System.out.println("Time taken: " + nanoImp + "ns (" + milli + "ms)");

                    // take time in nanoseconds before search
                    nanoImp = System.nanoTime();
                    // perform linear search
                    indexImp = arr.linearImperative(searchImp);
                    // take time after search and calculate time in milliseconds
                    nanoImp = System.nanoTime() - nanoImp;
                    milli = nanoImp/1000000;

                    System.out.println("\nLinear results: ");
                    // if index is -1 (<0) then means character was not found
                    if (indexImp < 0) {System.out.println("The character " + searchImp + " was not found");}
                    // else means character has been found
                    else {System.out.println("The character " + searchImp + " was found at index " + indexImp);}
                    // show user how long it took
                    System.out.println("Time taken: " + nanoImp + "ns (" + milli + "ms)");
                    break;

                case 4: // exit program
                    // set control variable to false
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        System.out.println("Thank you for using this program made by Andrei Cojocaru");
    }
}
