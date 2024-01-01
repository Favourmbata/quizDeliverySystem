package com.logisticsSystem.logisticApp.controllers;

import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.AppUserRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AppUserController {
   private final AppUserService appUserService;
   private final ProductService productService;


   @PostMapping("register")
    public ResponseEntity<?> registerUser( @RequestBody AppUserRequest userRequest){

        return  new  ResponseEntity<>(appUserService.registerCustomer(userRequest), HttpStatus.ACCEPTED);
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

    @PostMapping("createproduct")
    public ResponseEntity <?>createProduct(@RequestBody ProductRequest productRequest){


        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("findProduct{name}/{customerEmail}")
    public ResponseEntity<?> findProduct(@PathVariable ("name") String name ,@PathVariable ("customerEmail")String customerEmail){

        return new ResponseEntity<>(productService.findProduct(name,customerEmail),HttpStatus.ACCEPTED);
    }
  @PostMapping("updateProduct")
    public ResponseEntity<?>updateProduct(@RequestBody ProductUpdate productUpdate){

       return new ResponseEntity<>(productService.updateProduct(productUpdate),HttpStatus.ACCEPTED);
  }


  @GetMapping("deleteProduct{name}/{customerEmail}")
    public ResponseEntity<?>deleteProduct(@PathVariable ("name") String name ,@PathVariable ("customerEmail")String customerEmail){

       return new ResponseEntity<>(productService.delete_Product(name,customerEmail),HttpStatus.ACCEPTED);

    }

}
