package org.launchcode.givewise.controllers;

import org.launchcode.givewise.models.User;
import org.launchcode.givewise.request.UserRequest;
import org.launchcode.givewise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ModelAndView registerUser(@RequestBody UserRequest userDto) {
        ModelAndView response = new ModelAndView();
        // You can validate and process the data here
        // For simplicity, let's assume there's a UserService to handle user registration
        User user=userService.registerUser(userDto);
        response.addObject("user", user);
        return response;
    }
}
