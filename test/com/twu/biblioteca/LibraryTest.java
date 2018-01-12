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

        Book bookNotAvailable = new Book("New Book 1",2001, "Not Available");
        bookNotAvailable.checkedOut();

        Book bookAvailable = new Book("New Book 2",2002, "Available");

        // Add books to the library
        books.add(bookNotAvailable);
        books.add(bookAvailable);

        return new Library(books);
    }

    @Test
    public void getAvailableBooks_oneBookIsNotCheckedOut_oneBookWillBeShownInOutput() {
        ArrayList<Book> availableBooks = lib.getAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("New Book 2", availableBooks.get(0).getTitle());
        assertEquals(2002, availableBooks.get(0).getYear());
        assertEquals("Available", availableBooks.get(0).getAuthor());


    }
}
