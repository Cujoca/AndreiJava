import org.testng.annotations.Test;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void updateQuantity() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo");
        assertTrue(book.updateQuantity(1));
    }

    @Test
    void isEqual() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo");
        Book book2 = new ReferenceBook(111, 1, "hi", "yoohoo");
        assertTrue(book.equals(book2));
    }

    @Test
    void testToString() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo");
        assertEquals(book.toString(), book.toString());
    }

    @Test
    void getQuantity() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo");
        assertEquals(1, book.getQuantity());
    }

    @Test
    void getCode() {
        Book book = new ReferenceBook(111, 1, "hi", "yoohoo");
        assertEquals(111, book.getCode());
    }
}