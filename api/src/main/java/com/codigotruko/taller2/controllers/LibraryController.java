package com.codigotruko.taller2.controllers;

import com.codigotruko.taller2.domain.dtos.SaveUserDTO;
import com.codigotruko.taller2.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("")
public class LibraryController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping("/register")
    public String registerUser(){
        return "register";
    }

    @GetMapping("/login")
    public String loginUser(){
        return "login";
    }

    @GetMapping("/{username}")
    public String profileUser(@PathVariable String username, Model model){
        model.addAttribute("user", userService.findByUsername(username));

        return "main-profile";
    }

    @GetMapping("/rest")
    public String mainRest(Model model){
        model.addAttribute("users", userService.findAll());

        return "mainRest";
    }


}
