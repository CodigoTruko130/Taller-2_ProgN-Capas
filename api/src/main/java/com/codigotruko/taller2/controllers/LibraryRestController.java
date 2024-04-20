package com.codigotruko.taller2.controllers;

import com.codigotruko.taller2.domain.dtos.GeneralResponse;
import com.codigotruko.taller2.domain.dtos.LoginUserDTO;
import com.codigotruko.taller2.domain.dtos.SaveUserDTO;
import com.codigotruko.taller2.domain.entities.User;
import com.codigotruko.taller2.services.UserService;
import com.codigotruko.taller2.utils.ErrorMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class LibraryRestController {
    private final UserService userService;
    private final ErrorMapper errorMapper;

    public LibraryRestController(UserService userService, ErrorMapper errorMapper) {
        this.userService = userService;
        this.errorMapper = errorMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<GeneralResponse> findAll() {
            return GeneralResponse.getResponse(
                "User list found",
                userService.findAll());

    }

    @PostMapping("/save")
    public ResponseEntity<GeneralResponse> saveUser(@RequestBody @Valid SaveUserDTO info/*, BindingResult errors*/) {
        /*if (errors.hasErrors()) {
            return GeneralResponse.getResponse(
                    HttpStatus.BAD_REQUEST,
                    errorMapper.map(errors.getFieldErrors())
                    //errors.getFieldErrors()

            );

        }
        */

        userService.save(info);

        /*return new ResponseEntity<>(
                "User saved",
                HttpStatus.OK
        );*/
        return GeneralResponse.getResponse("User saved");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid LoginUserDTO info, BindingResult errors){

        var _user = userService.findByUsername(info.getUsername());

        if (errors.hasErrors() || _user == null) {
            return new ResponseEntity<>(
                    "BAD REQUEST XD",
                    HttpStatus.BAD_REQUEST
            );
        }

        if (_user.getPassword().equals(info.getPassword())) {
            return new ResponseEntity<>(
                    "User Login",
                    HttpStatus.OK
            );

        }else{
            return new ResponseEntity<>(
                    "BAD REQUEST XD",
                    HttpStatus.BAD_REQUEST
            );
        }


    }


    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }

        userService.deleteByUsername(username);

        return GeneralResponse.getResponse("User Deleted");
    }


}
