package com.twu.biblioteca;

interface ConsoleCommand {
    boolean matches(String commandText);
    String helpText();
    boolean exec(String arg);
}
