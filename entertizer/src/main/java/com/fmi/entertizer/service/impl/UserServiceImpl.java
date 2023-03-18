package com.fmi.entertizer.service.impl;

import com.fmi.entertizer.error.InvalidEmailException;
import com.fmi.entertizer.error.UserAlreadyExistsException;
import com.fmi.entertizer.error.UserNotFoundException;
import com.fmi.entertizer.model.entity.Friend;
import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.entity.enums.Status;
import com.fmi.entertizer.model.service.UserDTO;
import com.fmi.entertizer.repository.UserRepository;
import com.fmi.entertizer.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService {
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
    public UserDTO registerNewUser(UserDTO userServiceModel) {
        throwExceptionIfUserExist(userServiceModel.getEmail());

        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(bCryptPasswordEncoder.encode(userServiceModel.getPassword()));

        User user1 = this.userRepository.save(user);
        return this.modelMapper.map(user1, UserDTO.class);
    }


    @Override
    public UserDTO findById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with given id was not found !"));

        return this.modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void updateUserFirstAndLastNames(UserDTO userDTO, Long id){
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with given id was not found !"));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        this.userRepository.save(user);
    }

    @Override
    public UserDTO findByEmail(String email) {

        User user = this.userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new InvalidEmailException("User with that email address doesn't exist !"));

        return this.modelMapper.map(user, UserDTO.class);

    }

    @Override
    public UserDTO findByCoordinates(String coordinates) {
        User user = this.userRepository.findFirstByCoordinates(coordinates).orElseThrow(() -> new UserNotFoundException("User with given username does not exist! "));

        return this.modelMapper.map(user, UserDTO.class);

    }

    @Override
    public List<UserDTO> getUserFriends(UserDTO userDTO) {
        User user = this.userRepository.getUserById(userDTO.getId()).orElse(null);
        if(user == null) return null;
        List<UserDTO> userFriends = new ArrayList<>();
        user.getFriends().forEach(u -> userFriends.add(modelMapper.map(u, UserDTO.class)));
        return userFriends;
    }

    @Override
    public UserDTO addFriend(UserDTO userDTO, UserDTO userFriend) {
        User user = this.userRepository.getUserById(userDTO.getId()).orElse(null);
        if (user==null) return null;
        User friendUser = user.getFriends().stream().filter(u -> u.getSecondUser().getId().equals(userFriend.getId())).findFirst().get().getSecondUser();
        user.getFriends().add(new Friend(user, friendUser, Status.ACCEPTED));
        this.userRepository.save(user);
        return modelMapper.map(friendUser, UserDTO.class);
    }

    @Override
    public UserDTO removeFriend(UserDTO userDTO, UserDTO userFriend) {
        User user = this.userRepository.getUserById(userDTO.getId()).orElse(null);
        if (user==null) return null;
        int friendIndex = IntStream.range(0, user.getFriends().size())
                .filter(i -> user.getFriends().get(i).getSecondUser().getEmail().equals(userFriend.getEmail()))
                .findFirst()
                .orElse(-1);
        user.getFriends().remove(friendIndex);
        this.userRepository.save(user);
        return userFriend;
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
