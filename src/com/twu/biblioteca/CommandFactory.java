package com.twu.biblioteca;

public interface CommandFactory {
    ConsoleCommand fromString(String input);
}
