package com.alura.forumProject.service;

import com.alura.forumProject.model.User;
import com.alura.forumProject.model.UserDTO;
import com.alura.forumProject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Not found user " + username)
                );
    }

    private UserDTO getUserDTO(User byUsername) {
        Long userId = byUsername.getId();
        return new UserDTO(userId.toString(), byUsername.getUsername());
    }
}
