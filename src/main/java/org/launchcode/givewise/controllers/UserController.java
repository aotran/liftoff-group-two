package org.launchcode.givewise.controllers;

import lombok.extern.slf4j.Slf4j;
import org.launchcode.givewise.models.User;
import org.launchcode.givewise.request.UserRequest;
import org.launchcode.givewise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRequest userDto) {
            // Validate and process the data
            User user = userService.registerUser(userDto);

            
        log.info("User created: {}", user);
            // Check if user registration was successful
                return ResponseEntity.ok(user);
    }
}
