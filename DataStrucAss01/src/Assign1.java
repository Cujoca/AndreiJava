import java.util.Scanner;

/**
 * class which contains main and executable code
 */
public class Assign1 {
    /**
     * main method to run code
     * @param args arguments passed into console
     */
    public static void main(String[] args) {
        Library lib = new Library();
        boolean keepGoing = true;
        Scanner sc = new Scanner(System.in);
        int choice;

        while (keepGoing) {
            System.out.println("""
                    \n
                    Please select one of the following: 
                    1. Add book to library
                    2. Display current library catalogue
                    3. Borrow book
                    4. Return book
                    5. Exit""");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {lib.addBook(sc);}
                case 2 -> {System.out.print(lib.toString());}
                case 3 -> {lib.borrowBook(sc);}
                case 4 -> {lib.returnBook(sc);}
                case 5 -> {keepGoing = false;}
                default -> System.out.println("Invalid choice");
            }
        }
        System.out.println("""
                    Thank you for using this program.
                    Designed by Andrei Cojocaru.""");
    }



}
