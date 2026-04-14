package com.dalen.vetAppDalen.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalen.vetAppDalen.security.JwtService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return jwtService.generateToken(username);
    }
}
