package com.fmi.entertizer.service;

import com.fmi.entertizer.model.service.FriendDTO;
import com.fmi.entertizer.model.service.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO registerNewUser(UserDTO userServiceModel);
    public void updateUserFirstAndLastNames(UserDTO userDTO, Long id);

    Map<String,String> loginUser(UserDTO userDTO);

    UserDTO findById(Long id);

    UserDTO findByEmail(String email);

    UserDTO findByCoordinates(String coordinates);

    public List<UserDTO> getUserFriends(Long id);


    public FriendDTO addFriend(Long userId1, Long userId2);

    List<UserDTO> friendRequests(Long id);

    List<UserDTO> viewFriends(Long id);

    void friendRequestInteraction(Long userSentTo, Long userSentFrom, boolean accepted);

    List<UserDTO> searchResults(String search);

    void removeFriend(Long userId, Long userFriendId);




}
