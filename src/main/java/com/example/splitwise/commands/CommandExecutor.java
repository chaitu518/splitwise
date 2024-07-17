package com.example.splitwise.commands;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Controller
public class CommandExecutor {
    List<Command> commands=new ArrayList<Command>();
    public void add(Command command) {
        commands.add(command);
    }
    public void remove(Command command) {
        commands.remove(command);
    }
    public void execute(String input) {
        for(Command command : commands){

            if(command.match(input)){

                command.execute(input);
                break;
            }
        }
    }
}
