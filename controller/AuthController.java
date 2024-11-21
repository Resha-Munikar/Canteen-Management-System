package com.example.demo.controller;

import com.example.demo.dto.LoginDto;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String , Boolean> login(@RequestBody LoginDto loginDto){
        boolean isSuccess = authService.login(loginDto.username(), loginDto.password());
        return Map.of("success", isSuccess);
    }
}
