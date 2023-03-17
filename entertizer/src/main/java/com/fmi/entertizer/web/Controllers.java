package com.fmi.entertizer.web;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controllers {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/all")
    public List<User> getUsers(){
        //return userService.getAllUsers();
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }



}
