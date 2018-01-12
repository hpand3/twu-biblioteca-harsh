package com.twu.biblioteca;

public class Book {
    private int year;
    private String author;
    private String title;
    private boolean checkedOut;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.checkedOut = false;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAvailable() {
        return !this.checkedOut;
    }

    public void checkedOut() {
        this.checkedOut = true;
    }

    public void returned() {
        this.checkedOut = false;
    }
}
