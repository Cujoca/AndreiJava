import java.util.Scanner;

/**
 * Class to store and manipulate array of books
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */

public class Library {
    final private Book[] catalogue;
    final private int[] borrowed;
    private int numBooks;

    /**
     * Default constructor for class, numBooks is set to 0
     * and the catalogue is an empty array of size 20
     */
    public Library () {
        numBooks = 0;
        catalogue = new Book[20];
        borrowed = new int[20];
    }

    /**
     * Method to check if book is in database
     * @return  the number of said book, -1 if doesn't have
     *          if reference book exists, then minimum of 1
     *          will be returned. all returned ints (not
     *          including -1) will have this extra reference
     *          book included in the answer.
     */
    public int alreadyExists (int code) {
        // counter variable
        int out = -1;
        // iterate through catalogue, if we come across a book which matches,
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] != null && catalogue[i].isEqual(code)) {
                if (!catalogue[i].genre.equals("Reference")) out = i;
            }
        }
        return out;
    }

    /**
     * adds a book into the library
     * @param sc to read user input
     * @return true if successfully added, false if not
     */
    public boolean addBook (Scanner sc) {
        // initial variable definitions
        int id;
        int quant;
        String title;
        String author;
        String genre;

        // get all user input
        try {
            System.out.println("Enter the ID of the book: ");
            id = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the quantity of the book: ");
            quant = Integer.parseInt(sc.nextLine());

            System.out.println("Enter the title of the book: ");
            title = sc.nextLine();

            System.out.println("Enter the author of the book: ");
            author = sc.nextLine();

            System.out.println("Enter the genre of the book: ");
            genre = sc.nextLine();

        // If user inputs an invalid input, then informs user and returns false
        } catch (Exception e) {
            System.out.println("There was an invalid input");
            return false;
        }
        // temp book holder
        Book temp = switch (genre) {
            case "Reference", "reference" -> new ReferenceBook(id, title, author);
            case "Fiction", "fiction" -> new FictionBook(id, quant, title, author);
            case "NonFiction", "nonfiction", "nonFiction" -> new NonFictionBook(id, quant, title, author);
            default -> null;

            // create the requested type of book
        };

        // if user input invalid genre then book will be null
        // in this case inform user and return false
        if (temp == null) {
            System.out.println("There was an invalid input");
            return false;
        }

        // finally add book to catalogue, increment index, and return true
        catalogue[numBooks] = temp;
        numBooks = numBooks+1;
        return true;
    }

    /**
     * returns a book to the library
     * @param sc to read user input
     * @return true if successfully returned, false it not
     */
    public boolean returnBook (Scanner sc) {
        // grab ID of the requested book
        System.out.println("Enter the ID of the book you'd like to return: ");
        int id;
        // keep user input in try catch in case user is stupid and puts a not number
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("There was an invalid input");
            return false;
        }

        // get index of requested book
        int index = alreadyExists(id);

        // if index is -1 then book does not exist
        if (index != -1) {
            // get number of books to return
            System.out.println("How many would you like to return? ");
            int quantity = Integer.parseInt(sc.nextLine());
            // if trying to return too many books, inform user and exit false
            if (borrowed[index] < quantity) {
                System.out.println("You are trying to return too many books");
                return false;
            } else {
                // update catalogue with new quantity, update number of borrowed books
                catalogue[index].updateQuantity(quantity);
                borrowed[index] = borrowed[index]-quantity;
                // inform user and exit true
                System.out.println(quantity+" of that book have been returned");
                return true;
            }


        }
        // only reached if index is -1
        return false;
    }

    /**
     * borrows a book from the library
     * @param sc to read user input
     * @return true if successfully borrowed, false if not
     */
    public boolean borrowBook (Scanner sc) {
        // grab ID of the requested book
        System.out.println("Enter the ID of the book you'd like to borrow: ");
        int id;
        // keep user input in try catch in case user is stupid and puts a not number
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("There was an invalid input");
            return false;
        }

        // get index of book requested
        int index = alreadyExists(id);
        // if index is -1, book does not exist, or is only a reference book
        if (index != -1) {
            // get requested number of books
            System.out.println("How many of this book would you like to borrow? ");
            int quantity = Integer.parseInt(sc.nextLine());
            // if there are enough books to borrow, inform user and exit false
            if (catalogue[index].getQuantity() < quantity) {
                System.out.println("There are not enough books");
                return false;
            } else {
                // update quantity of books in catalogue
                catalogue[index].updateQuantity(-1*quantity);
                // update how many of that book have been borrowed, exit true
                borrowed[index] = borrowed[index]+quantity;
                System.out.println(quantity+" of that book have been borrowed");
                return true;
            }
        }
        // only reach this statement if index is -1
        System.out.println("Sorry, that book is not available");
        return false;
    }

    /**
     * Method to return the catalogue of books in a readable fashion
     * @return the string to output
     */
    public String toString () {
        StringBuilder out = new StringBuilder();
        for (Book b : catalogue) {
            if (b != null) {
                out.append(b.toString());
                out.append("\n");
            }
        }
        return out.toString();
    }

}
