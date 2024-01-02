package com.passwordManagementSystem.appUser.controller;

import com.passwordManagementSystem.appUser.DTO.request.AppUserRequest;
import com.passwordManagementSystem.appUser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AppUserController {
    private  final AppUserService appUserService;

    @PostMapping("registerUser")
    public ResponseEntity <?> registerAppUser(@RequestBody AppUserRequest appUserRequest){

        return new ResponseEntity<>(appUserService.registerAppUser(appUserRequest), HttpStatus.OK);
    }

}
