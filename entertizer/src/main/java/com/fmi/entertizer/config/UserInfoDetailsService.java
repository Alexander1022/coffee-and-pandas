package com.fmi.entertizer.config;

import com.fmi.entertizer.model.entity.User;
import com.fmi.entertizer.model.service.UserRegistrationDTO;
import com.fmi.entertizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findFirstByEmail(username);
        return user.map(UserRegistrationDTO::new).orElseThrow(() -> new UsernameNotFoundException(("user not found" + username)));
    }

}
