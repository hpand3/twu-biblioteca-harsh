package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void setup() {
        book = new Book(2009, "why?");
    }

    @Test
    public void isCheckedOut_bookIsCheckedOut_True() {
        book.setCheckoutStatus(true);
        assertEquals(true, book.isCheckedOut());
    }

    @Test
    public void isCheckedOut_bookIsNotCheckedOut_False() {
        book.setCheckoutStatus(false);
        assertEquals(false, book.isCheckedOut());
    }
}
