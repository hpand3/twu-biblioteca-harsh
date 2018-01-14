package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class View {
    public View() {
        Library lib = createLibrary();
        welcome();
    }

    public void welcome() {
        System.out.println("Welcome!");
        executeCommand("list books");
    }

    public void executeCommand(String command) {
        String listBooksOutput = "Title - Author - Year\n" +
                "Code Complete - Steve McConnell - 1993\n" +
                "Clean Code - Robert Cecil Martin - 2008";
        System.out.println(listBooksOutput);
    }

    private Library createLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Code Complete", 1993, "Steve McConnell"));
        books.add(new Book("Clean Code", 2008, "Robert Cecil Martin"));
        return new Library(books);
    }

}
