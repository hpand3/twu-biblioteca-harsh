package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private AllCommands allCommands;
    // Create a single shared Scanner for keyboard input
    private static Scanner scanner = new Scanner( System.in );

    PrintStream outContent;

    public View(PrintStream outContent) {
        this.outContent = outContent;
        Library lib = createLibrary();
        allCommands = new AllCommands(createCommands(lib));

        // Prints welcome when all the classes are initialised
        welcome();

        while (true) {
            String line = scanner.nextLine();
            executeCommand(line);
        }
    }

    private void welcome() {
        outContent.println("Welcome!");

        outContent.println();

        printMainMenuOptions();
    }

    private void executeCommand(String commandText) {
        allCommands.execCommand(commandText);
    }

    private void printMainMenuOptions() {
        outContent.println("Main Menu Options:");
        for (String option : getMainMenuOptions()) {
            outContent.println(option);
        }
    }

    private Library createLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Code Complete", 1993, "Steve McConnell"));
        books.add(new Book("Clean Code", 2008, "Robert Cecil Martin"));
        return new Library(books);
    }

    private ArrayList<ConsoleCommand> createCommands(Library lib) {
        ArrayList<ConsoleCommand> consoleCommands = new ArrayList<ConsoleCommand>();
        consoleCommands.add(new ListCommand("List", lib));
        consoleCommands.add(new ReturnCommand("Return", lib));
        consoleCommands.add(new CheckoutCommand("Checkout", lib));
        consoleCommands.add(new QuitCommand("Quit"));
        return consoleCommands;
    }

    private ArrayList<String> getMainMenuOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("List Books");
        return options;
    }
}
