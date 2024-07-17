package com.example.splitwise.Strategy;

import com.example.splitwise.models.*;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.lang.Math.abs;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> SettleUp(List<Expense> expenses) {
        HashMap<User, Integer> expenseUsersMap = new HashMap<>();
        for (Expense expense : expenses) {

            for(ExpenseUser expenseUser : expense.getExpenseUser()){

               if(expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID_BY)){
                   expenseUsersMap.put(expenseUser.getUser(),expenseUsersMap.getOrDefault(expenseUser.getUser(),0)+expenseUser.getAmount());
                }
               else{
                   expenseUsersMap.put(expenseUser.getUser(),expenseUsersMap.getOrDefault(expenseUser.getUser(),0)-expenseUser.getAmount());
               }
            }
        }
        PriorityQueue<Pair<User,Integer>> minheap = new PriorityQueue<>((a, b)->b.getSecond()-a.getSecond());
        PriorityQueue<Pair<User,Integer>> maxheap = new PriorityQueue<>();
        for(Map.Entry<User,Integer> entryMap : expenseUsersMap.entrySet()){
            if(entryMap.getValue()<0){
                minheap.add(Pair.of(entryMap.getKey(),0));
            }
            else {
                maxheap.add(Pair.of(entryMap.getKey(),entryMap.getValue()));
            }
        }
        List<Expense> expenseArrayList = new ArrayList<>();
        while(!minheap.isEmpty() && !maxheap.isEmpty()){
            Pair<User,Integer> pair = minheap.remove();
            Pair<User,Integer> pair2 = maxheap.remove();
            int amount=0;
            if(abs(pair.getSecond())<pair2.getSecond()){
                amount=pair2.getSecond()+pair.getSecond();
                maxheap.add(pair.of(pair2.getFirst(),amount));
            }
            else {
                amount=pair2.getSecond()+pair.getSecond();
                minheap.add(pair.of(pair.getFirst(),amount));
            }

        }
        return List.of();
    }
}
