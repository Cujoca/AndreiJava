import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class TestSetMap {

    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<Integer, String> customers = new TreeMap<>();
        boolean filledMap = false;
        boolean keepGoing = true;
        Scanner sc = new Scanner(System.in);

        while (keepGoing) {
            System.out.println("""
                    1. Import data from text file
                    2. Display Map
                    3. Get Value
                    4. Put into sets and print
                    5. Display vals in descending order
                    6. Add new entry
                    7. Exit""");

            int choice = getInt(sc);

            switch (choice) {
                case 1:
                    customers = SetMapLib.fillMap();
                    filledMap = true;
                    break;
                case 2:
                    if (filledMap) {
                        SetMapLib.printMap(customers);
                    } else {
                        System.out.println("Whoops, you need to import your data first");
                    }
                    break;
                case 3:
                    if (filledMap) {
                        int key = getInt(sc);
                        String out = SetMapLib.getVal(customers, key);
                        if (out != null) {
                            System.out.printf("value of %d is: %s\n", key, out);
                        }
                    }
                    break;
                case 4:
                    if (filledMap) {SetMapLib.getIntoSets(customers);}
                    else System.out.println("Whoops, you need to import your data first");
                    break;
                case 5:
                    if (filledMap) {SetMapLib.printValuesDes(customers);}
                    else System.out.println("Whoops, you need to import your data first");
                    break;
                case 6:
                    System.out.println("Please put your new entry (Name, ID");
                    String[] temp = sc.nextLine().split(", ");
                    try {
                        if (temp.length != 2) throw new NumberFormatException();
                        int key = Integer.parseInt(temp[1]);
                        customers.put(key, temp[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid key");
                    }
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
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
