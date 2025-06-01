/**
 * child class of Book
 * contains specific logic for non-fiction books
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */

public class NonFictionBook extends Book {

    /**
     * Parameterized constructor for Non-fiction books
     * @param bookCode id of book
     * @param quantityInStock number of book
     * @param title title of book
     * @param author author of book
     */
    public NonFictionBook (int bookCode, int quantityInStock, String title, String author) {
        this.bookCode = bookCode;
        this.quantityInStock = quantityInStock;
        this.title = title;
        this.author = author;
        genre = "NonFiction";
    }
}
