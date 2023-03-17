package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.error.UserAlreadyExistsException;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user->users.add(modelMapper.map(user, UserDTO.class)));
        return users;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        //this.userRepository.sa
        return null;
    }

    @Override
    public List<UserDTO> getUserFriends(UserDTO userDTO) {
        User user = this.userRepository.getUserById(userDTO.getId()).orElse(null);
        if(user == null) return null;
        List<UserDTO> userFriends = new ArrayList<>();
        user.getFriends().forEach(u -> userFriends.add(modelMapper.map(u, UserDTO.class)));
        return userFriends;
    }

    private void throwExceptionIfUserExist(String email) {

        User userWithEmail = this.userRepository.findFirstByEmail(email).orElse(null);

        if (userWithEmail != null) {
            throw new UserAlreadyExistsException(
                    "There is an account with that email address: "
                            + email);
        }
    }

}
