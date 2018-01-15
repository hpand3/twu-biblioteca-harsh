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

public class CheckoutCommandTest {

    CheckoutCommand cc;

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
        lib.getAvailableBooks().get(1).checkout(); // Clean Code
        cc = new CheckoutCommand("Checkout", lib);
    }

    @Test
    public void matches_commandTextDoesNotIncludeCommand_False() {
        assertFalse(cc.matches("checkt Code Complete"));
    }

    @Test
    public void matches_commandTextIncludesCommand_True() {
        assertTrue(cc.matches("Checkout Code Complete"));
    }

    @Test
    public void exec_CheckingOutAnAvailableBook_CheckoutSuccessfully() {
        assertTrue(cc.exec("Checkout Code Complete"));

        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void exec_CheckingOutAnUnavailableBook_CheckoutUnSuccessful() {
        assertFalse(cc.exec("Checkout Clean Code"));

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void exec_CheckingOutABookNotPresentInLibrary_CheckoutUnSuccessful() {
        assertFalse(cc.exec("Checkout Design patterns"));

        assertEquals("That book is not available.\n", outContent.toString());
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
