package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public boolean login(String username, String password) {
       User user = userService.findByUsername(username);
       if(user.getPassword().equals(password)){
           return true;
       }
       else{
           return false;
       }
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }
}
