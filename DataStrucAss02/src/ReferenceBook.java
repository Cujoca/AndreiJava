/**
 * child class of Book
 * special type of book that cannot be borrowed
 * is used as a baseline for future books added
 * Student Name: Andrei Cojocaru
 * Student Number: 041032238
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 */

public class ReferenceBook extends Book{

    private String topic;

    /**
     * Parameterized constructor for reference books
     * @param bookCode int ID of book
     * @param title title of book
     * @param author author of book
     */
    public ReferenceBook (int bookCode, int quantity, String title, String author, String topic) {
        this.bookCode = bookCode;
        this.quantityInStock = quantity;
        this.title = title;
        this.author = author;
        this.genre = "Reference";
        this.topic = topic;
    }

    public String toString () {
        return  "Book Code: " + bookCode +
                " | Quantity: " + quantityInStock +
                " | Title: " + title +
                " | Author: " + author +
                " | Genre: " + genre +
                " | Topic: " + topic;
    }





}
