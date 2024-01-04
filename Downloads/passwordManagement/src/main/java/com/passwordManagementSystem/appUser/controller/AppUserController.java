package com.passwordManagementSystem.appUser.controller;

import com.passwordManagementSystem.appUser.DTO.request.AppUserRequest;
import com.passwordManagementSystem.appUser.DTO.request.AppUserUpdate;
import com.passwordManagementSystem.appUser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AppUserController {
    private  final AppUserService appUserService;

    @PostMapping("registerUser")
    public ResponseEntity <?> registerAppUser(@RequestBody AppUserRequest appUserRequest){

        return new ResponseEntity<>(appUserService.registerAppUser(appUserRequest), HttpStatus.OK);
    }


   @GetMapping("loginUser")
    public ResponseEntity <?> loginUser(@RequestParam  String email,@RequestParam String password){
        return new ResponseEntity<>(appUserService.loginUser( email,password),HttpStatus.OK);
   }


   @GetMapping("findByEmail/{email}")
    public ResponseEntity <?> findByEmail(@PathVariable ("email")String email){
        return new ResponseEntity<>(appUserService.findAppUserByEmail(email),HttpStatus.ACCEPTED);
   }

 @GetMapping("findUserById/{id}")
    public ResponseEntity <?>findAppUserById(@PathVariable("id")long id){
        return new ResponseEntity<>(appUserService.findAppUserById(id),HttpStatus.ACCEPTED);

 }

 @GetMapping("updateUser")
    public ResponseEntity <?> updateUser(@RequestBody AppUserUpdate appUserRequest){

        return new ResponseEntity<>(appUserService.updateUser(appUserRequest),HttpStatus.OK);
 }


 @GetMapping("logOutUser")
    public ResponseEntity <?> logout(@RequestParam String email,@RequestParam String password){
        return new ResponseEntity<>(appUserService.logOut(email, password),HttpStatus.OK);
 }



@GetMapping("deleteById")
    public ResponseEntity <?>deleteUser(@RequestParam long id){
        return new ResponseEntity<>(appUserService.deleteAppUserById(id),HttpStatus.ACCEPTED);
}


}
