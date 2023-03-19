package com.fmi.entertizer.web;
import com.fasterxml.jackson.core.PrettyPrinter;
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
import java.util.HashMap;
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
    }   //OK

    @RequestMapping("/{id}")
    public UserDTO getMeById(@PathVariable Long id){
        return userService.findById(id);
    }   //OK


    @RequestMapping(value = "/register", method = RequestMethod.POST)                   //Probably
    public void addUser(@RequestBody UserDTO user){
         userService.registerNewUser(user);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)                  //TODO: user doesn't update, it stays the same

    public void updateUser(@RequestBody UserDTO user, @PathVariable Long id){
        userService.updateUserFirstAndLastNames(user, id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json"})             //OK
    public Map<String,String> login(@RequestBody UserDTO userDTO){
        return userService.loginUser(userDTO);
    }

    @RequestMapping(value = "/{id}/friends")
    public List<UserDTO> showFriends(@PathVariable Long id){
        return userService.viewFriends(id);
    }

    @RequestMapping(value = "add/friends", method = RequestMethod.POST)                                         //OK
    public FriendDTO addFriend(@RequestBody Map<String, Long> payload){
        return userService.addFriend(payload.get("user_id"), payload.get("friend_id"));
    }

    @RequestMapping(value = "/friend_request", method = RequestMethod.POST)
    public List<UserDTO> confirmFriends(@RequestBody Map<String, Long> map){
        return userService.friendRequests(map.get("user_id"));
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/is_friend/{ans}")
//    public Map<String, Boolean> isFriend(@RequestBody Map<Boolean, List<Long>> payload){
//        //Map<String, Boolean> result = (Map<String, Boolean>) new HashMap<>().put("isFriend", ans);
//
//        userService.friendRequestInteraction(id1, id2, ans);
//        return result;
//    }

    @RequestMapping(value = "/friends/delete", method = RequestMethod.DELETE)
    public void delFriend(@RequestBody Map<String, Long> payload){
        userService.removeFriend(payload.get("user_id"), payload.get("friend_id"));
    }

    @RequestMapping(value = "/friends/view/accepted", method = RequestMethod.POST)
    public List<UserDTO> viewFriendsWithStatusAccepted(@RequestBody Map<String, Long> payload){
        return userService.viewFriends(payload.get("user_id"));
    }



}
