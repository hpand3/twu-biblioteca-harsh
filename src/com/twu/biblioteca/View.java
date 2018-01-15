package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private AllCommands allCommands;
    // Create a single shared Scanner for keyboard input
    private static Scanner scanner = new Scanner( System.in );

    public View() {
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
        System.out.println("Welcome!");

        System.out.println();

        printMainMenuOptions();
    }

    private void executeCommand(String commandText) {
        allCommands.execCommand(commandText);
    }

    private void printMainMenuOptions() {
        System.out.println("Main Menu Options:");
        for (String option : getMainMenuOptions()) {
            System.out.println(option);
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
