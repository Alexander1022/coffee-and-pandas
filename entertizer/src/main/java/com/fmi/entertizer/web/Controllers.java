package com.fmi.entertizer.web;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controllers {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }



}
