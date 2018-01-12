package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void setup() {
        book = new Book("new book",2009, "why?");
    }

    @Test
    public void isCheckedOut_bookIsCheckedOut_True() {
        book.checkedOut();
        assertEquals(false, book.isAvailable());
    }

    @Test
    public void isCheckedOut_bookIsNotCheckedOut_False() {
        book.returned();
        assertEquals(true, book.isAvailable());
    }
}
