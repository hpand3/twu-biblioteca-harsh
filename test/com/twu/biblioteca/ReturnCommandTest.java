package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ReturnCommandTest {

    ReturnCommand rc;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Library getLibraryWithBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Code Complete", 1993, "Steve McConnell"));
        books.add(new Book("Clean Code", 2008, "Robert Cecil Martin"));

        return new Library(books);
    }

    @Before
    public void setUpStreams() throws BookCheckoutException {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Library lib = getLibraryWithBooks();
        lib.getAvailableBooks().get(0).checkout(); // Code Complete
        rc = new ReturnCommand("return", lib);
    }

    @Test
    public void matches_commandTextDoesNotIncludeCommand_False() {
        assertFalse(rc.matches("retawd Code Complete"));
    }

    @Test
    public void matches_commandTextIncludesCommand_True() {
        assertTrue(rc.matches("return Code Complete"));
    }

    @Test
    public void exec_ReturningTheCheckedOutBook_ReturnsBookSuccessfully() {
        assertTrue(rc.exec("return Code Complete"));

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void exec_ReturningAnAlreadyReturnedBook_ReturnUnSuccessfull() {
        assertFalse(rc.exec("return Clean Code"));

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void exec_ReturningABookNotPresentInLibrary_ReturnUnSuccessfull() {
        assertFalse(rc.exec("return Design patterns"));

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
