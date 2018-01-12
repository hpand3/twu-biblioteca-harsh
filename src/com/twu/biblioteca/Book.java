package com.twu.biblioteca;

public class Book {
    private int year;
    private String author;
    private boolean checkedOut;

    public Book(int year, String author) {
        this.year = year;
        this.author = author;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public void setCheckoutStatus(boolean status) {
        this.checkedOut = status;
    }
}
