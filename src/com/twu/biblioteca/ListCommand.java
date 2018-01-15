package com.twu.biblioteca;

public class ListCommand implements ConsoleCommand {

    private Library lib;
    private String commandWithSpace;

    public ListCommand(String command, Library lib) {
        this.lib = lib;
        this.commandWithSpace = command + " ";
    }

    public boolean matches(String commandText) {
        return commandText.contains(this.commandWithSpace);
    }

    public boolean exec(String commandText) {
        String bookName = commandText.replace(this.commandWithSpace, "");
        if (bookName.equals("Books")) {
            String title = "Title - Author - Year";
            String booksStringRepr = "";
            for (Book book : lib.getAvailableBooks()) {
                booksStringRepr += book.toString();
                booksStringRepr += "\n";
            }

            System.out.print(title + "\n" + booksStringRepr);
            return true;
        }

        return false;

    }
}
