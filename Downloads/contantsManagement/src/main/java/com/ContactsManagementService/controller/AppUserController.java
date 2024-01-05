package com.ContactsManagementService.controller;

import com.ContactsManagementService.dto.request.AppUserRequest;
import com.ContactsManagementService.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("UserManagement")
public class AppUserController {
    private final AppUserService appUserService;
    @PostMapping("registerUser")
    public ResponseEntity <?>registerUser(@RequestBody AppUserRequest appUserRequest){
        return new ResponseEntity<>(appUserService.registerUser(appUserRequest), HttpStatus.OK);
    }

  @GetMapping("login/{emailAddress}/{password}")
    public ResponseEntity <?>login(@PathVariable("emailAddress") String email,@PathVariable("password") String password){
        return new ResponseEntity<>(appUserService.login(email, password),HttpStatus.ACCEPTED);
  }

    @GetMapping("logOut/{emailAddress}/{password}")
    public ResponseEntity <?>logOut(@PathVariable("emailAddress") String email,@PathVariable("password") String password){
        return new ResponseEntity<>(appUserService.logOut(email, password),HttpStatus.ACCEPTED);
    }
}
