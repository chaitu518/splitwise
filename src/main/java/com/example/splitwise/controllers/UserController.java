package com.example.splitwise.controllers;

import com.example.splitwise.dtos.RegisterUserRequestDto;
import com.example.splitwise.dtos.RegisterUserResponseDto;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(final UserService userService) {
        this.userService = userService;
    }
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto){
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        try{
            userService.registerUser(requestDto.getUsername(),requestDto.getPassword(),requestDto.getPhoneNumber());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

}
