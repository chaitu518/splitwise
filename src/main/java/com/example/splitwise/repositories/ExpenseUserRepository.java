package com.example.splitwise.repositories;

import com.example.splitwise.models.ExpenseUser;
import com.example.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    public List<ExpenseUser> findAllByUser(User user);
}
