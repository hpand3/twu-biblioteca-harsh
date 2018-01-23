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
        // Research dependency injection
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        PrintStream out = new PrintStream(outContent);
        view = new View(out);

        System.out.println("NEW");
        System.out.println(out);
    }

//    Have to comment out the infinite loop in View to run this test.
    @Test
    public void welcome_customerStartsApplication_welcomeMessage() {
//        String mainMenuOptions = "Main Menu Options:\n" + "List Books\n";
//        assertEquals("Welcome!\n\n" + mainMenuOptions, outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
