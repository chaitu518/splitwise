package com.example.splitwise.commands;

public interface Command {
    public boolean match(String input);
    public void execute(String input);
}
