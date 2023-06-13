package com.example.springsecurityclient.controller;


import com.example.springsecurityclient.entity.User;
import com.example.springsecurityclient.model.UserModel;
import com.example.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @Slf4j
    public class RegistrationController {

        @Autowired
        private UserService userService;



        @PostMapping("/register")
        public String registerUser(@RequestBody UserModel userModel) {
            User user = userService.registerUser(userModel);
            return "Success";
        }
}
