package com.example.splitwise.services;

import com.example.splitwise.models.User;
import com.example.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void registerUser(String username, String password,Long phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null) {
            throw new RuntimeException("User already exists");
        }
        User newUser = new User();
        newUser.setName(username);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);
        userRepository.save(newUser);
    }
}
