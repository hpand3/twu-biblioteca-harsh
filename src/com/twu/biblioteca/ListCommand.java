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

    public String exec(String item) {
        return null;
    }
}
