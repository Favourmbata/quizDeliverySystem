package com.logisticsSystem.logisticApp.controllers;

import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.UserRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AppUserController {
   private final AppUserService appUserService;


   @PostMapping("register")
    public ResponseEntity<?> registerUser( @RequestBody UserRequest userRequest){

        return  new  ResponseEntity<>(appUserService.register(userRequest), HttpStatus.ACCEPTED);
    }

  @GetMapping("loginUser/{password}/{email}")
   public ResponseEntity <?> loginUser(@PathVariable ("password") String password,@PathVariable ("email") String email){

       return new ResponseEntity<>(appUserService.loginUser(email,password),HttpStatus.ACCEPTED);
  }


   @PostMapping("update")
    public ResponseEntity <?> updateUserAccount(@RequestBody UpdateUserRequest updateUserRequest){

       return new ResponseEntity<>(appUserService.updateAccount(updateUserRequest),HttpStatus.ACCEPTED);
   }

  @DeleteMapping("delete/{email}")
    public ResponseEntity <?>  deleteUserAccount(@PathVariable ("email") String email){
       return new ResponseEntity<>(appUserService.deleteAccount(email), HttpStatus.ACCEPTED);
  }

}
