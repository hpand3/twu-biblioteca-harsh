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

public class AllCommandsTest {

    ArrayList<ConsoleCommand> consoleCommands;
    AllCommands allCommands;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Library getLibraryWithBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Code Complete", 1993, "Steve McConnell"));
        books.add(new Book("Clean Code", 2008, "Robert Cecil Martin"));

        return new Library(books);
    }

    private ArrayList<ConsoleCommand> getCommands() {
        Library lib = getLibraryWithBooks();
        consoleCommands = new ArrayList<ConsoleCommand>();
        consoleCommands.add(new ListCommand("list", lib));
        consoleCommands.add(new ReturnCommand("return", lib));
        consoleCommands.add(new CheckoutCommand("checkout", lib));
        return consoleCommands;
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        allCommands = new AllCommands(getCommands());
    }

    @Test
    public void execCommand_CommandIsImplemented_OutputAsExpected() {
        allCommands.execCommand("checkout Code Complete");

        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void execCommand_CommandIsNotImplemented_PrintsInvalidOptionError() {
        allCommands.execCommand("help");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
