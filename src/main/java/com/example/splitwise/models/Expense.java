package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private int amount;
    @ManyToOne
    private User createdBy;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @OneToMany
    private List<ExpenseUser> expenseUser;
}
