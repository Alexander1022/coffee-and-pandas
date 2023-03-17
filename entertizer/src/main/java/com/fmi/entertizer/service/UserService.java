package com.fmi.entertizer.service;

import com.fmi.entertizer.model.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User addUser(User user);
}
