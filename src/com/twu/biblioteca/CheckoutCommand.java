package com.twu.biblioteca;

public class CheckoutCommand implements ConsoleCommand {

    private Library lib;
    private String commandWithSpace;

    public CheckoutCommand(String command, Library lib) {
        this.lib = lib;
        this.commandWithSpace = command + " ";
    }

    @Override
    public boolean matches(String commandText) {
        return commandText.contains(this.commandWithSpace);
    }

    @Override
    public boolean exec(String commandText) {
        String bookName = commandText.replace(this.commandWithSpace, "");
        for (Book book : lib.getAvailableBooks()) {
            if (book.getTitle().equals(bookName)) {
                try {
                    book.checkout();
                } catch (BookCheckoutException bce) {
                    System.out.println("That book is not available.");
                    return false;
                }
                System.out.println("Thank you! Enjoy the book.");
                return true;
            }
        }
        System.out.println("That book is not available.");
        return false;
    }
}
