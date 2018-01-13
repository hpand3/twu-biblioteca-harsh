package com.twu.biblioteca;

interface ConsoleCommand {
    boolean matches(String commandText);
    String helpText();
    String exec(String arg);
}
