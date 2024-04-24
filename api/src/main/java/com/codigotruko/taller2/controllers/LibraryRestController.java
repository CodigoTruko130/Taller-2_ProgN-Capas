package com.codigotruko.taller2.controllers;

import com.codigotruko.taller2.domain.dtos.*;
import com.codigotruko.taller2.domain.entities.User;
import com.codigotruko.taller2.services.UserService;
import com.codigotruko.taller2.utils.ErrorMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("")
public class LibraryRestController {
    private final UserService userService;
    private final ErrorMapper errorMapper;

    public LibraryRestController(UserService userService, ErrorMapper errorMapper) {
        this.userService = userService;
        this.errorMapper = errorMapper;
    }

    @GetMapping("/user/all")
    public ResponseEntity<GeneralResponse> findAll() {
            return GeneralResponse.getResponse(
                "User list found",
                userService.findAll());

    }

    @GetMapping("/user/{username}")
    public ResponseEntity<GeneralResponse> getProfile(@PathVariable String username) {
        User user = userService.findByUsername(username);

        if (user == null || !user.getActive()) {
            return GeneralResponse.getResponse(
                    "Error, usuario inactivo");
        }

        UserProfileDTO userProfileDTO = new UserProfileDTO();
        userProfileDTO.setUsername(user.getUsername());
        userProfileDTO.setEmail(user.getEmail());
        userProfileDTO.setFechaContratacion(user.getFechaContratacion());
        userProfileDTO.setRol(user.getRol());

        return GeneralResponse.getResponse(
                "User list found",
                userProfileDTO);

    }

    @PostMapping("/user")
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

    @PostMapping("/auth/signin")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginUserDTO info, BindingResult errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>("BAD REQUEST XD", HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByUsername(info.getUsername());

        if (user == null || !user.getPassword().equals(info.getPassword())) {
            return new ResponseEntity<>("BAD REQUEST XD", HttpStatus.BAD_REQUEST);
        }

        AuthSigninResponseDTO responseDTO = new AuthSigninResponseDTO();
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setRol(user.getRol());

        return ResponseEntity.ok(responseDTO);
    }



    @DeleteMapping("/user/delete/{username}")
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

    @PatchMapping("/user/change-password")
    public ResponseEntity<?> updatePassword(@RequestBody @Valid ChangePasswordDTO changePasswordDTO) {
        String username = changePasswordDTO.getUsername();
        String newPassword = changePasswordDTO.getNewPassword();

        User user = userService.findByUsername(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.updatePassword(username, newPassword);

        return GeneralResponse.getResponse("Password Changed");
    }


    @PatchMapping("/user/toggle-active")
    public ResponseEntity<?> toggleActive(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");

        User user = userService.findByUsername(username);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        userService.toggleActive(username);

        return GeneralResponse.getResponse("Toggle Active");
    }


}
