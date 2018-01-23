package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        // Look at Reduce lambda functions
//        return books.stream().filter(book -> book.isAvailable()).toArray();
        return availableBooks;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
