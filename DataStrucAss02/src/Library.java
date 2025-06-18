import java.io.*;
import java.util.ArrayList;
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
    final private ArrayList<Book> catalogue;
    final private ArrayList<Integer> borrowed;

    /**
     * Default constructor for class, numBooks is set to 0
     * and the catalogue is an empty array of size 20
     */
    public Library () {
        catalogue = new ArrayList<>(20);
        borrowed = new ArrayList<>(20);
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
        for (int i = 0; i < catalogue.size(); i++) {
            if (catalogue.get(i) != null && catalogue.get(i).isEqual(code)) {
                if (!catalogue.get(i).genre.equals("Reference")) out = i;
            }
        }
        return out;
    }

    /**
     * Method to add new book in order of book code
     * @param b book to add
     * @return success or failure
     */
    public boolean addInOrder (Book b) {
        if (catalogue.contains(b)) return false;

        int i = catalogue.size();
        // decrement i until we find a book with a smaller code than our addition
        while (i > 0 && catalogue.get(i-1).compareTo(b) > 0) {i--;}

        catalogue.add(i, b);
        return true;
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
        String topic = "";
        boolean isRef = false;
        boolean isNon = false;

        System.out.println("What genre of book are you adding?");
        System.out.println("r for Reference, n for NonFiction, f for Fiction");
        String type = sc.nextLine();
        if (type.length() != 1) {
            System.out.println("Invalid option entered");
            return false;
        }
        switch (type.charAt(0)) {
            case 'r' -> isRef = true;
            case 'n' -> isNon = true;
            case 'f' -> isRef = false;
            default -> {
                System.out.println("Invalid option entered");
                return false;
            }
        }

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

            if (isNon || isRef) {
                System.out.println("Enter the topic of the book: ");
                topic = sc.nextLine();
            }

        // If user inputs an invalid input, then informs user and returns false
        } catch (Exception e) {
            System.out.println("There was an invalid input");
            return false;
        }
        // temp book holder
        Book temp;

        // based on selected type of book, create requested type
        if (isNon) {
            // check if topic was successfully entered
            if (topic.isEmpty()) {
                System.out.println("Invalid entry");
                return false;
            } temp = new NonFictionBook(id, quant, title, author, topic);}

        else if (isRef) {
            // check if topic was successfully entered
            if (topic.isEmpty()) {
                System.out.println("Invalid entry");
                return false;
            } temp = new ReferenceBook(id, quant, title, author, topic);}

        else temp = new FictionBook(id, quant, title, author);

        // if user input invalid genre then book will be null
        // in this case inform user and return false
        if (temp == null) {
            System.out.println("There was an invalid input");
            return false;
        }

        // finally add book to catalogue, increment index, and return true
        this.addInOrder(temp);
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
            if (borrowed.get(index) < quantity) {
                System.out.println("You are trying to return too many books");
                return false;
            } else {
                // update catalogue with new quantity, update number of borrowed books
                catalogue.get(index).updateQuantity(quantity);
                borrowed.set(index, borrowed.get(index)-quantity);
                // inform user and exit true
                System.out.println(quantity+" of that book have been returned");
                return true;
            }


        }
        // only reached if index is -1
        System.out.println("That book does not exist!");
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
            if (catalogue.get(index).getQuantity() < quantity) {
                System.out.println("There are not enough books");
                return false;
            } else {
                // update quantity of books in catalogue
                catalogue.get(index).updateQuantity(-1*quantity);
                // update how many of that book have been borrowed, exit true
                borrowed.set(index, borrowed.get(index)+quantity);
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

    /**
     * Method to find the index of a specific book
     * @param sc scanner to take user input
     * @return the index of the book
     */
    public int findBook (Scanner sc) {
        if (catalogue.size() == 0) {return -1;}
        int findCode = -1;
        // get the requested code
        System.out.println("Enter the ID of the book you'd like to find: ");
        try {
            findCode = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("There was an invalid input");
            return -1;
        }

        // get index of requested book
        int out = this.binaryHelper(0, catalogue.size(), findCode);
        // if is -1, then doesn't exist
        if (out < 0) {return -1;}
        // output found index
        System.out.println(catalogue.get(out).toString());
        System.out.println("This was book number: " + (out+1));
        return out;
    }

    /**
     * The actual binary search which will get called by the findBook method
     * @param left lower bound of search area
     * @param right upper bound of search area
     * @param find requested book code
     * @return the index of the requested book or -1 if not found
     */
    private int binaryHelper (int left, int right, int find)  {
        // check if rules are still being followed
        if (left > right) return -1;
        // get mid-index of search area
        int mid = (left + right) / 2;
        // if is requested book, return index
        if (catalogue.get(mid).getCode() == (find)) {return mid;}
        // if mid is larger than requested book code, move search area to lower half
        if (catalogue.get(mid).getCode() > find) {return binaryHelper(left, mid-1, find);}
        // if mid is smaller than requested book code, move search area to upper half
        if (catalogue.get(mid).getCode() < find) {return binaryHelper(mid+1, right, find);}

        // only reached if something went wrong
        return -1;
    }

    /**
     * Method to store current catalogue of books in specified file
     * books will be stored in a csv format
     * file will be overwritten with new content rather than content added
     * @param sc Scanner to get which file to write into
     * @throws IOException in case file does not exist
     */
    public void saveToFile (Scanner sc) throws IOException {
        System.out.println("""
                Enter in the name of the file you'd like to save to.
                Please note that if the file does not exist, this operation will not complete.""");
        // get name of file and create file object
        String name = sc.nextLine();
        File file = new File("DataStrucAss02/Resources/"+name);
        // check if file exists. If not, inform user and exit method
        if (!file.exists()) {
            System.out.println("That file does not exist");
            return;
        }

        // when creating the buffered writer, it will clear the file of all text
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        // iterate through catalogue and write all books into file
        for (Book b : catalogue) {
            for (String e : b.toStorage()) {
                writer.write(e + "\n");
            }
        }
        // close writer to enact all changes
        writer.close();
    }

    /**
     * Method to read contents of a file and place into catalogue
     * books will be read in a comma seperated format
     * catalogue will be overwritten with new set of books
     * @param sc to get file to read from
     * @throws IOException in case file does not exist
     */
    public void readFromFile (Scanner sc) throws IOException {
        System.out.println("""
                Enter in the name of the file you'd like to read from.
                Please note that if the file does not exist, this operation will not complete.""");

        // get file location
        String name = sc.nextLine();
        File file = new File("DataStrucAss02/Resources/"+name);
        // check if user is dumb and put file that doesn't exist
        if (!file.exists()) {
            System.out.println("That file does not exist");
            return;
        }

        // clear catalogue to prepare for import of info
        catalogue.clear();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        // get first line, which should be the genre of book
        String temp = reader.readLine();
        // members of our book
        int quantity;
        int code;
        String title;
        String author;
        String topic;
        while (temp != null) {
            // if next line after whole book isn't a one-letter code, go to next line
            if (temp.length() > 1) {temp = reader.readLine();}
            // get char version of genre for switch
            char type = temp.charAt(0);
            // all 3 types of books share the same order for the
            // code, title, quant, and author. so we can read those regardless
            code = Integer.parseInt(reader.readLine());
            title = reader.readLine();
            quantity = Integer.parseInt(reader.readLine());
            author = reader.readLine();
            // based on type of book, read last line for topic (or don't)
            // create related type of book, and add to catalogue
            switch (type) {
                case 'n':
                    topic = reader.readLine();
                    this.addInOrder(new NonFictionBook(code, quantity, title, author, topic));
                    break;
                case 'r':
                    topic = reader.readLine();
                    this.addInOrder(new ReferenceBook(code, quantity, title, author, topic));
                    break;
                case 'f':
                    this.addInOrder(new FictionBook(code, quantity, title, author));
            }
            // move temp to next line
            temp = reader.readLine();
        }
    }
}
