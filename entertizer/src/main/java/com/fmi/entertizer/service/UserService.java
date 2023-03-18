package com.fmi.entertizer.service;

import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.service.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO registerNewUser(UserDTO userServiceModel);
    public void updateUserFirstAndLastNames(UserDTO userDTO, Long id);

    String loginUser(UserDTO userDTO);

    UserDTO findById(Long id);

    UserDTO findByEmail(String email);

    UserDTO findByCoordinates(String coordinates);

    public List<UserDTO> getUserFriends(UserDTO userDTO);


    UserDTO addFriend(UserDTO userDTO, UserDTO userFriend);

    List<UserDTO> friendRequests(UserDTO userDTO);

    void friendRequestInteraction(UserDTO userSentTo, UserDTO userSentFrom, boolean accepted);

    List<UserDTO> searchResults(String search);

    UserDTO removeFriend(UserDTO userDTO, UserDTO userFriend);
}
