package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ListCommandTest {

    ListCommand lc;

    private Library getLibraryWithBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Some book 1",2001, "Harsh Pan"));
        books.add(new Book("Some book 2",2002, "Some Autho"));

        return new Library(books);
    }

    @Before
    public void setup() {
        Library lib = getLibraryWithBooks();
        lc = new ListCommand(lib);
    }

    @Test
    public void matches_commandTextIncludesCommand_True() {
        assertTrue(lc.matches("list books"));
    }

    @Test
    public void matches_commandTextDoesNotIncludeCommand_False() {
        assertFalse(lc.matches("lis books"));
    }
}
