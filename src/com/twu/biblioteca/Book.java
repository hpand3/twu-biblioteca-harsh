package com.twu.biblioteca;

public class Book {
    private int year;
    private String author;
    private boolean checkedOut;

    public Book(int year, String author) {
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
