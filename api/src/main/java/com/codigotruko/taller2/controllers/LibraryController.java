package com.codigotruko.taller2.controllers;

import com.codigotruko.taller2.domain.dtos.SaveUserDTO;
import com.codigotruko.taller2.domain.dtos.UserProfileDTO;
import com.codigotruko.taller2.domain.entities.User;
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

    @GetMapping("/profile/{username}")
    public String profileUser(@PathVariable String username, Model model) {
        User user = userService.findByUsername(username);

        if (user == null || !user.getActive()) {
            return "the-error";
        }
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setUsername(user.getUsername());
        userProfileDTO.setEmail(user.getEmail());
        userProfileDTO.setFechaContratacion(user.getFechaContratacion());
        userProfileDTO.setRol(user.getRol());
        model.addAttribute("user", userProfileDTO);
        return "main-profile";
    }


    @GetMapping("/rest")
    public String mainRest(Model model){
        model.addAttribute("users", userService.findAll());

        return "mainRest";
    }


}
