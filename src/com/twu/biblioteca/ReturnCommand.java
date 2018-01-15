package com.twu.biblioteca;

public class ReturnCommand implements ConsoleCommand {

    private Library lib;
    private String commandWithSpace;


    public ReturnCommand(String command, Library lib) {
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
        for (Book book : lib.getBooks()) {
            if (book.getTitle().equals(bookName)) {
                try {
                    book.returnBook();
                } catch (BookReturnException bre) {
                    System.out.println("That is not a valid book to return.");
                    return false;
                }
                System.out.println("Thank you for returning the book.");
                return true;
            }
        }
        System.out.println("That is not a valid book to return.");
        return false;
    }
}
