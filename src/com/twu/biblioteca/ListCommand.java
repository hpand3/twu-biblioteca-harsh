package com.twu.biblioteca;

public class ListCommand implements ConsoleCommand {

    private Library lib;

    public ListCommand(Library lib) {
        this.lib = lib;
    }

    public boolean matches(String commandText) {
        return commandText.contains("list ");
    }

    public String helpText() {
        return "Lists all the available items in the library";
    }

    public boolean exec(String item) {
        if (item.equals("books")) {
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
