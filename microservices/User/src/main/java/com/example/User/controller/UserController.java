package com.example.User.controller;

import com.example.User.Rest.ResponseTemplateVO;
import com.example.User.entity.User;
import com.example.User.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") BigInteger userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate template;

    @GetMapping("/get")
    public Integer get(){
        return 1;
    }

}