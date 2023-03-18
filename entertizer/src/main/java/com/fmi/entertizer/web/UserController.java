package com.fmi.entertizer.web;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.service.UserService;
import com.fmi.entertizer.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/all")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public UserDTO getMeById(@PathVariable Long id){
        return userService.findById(id);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addUser(@RequestBody UserDTO user){
         userService.registerNewUser(user);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO user, @PathVariable Long id){
        userService.updateUserFirstAndLastNames(user, id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json"})
    public String login(@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }


}
