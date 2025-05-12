package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return "redirect:/register?error"; // Username sudah digunakan
        }
        userService.registerUser(user);
        return "redirect:/login?registered"; // Registrasi berhasil
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
