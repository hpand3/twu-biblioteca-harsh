package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuitCommandTest {

    QuitCommand qc;

    @Before
    public void setup() {
        qc = new QuitCommand("Quit");
    }

    @Test
    public void matches_commandTextIncludesCommand_True() {
        assertTrue(qc.matches("Quit"));
    }

    @Test
    public void matches_commandTextIncludesCommand_False() {
        assertFalse(qc.matches("quit"));
    }
}
