package com.quizDeliverySystem.quizDeliverySystem.controller;

import com.quizDeliverySystem.quizDeliverySystem.dto.request.StudentRequest;
import com.quizDeliverySystem.quizDeliverySystem.dto.request.UpdateRequest;
import com.quizDeliverySystem.quizDeliverySystem.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Api ")
public class StudentController {

   private final StudentService studentService;
   @PostMapping("registerStudent")

  public ResponseEntity<?>registerStudent(@RequestBody StudentRequest studentRequest){
       return new ResponseEntity<>(studentService.registerStudent(studentRequest), HttpStatus.ACCEPTED);
  }


    @GetMapping("loginUser")
    public ResponseEntity <?> loginUser(@RequestParam  String emailAddress,@RequestParam String password){
        return new ResponseEntity<>(studentService.login( emailAddress,password),HttpStatus.OK);
    }


    @PostMapping("updateUser")
    public ResponseEntity <?> updateUser(@RequestBody UpdateRequest updateRequest){
        return new ResponseEntity<>(studentService.updateUser(updateRequest),HttpStatus.OK);
    }

    @GetMapping("deleteByEmailAddress")
    public ResponseEntity <?>deleteUser(@RequestParam String emailAddress){
        return new ResponseEntity<>(studentService.deleteStudent(emailAddress),HttpStatus.ACCEPTED);
    }


}
