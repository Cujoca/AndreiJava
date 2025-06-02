import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void alreadyExists() {

        Library lib = new Library();
        lib.addBook(new Scanner(System.in));
        assertEquals(0, lib.alreadyExists(111));
    }

    @Test
    void addBook() {
        Library lib = new Library();
        assertTrue(lib.addBook(new Scanner(System.in)));
    }

    @Test
    void returnBook() {
        Library lib = new Library();
        lib.addBook(new Scanner(System.in));
        lib.borrowBook(new Scanner(System.in));
        assertTrue(lib.borrowBook(new Scanner(System.in)));
    }

    @Test
    void borrowBook() {
        Library lib = new Library();
        lib.addBook(new Scanner(System.in));
        assertTrue(lib.borrowBook(new Scanner(System.in)));
    }

    @Test
    void testToString() {
        Library lib = new Library();
        lib.addBook(new Scanner(System.in));
        assertSame(lib.toString(), lib.toString());
    }
}