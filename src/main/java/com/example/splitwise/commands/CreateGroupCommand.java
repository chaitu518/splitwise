package com.example.splitwise.commands;

import org.springframework.stereotype.Component;

@Component
public class CreateGroupCommand implements Command {
    @Override
    public boolean match(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
