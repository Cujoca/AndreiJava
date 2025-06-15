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

    private String topic;

    /**
     * Parameterized constructor for Non-fiction books
     * @param bookCode id of book
     * @param quantityInStock number of book
     * @param title title of book
     * @param author author of book
     */
    public NonFictionBook (int bookCode, int quantityInStock, String title, String author, String topic) {
        this.bookCode = bookCode;
        this.quantityInStock = quantityInStock;
        this.title = title;
        this.author = author;
        this.topic = topic;
        genre = "NonFiction";
    }

    /**
     * Overridden method to return a book as a string array containing members of book
     * this version specifically places a string 'n' in the first slot designating
     * it a Non-Fiction book, also including the book's topic at the end
     * @return the string array
     */
    @Override
    public String[] toStorage() {
        String[] out = new String[6];
        out[0] = "n";
        out[1] = Integer.toString(bookCode);
        out[2] = title;
        out[3] = Integer.toString(quantityInStock);
        out[4] = author;
        out[5] = topic;
        return out;
    }

}
