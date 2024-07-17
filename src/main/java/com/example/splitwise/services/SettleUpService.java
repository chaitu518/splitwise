package com.example.splitwise.services;

import com.example.splitwise.Strategy.SettleUpStrategy;
import com.example.splitwise.exceptions.UserNotFoundException;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.User;
import com.example.splitwise.repositories.ExpenseUserRepository;
import com.example.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SettleUpService {
    private final UserRepository userRepository;
    private final ExpenseUserRepository expenseUserRepository;
    private final SettleUpStrategy settleUpStrategy;

    public SettleUpService(UserRepository userRepository, ExpenseUserRepository expenseUserRepository,SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);
        Set<Expense> expensesToSettle = new HashSet<>();

        for (ExpenseUser expenseUser : expenseUsers) {
            expensesToSettle.add(expenseUser.getExpense());
        }

        List<Expense> finalExpenses = settleUpStrategy.SettleUp(expensesToSettle.stream().toList());

        //return the current user was part of;

        return null;
    }
}
