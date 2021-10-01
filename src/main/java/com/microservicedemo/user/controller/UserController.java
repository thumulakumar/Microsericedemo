package com.microservicedemo.user.controller;

import com.microservicedemo.user.VO.UserDepartment;
import com.microservicedemo.user.entity.User;
import com.microservicedemo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUserInfo(@RequestBody User user){
        log.info("Inside the Controller Saving User Info");
        return userService.saveUserInformation(user);
    }
    @GetMapping("/{id}")
    public UserDepartment getUserAndDepartmentInfo(@PathVariable("id") Long id){
        return userService.getUserInfo(id);
    }

}
