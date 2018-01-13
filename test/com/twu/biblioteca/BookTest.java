package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void setup() {
        book = new Book("New Book",2009, "John Smith");
    }

    @Test(expected=BookCheckoutException.class)
    public void checkout_bookIsCheckedOut_ThrowsBookCheckoutException() throws BookCheckoutException {
        // First checkout
        book.checkout();
        // Second attempt to checkout for the same book
        book.checkout();
    }

    @Test
    public void checkout_bookIsNotCheckedOut_NoExceptionIsThrown() throws BookCheckoutException{
        book.checkout();
    }

    

    @Test
    public void toString_bookWithTitleYearAuthor_StringRepresentationOfBook() {
        assertEquals("New Book - John Smith - 2009", book.toString());
    }


}
