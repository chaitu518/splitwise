package com.example.splitwise.commands;

import com.example.splitwise.controllers.UserController;
import com.example.splitwise.dtos.RegisterUserRequestDto;
import com.example.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    //Register vinsmokesanji 003 namisswwaann
    private UserController userController;
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }
    @Override
    public boolean match(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==4 && words.get(0).equals("Register");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        String name = words.get(1);
        Long phoneNumber = Long.parseLong(words.get(2));
        String password = words.get(3);
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setUsername(name);
        requestDto.setPassword(password);
        requestDto.setPhoneNumber(phoneNumber);
        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
        System.out.println(responseDto.getResponseStatus());
    }
}
