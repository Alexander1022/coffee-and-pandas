package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }


}
