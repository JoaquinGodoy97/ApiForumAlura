package com.alura.forumProject.service;

import com.alura.forumProject.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String username);
}
