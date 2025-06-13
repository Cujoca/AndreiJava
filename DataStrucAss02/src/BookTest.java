import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void updateQuantity() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        assertTrue(book.updateQuantity(1));
    }

    @Test
    void isEqual() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        Book book2 = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        assertTrue(book.equals(book2));
    }

    @Test
    void testToString() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        assertEquals(book.toString(), book.toString());
    }

    @Test
    void getQuantity() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        assertEquals(1, book.getQuantity());
    }

    @Test
    void getCode() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo", "joke");
        assertEquals(111, book.getCode());
    }
}