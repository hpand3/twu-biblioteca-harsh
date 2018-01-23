package com.twu.biblioteca;

import java.util.ArrayList;

public class AllCommands implements CommandFactory {

    ArrayList<ConsoleCommand> commands;

    public AllCommands(ArrayList<ConsoleCommand> commands) {
        this.commands = commands;
    }

    public void execCommand(String commandText) {
        boolean commandExec = false;

        for (ConsoleCommand cc : this.commands) {
            if (cc.matches(commandText)) {
                commandExec = cc.exec(commandText);
                break;
            }
        }

        if (!commandExec) {
            System.out.println("Select a valid option!");
        }
    }
}
