package com.twu.biblioteca;

interface ConsoleCommand {
    boolean matches(String commandText);
    boolean exec(String arg);
}
