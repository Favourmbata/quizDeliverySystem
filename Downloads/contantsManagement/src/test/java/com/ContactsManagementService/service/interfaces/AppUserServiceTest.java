package com.ContactsManagementService.service.interfaces;

import com.ContactsManagementService.dto.request.AppUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserServiceTest {
    @Autowired
 private AppUserService appUserService;
    private AppUserRequest appUserRequest;
    private AppUserRequest appUserRequest1;
    @BeforeEach
    void setUp() {
        appUserRequest = new AppUserRequest();
        appUserRequest.setFirstName("best");
        appUserRequest.setLastName("John");
        appUserRequest.setEmailAddress("bestJohn@gmail.com");
        appUserRequest.setPhoneNumber("09012533093");
        appUserRequest.setPassword("tally4");
        appUserRequest.setAddress("No54 AmazingGrace Road Rumuodumaya");
        appUserRequest.setRegistrationDate(LocalDateTime.now());

        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setFirstName("ada");
        appUserRequest1.setLastName("ozor");
        appUserRequest1.setEmailAddress("adaOzor60@gmail.com");
        appUserRequest1.setPhoneNumber("09012533097");
        appUserRequest1.setPassword("billygirl$");
        appUserRequest1.setAddress("No54 okota Road Bariga");
        appUserRequest1.setRegistrationDate(LocalDateTime.now());
    }

    @Test
    void registerUser(){
        assertDoesNotThrow(()->{
            appUserService.registerUser(appUserRequest);
            appUserService.registerUser(appUserRequest1);
        });
    }

     @Test
     void login(){
        assertTrue(appUserService.login("bestJohn@gmail.com","tally4"));
        assertTrue(appUserService.login("adaOzor60@gmail.com","billygirl$"));
     }

   @Test
    void logOut(){
        assertFalse(appUserService.logOut("adaOzor60@gmail.com","billygirl$"));
   }
}