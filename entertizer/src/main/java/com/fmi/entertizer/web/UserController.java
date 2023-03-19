package com.fmi.entertizer.web;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fmi.entertizer.error.UserNotFoundException;
import com.fmi.entertizer.model.service.FriendAcceptingDTO;
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
public class UserController { //10.108.4.54:8080

    private final ModelMapper modelMapper;
    @Autowired
    private final UserServiceImpl userService;

    public UserController(ModelMapper modelMapper, UserServiceImpl userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }   //OK

   // @RequestMapping("/{id}")
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

    @RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
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

    @RequestMapping(value = "/is_friend", method = RequestMethod.POST)
    public FriendAcceptingDTO isFriend(@RequestBody FriendAcceptingDTO payload) {
        Map<Boolean, String> result = new HashMap<>();
        result.put(payload.accepted, payload.id1 + " " + payload.id2);
        userService.friendRequestInteraction(payload.getId1(), payload.getId2(), payload.getAccepted());
        return payload;
    }

    @RequestMapping(value = "/friends/delete", method = RequestMethod.DELETE)
    public void delFriend(@RequestBody Map<String, Long> payload) {
        userService.removeFriend(payload.get("user_id"), payload.get("friend_id"));
    }

    @RequestMapping(value = "/friends/view/accepted", method = RequestMethod.POST)
    public List<UserDTO> viewFriendsWithStatusAccepted(@RequestBody Map<String, Long> payload) {
        return userService.viewFriends(payload.get("user_id"));
    }


}
