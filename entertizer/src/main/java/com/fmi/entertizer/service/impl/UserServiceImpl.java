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
import org.springframework.stereotype.Service;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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

        User user1 = this.userRepository.save(user);
        return this.modelMapper.map(user1, UserDTO.class);
    }


    @Override
    public String loginUser(UserDTO userDTO){
        User user = this.userRepository.findFirstByEmail(userDTO.getEmail()).orElse(null);
        if (user == null) throw new UserNotFoundException("No such user.");
        List<User> allUsers = new ArrayList<>();
        this.userRepository.findAll().forEach(allUsers::add);
        User user1 = allUsers.stream().filter(u-> u.getPassword().equals(userDTO.getPassword())).findFirst().orElse(null);
        if(user1 == null){
            return "Wrong password";
        }
        return user1.getId().toString();
    }

    @Override
    public UserDTO findById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with given id was not found !"));

        return this.modelMapper.map(user, UserDTO.class);
    }

    public Long getUserIdByPasswordHash(UserDTO user){
        return this.userRepository.findByPassword(user.getPassword()).get().getId();
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
        User user = this.userRepository.findFirstById(userDTO.getId()).orElse(null);
        if(user == null) return null;
        List<UserDTO> userFriends = new ArrayList<>();
        user.getFriends().forEach(u -> userFriends.add(modelMapper.map(u, UserDTO.class)));
        return userFriends;
    }

    @Override
    public UserDTO addFriend(Long userId1, Long userId2) {
        User user = this.userRepository.findFirstById(userId1).orElse(null);
        if (user==null) return null;
        User friendUser = user.getFriends().stream().filter(u -> u.getSecondUser().getId().equals(userId2)).findFirst().get().getSecondUser();
        user.getFriends().add(new Friend(user, friendUser, Status.PENDING_SENT));
        friendUser.getFriends().add(new Friend(friendUser, user, Status.PENDING_RECEIVED));
        this.userRepository.save(user);
        return modelMapper.map(friendUser, UserDTO.class);
    }

    @Override
    public UserDTO removeFriend(UserDTO userDTO, UserDTO userFriend) {
        User user = this.userRepository.findFirstById(userDTO.getId()).orElse(null);
        if (user==null) return null;
        int friendIndex = IntStream.range(0, user.getFriends().size())
                .filter(i -> user.getFriends().get(i).getSecondUser().getEmail().equals(userFriend.getEmail()))
                .findFirst()
                .orElse(-1);
        user.getFriends().remove(friendIndex);
        this.userRepository.save(user);
        return userFriend;
    }

    @Override
    public List<UserDTO> friendRequests(UserDTO userDTO){
        User user = this.userRepository.getUserById(userDTO.getId()).orElse(null);
        List<UserDTO> friendRequests = new ArrayList<>();
        user.getFriends().stream().forEach(f->{
            if(f.getStatus() == Status.PENDING_RECEIVED){
                friendRequests.add(modelMapper.map(f.getSecondUser(), UserDTO.class));
            }
        });
        return friendRequests;
    }

    @Override
    public List<UserDTO> viewFriends(Long id){
        User user = this.userRepository.getUserById(id).orElse(null);
        List<UserDTO> friendRequests = new ArrayList<>();
        user.getFriends().stream().forEach(f->{
            if(f.getStatus() == Status.ACCEPTED){
                friendRequests.add(modelMapper.map(f.getSecondUser(), UserDTO.class));
            }
        });
        return friendRequests;
    }
    @Override
    public void friendRequestInteraction(UserDTO userSentTo, UserDTO userSentFrom, boolean accepted){
        User user = this.userRepository.getUserById(userSentTo.getId()).orElse(null);
        if(accepted){
            user.getFriends().stream().filter(f->f.getId().equals(userSentFrom.getId())).findFirst().get().setStatus(Status.ACCEPTED);
        } else {
            removeFriend(userSentTo, userSentFrom);
        }
        this.userRepository.save(user);
    }
    @Override
    public List<UserDTO> searchResults(String search){
        List<User> allUsers = new ArrayList<>();
        this.userRepository.findAll().forEach(allUsers::add);
        List<UserDTO> searchResults = new ArrayList<>();
        allUsers.forEach(u -> {
            if(u.getFirstName().contains(search) || u.getLastName().contains(search)){
                UserDTO userDTO = modelMapper.map(u, UserDTO.class);
                searchResults.add(userDTO);
            }
        });
        return searchResults;
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
