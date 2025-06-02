/**
 * Parent class for fiction, non-fiction, and reference books
 * contains general logic for child classes
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */
public abstract class Book {
    protected int bookCode;
    protected int quantityInStock;
    protected String title;
    protected String author;
    protected String genre;

    /**
     * Constructor for the Book class
     */
    public Book () {

    }

    /**
     * Method to update the quantity of books in the catalogue
     * @param amount int to change quantity by
     * @return true if success, false if not
     */
    public boolean updateQuantity (int amount) {
        if (quantityInStock+amount < 0) return false;
        quantityInStock = quantityInStock + amount;
        return true;
    }

    /**
     * Check if two books are the same
     * @param code the code to check if equal
     * @return true if same, false if not
     */
    public boolean isEqual (int code) {
        // check if b is not a reference book, and that the title and author match
        return this.bookCode == code;
    }

    /**
     * MEthod to turn book into readable string
     * @return the stringified book
     */
    public String toString () {
        return  "Book Code: " + bookCode +
                " | Quantity: " + quantityInStock +
                " | Title: " + title +
                " | Author: " + author +
                " | Genre: " + genre;
    }

    /**
     * Quantity getter
     * @return the quantity
     */
    public int getQuantity () {return this.quantityInStock;}

    /**
     * bookID getter
     * @return the bookID
     */
    public int getCode () {return this.bookCode;}
}

