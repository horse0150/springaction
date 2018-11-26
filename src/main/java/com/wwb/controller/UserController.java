package com.wwb.controller;

import com.wwb.service.UserService;
import com.wwb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @RequestMapping("/findByUsername/{username}")
    @ResponseBody
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
}
