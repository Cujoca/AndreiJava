
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

    /**
     * Overridden method to return a book as a string array containing members of book
     * this version specifically places a string 'F' in the first slot designating
     * it a Fiction book
     * @return the string array
     */
    @Override
    public String[] toStorage() {
        String[] out = new String[5];
        out[0] = "f";
        out[1] = Integer.toString(bookCode);
        out[2] = title;
        out[3] = Integer.toString(quantityInStock);
        out[4] = author;
        return out;
    }
}
