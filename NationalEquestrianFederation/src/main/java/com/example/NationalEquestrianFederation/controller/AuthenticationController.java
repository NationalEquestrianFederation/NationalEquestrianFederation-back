package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.config.TokenUtils;
import com.example.NationalEquestrianFederation.dto.JwtAuthenticationDto;
import com.example.NationalEquestrianFederation.dto.UserDto;
import com.example.NationalEquestrianFederation.dto.UserTokenState;
import com.example.NationalEquestrianFederation.exceptions.ResourceConflictException;
import com.example.NationalEquestrianFederation.iservice.IRoleService;
import com.example.NationalEquestrianFederation.mapper.UserMapper;
import com.example.NationalEquestrianFederation.model.User;
import com.example.NationalEquestrianFederation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AuthenticationController {

    private TokenUtils tokenUtils;

    private AuthenticationManager authenticationManager;

    private UserService userService;

    private IRoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationDto authenticationRequest, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        if(userService.findByUsername(authenticationRequest.getUsername()).isDeleted()) {
            throw new ResourceConflictException(authenticationRequest.getUsername(), "User is deleted!");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);   //ubacivanje u sesiju

        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername(), user.getRole().getName(), user.getId());
        int expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));

    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody UserDto user, UriComponentsBuilder ucBuilder) {

        User existUser = this.userService.findByUsername(user.getUsername());

        if (existUser != null) {
            throw new ResourceConflictException(user.getUsername(), "Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRole(roleService.getByName(user.getRole()));
        return new ResponseEntity<>(userService.register(newUser), HttpStatus.CREATED);
    }

}
