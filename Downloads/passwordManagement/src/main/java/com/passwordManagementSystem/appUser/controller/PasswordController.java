package com.passwordManagementSystem.appUser.controller;

import com.passwordManagementSystem.appUser.DTO.request.PasswordRequest;
import com.passwordManagementSystem.appUser.DTO.request.UpdatePasswordRequest;
import com.passwordManagementSystem.appUser.service.interfaces.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("password")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping("createPassword")
    public ResponseEntity <?>createPassword(@RequestBody PasswordRequest passwordRequest){
        try{
            return new ResponseEntity<>(passwordService.createPassword(passwordRequest), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("couldn't complete the task ",HttpStatus.BAD_REQUEST);
        }

    }

  @GetMapping("findPassword{title}/{customerEmail}")
    public  ResponseEntity <?>findPasswordByTitleAndCustomerEmail(@PathVariable ("title")String title,@PathVariable("customerEmail")String customerEmail){

        return new ResponseEntity<>(passwordService.findPassword(title, customerEmail),HttpStatus.ACCEPTED);
  }

  @GetMapping("findPassword/{id}")
    public ResponseEntity <?> findPasswordById(@PathVariable long id){

        return new ResponseEntity<>(passwordService.findPasswordById(id),HttpStatus.ACCEPTED);
  }

  @GetMapping("updatePassword")
    public ResponseEntity<?>updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest){
        return new ResponseEntity<>(passwordService.updatepassword(updatePasswordRequest),HttpStatus.ACCEPTED);
  }

  @GetMapping("deletePassword/{id}/{customerEmail}")
    public ResponseEntity <?>deletePasswordWithIdAndEmail(@PathVariable long id,@PathVariable String customerEmail){

        return new ResponseEntity<>(passwordService.deletePasswordWithIdAndCustomerEmail(id,customerEmail),HttpStatus.OK);
  }

  @GetMapping("deletePassword/{title}")
    public ResponseEntity <?>deletePasswordTitle(@PathVariable String title){

        return new ResponseEntity<>(passwordService.deletePassword(title),HttpStatus.OK);
  }

     @GetMapping("viewPassword/{email}/{title}")
    public ResponseEntity <?> viewPassword(@PathVariable String email,@PathVariable String title){

        return new ResponseEntity<>(passwordService.viewPassword(email,title),HttpStatus.OK);
     }
}
