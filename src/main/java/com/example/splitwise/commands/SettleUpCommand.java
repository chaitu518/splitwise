package com.example.splitwise.commands;

import com.example.splitwise.controllers.SettleUpController;
import com.example.splitwise.dtos.SettleUpUserRequestDto;
import com.example.splitwise.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpCommand implements Command {
    private SettleUpController settleUpController;
    public SettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }
    @Override
    public boolean match(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size()==2 && words.get(1).equals("SettleUp");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.parseLong(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);
        System.out.println(responseDto.getResponseStatus());
    }
}
