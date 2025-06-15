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
                " | Edition: " + topic;
    }

    /**
     * Overridden method to return a book as a string array containing members of book
     * this version specifically places a string 'r' in the first slot designating
     * it a Reference book, also including the book's topic at the end
     * @return the string array
     */
    @Override
    public String[] toStorage() {
        String[] out = new String[6];
        out[0] = "r";
        out[1] = Integer.toString(bookCode);
        out[2] = title;
        out[3] = Integer.toString(quantityInStock);
        out[4] = author;
        out[5] = topic;
        return out;
    }
}
