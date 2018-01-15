package com.twu.biblioteca;

public class QuitCommand implements ConsoleCommand {

    private String command;

    public QuitCommand(String command) {
        this.command = command;
    }

    @Override
    public boolean matches(String commandText) {
        return commandText.contains(this.command);
    }

    @Override
    public boolean exec(String commandText) {
        String arg = commandText.replace(this.command, "");

        if (arg.equals("")) {
            System.exit(0);
            return true; // never runs
        } else {
            return false;
        }
    }
}
