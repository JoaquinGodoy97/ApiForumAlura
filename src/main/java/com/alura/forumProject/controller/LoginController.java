package com.alura.forumProject.controller;

import com.alura.forumProject.model.LoginRequestDTO;
import com.alura.forumProject.model.User;
import com.alura.forumProject.security.JWTDataToken;
import com.alura.forumProject.security.TokenService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {

        try {
            Authentication authToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.user(),
                    loginRequestDTO.password()
                    );
            var authenticatedUser = authenticationManager.authenticate(authToken);
            var JWTtoken = tokenService.generateToken(authenticatedUser.getName());
            return ResponseEntity.ok(new JWTDataToken(JWTtoken));

        } catch (Exception e) {
//            e.printStackTrace();  // just for debugging
            throw e;
        }
    }

}
