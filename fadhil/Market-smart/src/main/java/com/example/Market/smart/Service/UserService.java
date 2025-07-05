package com.example.Market.smart.Service;

import com.example.Market.smart.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

    User loginUser(String email, String password);
}
