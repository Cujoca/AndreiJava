
/**
 * child class of Book
 * contains specific logic for fiction books
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */

public class FictionBook extends Book {

    /**
     * Parameterized constructor note that genre is set automatically to "Fiction"
     * @param bookCode book ID number
     * @param quantityInStock number of books in catalogue
     * @param title title of book
     * @param author author of book
     */
    public FictionBook (int bookCode, int quantityInStock, String title, String author) {
        this.bookCode = bookCode;
        this.quantityInStock = quantityInStock;
        this.title = title;
        this.author = author;
        genre = "Fiction";
    }
}
