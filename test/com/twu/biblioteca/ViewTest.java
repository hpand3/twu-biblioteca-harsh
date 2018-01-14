package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    View view;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        view = new View();
    }

    @Test
    public void welcome_customerStartsApplication_welcomeMessage() {
        String listBooksOutput = "Title - Author - Year\n" +
                "Code Complete - Steve McConnell - 1993\n" +
                "Clean Code - Robert Cecil Martin - 2008\n";
        assertEquals("Welcome!\n" + listBooksOutput, outContent.toString());
    }



    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
