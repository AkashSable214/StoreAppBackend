package com.cjc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cjc.app.dto.LoginRequest;
import com.cjc.app.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return service.login(request);
    }
}