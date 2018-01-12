package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library lib;

    @Before
    public void setup() {
        lib = getLibraryWithBooks();
    }

    private Library getLibraryWithBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        Book bookNotAvailable = new Book(2001, "Not Available");
        bookNotAvailable.checkedOut();

        Book bookAvailable = new Book(2002, "Available");

        // Add books to the library
        books.add(bookNotAvailable);
        books.add(bookAvailable);

        return new Library(books);
    }

    @Test
    public void getAvailableBooks_oneBookIsNotCheckedOut_oneBookWillBeShownInOutput() {
        assertEquals(1, lib.getAvailableBooks().size());
        assertEquals(2002, lib.getAvailableBooks().get(0).getYear());
        assertEquals("Available", lib.getAvailableBooks().get(0).getAuthor());
    }
}
