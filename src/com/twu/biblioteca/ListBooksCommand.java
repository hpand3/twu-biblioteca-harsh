package com.twu.biblioteca;

public class ListBooksCommand implements ConsoleCommand {

    private Library lib;

    public ListBooksCommand(Library lib) {
        this.lib = lib;
    }

    public String command() {
        return "list books";
    }

    public String helpText() {
        return "Lists all the available books that can be checked out";
    }

    public void exec() {

    }
}
