package com.example.splitwise.dtos;

import com.example.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDto {
    //Transactions(Dummy Expenses) which, if we execute settle up the user;
    List<Expense> expenseList;
    ResponseStatus responseStatus;
}
