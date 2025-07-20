import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Main class to run code
 *
 * Author: Andrei Cojocaru, 041032238
 * Professor: James Mwangi
 * Course: CST8130 Data Structures
 * Section: 301
 */
public class TestSetMap {

    public static void main(String[] args) throws FileNotFoundException {
        // init starter vars
        TreeMap<Integer, String> customers = new TreeMap<>();
        boolean filledMap = false;
        boolean keepGoing = true;
        Scanner sc = new Scanner(System.in);

        while (keepGoing) {
            // show menu to user
            System.out.println("""
                    \n1. Import data from text file
                    2. Display Map
                    3. Get Value
                    4. Put into sets and print
                    5. Display vals in descending order
                    6. Add new entry
                    7. Exit""");

            int choice = getInt(sc);

            switch (choice) {
                case 1: // fill map from text file
                    // call fill method
                    customers = SetMapLib.fillMap();
                    filledMap = true;
                    break;
                case 2: // print out map
                    if (filledMap) {
                        // call print method
                        SetMapLib.printMap(customers);
                    } else {
                        System.out.println("Whoops, you need to import your data first");
                    }
                    break;
                case 3: // retrieve a value from the map
                    if (filledMap) {
                        // get user input
                        int key = getInt(sc);
                        // grab value
                        String out = SetMapLib.getVal(customers, key);
                        // if is null then does not exist
                        if (out != null) {
                            System.out.printf("value of %d is: %s\n", key, out);
                        } else {System.out.println("Whoops, you need to import your data first");}
                    }
                    break;
                case 4: // print keys and vals as sets
                    if (filledMap) {
                        // call print method
                        SetMapLib.getIntoSets(customers);
                        System.out.println("\nThe above values are contained in sets, so there are no duplicates");
                    }
                    else System.out.println("Whoops, you need to import your data first");
                    break;
                case 5: // sort vals in descending order and print
                    // call print method
                    if (filledMap) {SetMapLib.printValuesDes(customers);}
                    else System.out.println("Whoops, you need to import your data first");
                    break;
                case 6: // add new entry
                    System.out.println("Please put your new entry (Name, ID)");
                    // get entry
                    String[] temp = sc.nextLine().split(", ");
                    try {
                        // if splitted string is not 2 elements then is invalid entry
                        if (temp.length != 2) throw new NumberFormatException();
                        // get key
                        int key = Integer.parseInt(temp[1].trim());
                        customers.put(key, temp[0]);
                        // if invalid entry inform user and break back to menu
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid ID, it should be an integer");
                    }
                    break;
                case 7: // exit
                    // inform user and set control variable to false
                    System.out.println("Exiting, program made by Andrei Cojocaru");
                    keepGoing = false;
                    break;
                default: // in case user doesn't realize what a menu is
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    /**
     * utility method to get valid int input from user
     *
     * @param sc scanner for user input
     * @return the parsed number
     */
    public static int getInt (Scanner sc) {
        int out = -1;

        // while we do not have proper input
        while (out < 0) {
            try {
                // set out to user input
                out = Integer.parseInt(sc.nextLine());
                // if is not in desired range throw exception to go to catch block
                if (out < 1) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                // if number is not valid then inform user and try again
                System.out.println("invalid input try again");
                out = -1;
            }
        }
        return out;
    }


}
