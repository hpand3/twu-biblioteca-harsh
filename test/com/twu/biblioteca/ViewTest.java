package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ViewTest {

    View view;

    @Before
    public void setup() {
        view = new View();
    }

    @Test
    public void welcome_customerStartsApplication_welcomeMessage() {
        assertEquals("Welcome!", view.welcome());
    }
}
