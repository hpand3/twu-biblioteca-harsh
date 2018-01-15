package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ListCommandTest {

    ListCommand lc;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    private Library getLibraryWithBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Code Complete", 1993, "Steve McConnell"));
        books.add(new Book("Clean Code", 2008, "Robert Cecil Martin"));

        return new Library(books);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Library lib = getLibraryWithBooks();
        lc = new ListCommand("list", lib);
    }

    @Test
    public void matches_commandTextIncludesCommand_True() {
        assertTrue(lc.matches("list books"));
    }

    @Test
    public void matches_commandTextDoesNotIncludeCommand_False() {
        assertFalse(lc.matches("lis books"));
    }

    @Test
    public void exec_TwoBooksInLibrary_PrintsATableWithTwoBooks() {
        String listBooksOutput = "Title - Author - Year\n" +
                "Code Complete - Steve McConnell - 1993\n" +
                "Clean Code - Robert Cecil Martin - 2008\n";

        assertTrue(lc.exec("list books"));

        assertEquals(listBooksOutput, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}