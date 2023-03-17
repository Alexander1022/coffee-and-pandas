package com.fmi.entertizer.service;

import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.service.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public UserDTO addUser(UserDTO userDTO);

    public List<UserDTO> getUserFriends(UserDTO userDTO);

}
