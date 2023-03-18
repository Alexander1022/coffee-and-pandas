package com.fmi.entertizer.web;
import com.fmi.entertizer.error.UserNotFoundException;
import com.fmi.entertizer.model.service.FriendDTO;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.model.service.UserRegistrationDTO;
import com.fmi.entertizer.service.UserService;
import com.fmi.entertizer.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/users")
public class UserController {

    private ModelMapper modelMapper;
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
    public Map<String,String> login(@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }


    @RequestMapping(value = "/{id}/friends")
    public List<UserDTO> showFriends(@PathVariable Long id){
        return userService.viewFriends(id);
    }

    @RequestMapping(value = "/friends/add", method = RequestMethod.POST)
    public FriendDTO addFriend(@RequestBody Map<String, Long> payload){
        return userService.addFriend(payload.get("userId1"), payload.get("userId2"));
    }

    @RequestMapping(value = "/friends/confirm", method = RequestMethod.POST)
    public List<UserDTO> confirmFriends(@RequestBody Map<String, Long> map){
        return userService.friendRequests(map.get("id"));
    }

    @RequestMapping(value = "/friends/delete", method = RequestMethod.DELETE)
    public void delFriend(@RequestBody Map<String, Long> payload){
        userService.removeFriend(payload.get("userId"), payload.get("friendId"));
    }


}
