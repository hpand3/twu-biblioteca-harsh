package com.twu.biblioteca;

public interface ConsoleCommand {
    public String command();
    public String helpText();
    public void exec();
}
