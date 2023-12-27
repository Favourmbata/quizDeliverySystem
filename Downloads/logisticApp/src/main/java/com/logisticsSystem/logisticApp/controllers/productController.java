package com.logisticsSystem.logisticApp.controllers;

import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class productController {
    private  final ProductService productService;

    @PostMapping("createproduct")
    public ResponseEntity <?>createProduct(@RequestBody ProductRequest productRequest){


        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.ACCEPTED);
    }

   @GetMapping("findProduct{name}/{customerEmail}")
    public ResponseEntity<?> findProduct(@PathVariable ("name") String name ,@PathVariable ("customerEmail")String customerEmail){

        return new ResponseEntity<>(productService.findProduct(name,customerEmail),HttpStatus.ACCEPTED);
   }


}
