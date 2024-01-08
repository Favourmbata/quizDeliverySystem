package com.expenseTracker.data.service.interfaces;

import com.expenseTracker.dto.request.AppUserRequest;
import com.expenseTracker.dto.request.UserUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserServiceTest {
    @Autowired
 private AppUserService appUserService;

 private AppUserRequest appUserRequest;
 private  AppUserRequest appUserRequest1;
 private  AppUserRequest appUserRequest2;
 private UserUpdate userUpdate;

    @BeforeEach
    void setUp() {
        appUserRequest = new AppUserRequest();
        appUserRequest.setUserName("Glory");
        appUserRequest.setEmailAddress("GloryNwaeze@gmail.com");
        appUserRequest.setPassword("password");

        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setUserName("Nelson");
        appUserRequest1.setEmailAddress("nelsonDapo90@gmail.com");
        appUserRequest1.setPassword("password1");

        appUserRequest2 = new AppUserRequest();
        appUserRequest2.setUserName("BillGate");
        appUserRequest2.setEmailAddress("BillGate90@gmail.com");
        appUserRequest2.setPassword("password2");

        userUpdate = new UserUpdate();
        userUpdate.setUserName("ChineyeNwa");
        userUpdate.setEmailAddress("GloryNwaeze@gmail.com");
        userUpdate.setId(1);

    }



@Test
    void registerUser(){
   assertDoesNotThrow(()->{
//       appUserService.registerUser(appUserRequest);
       appUserService.registerUser(appUserRequest2);
   });
}
  @Test
    void loginUser(){
//        assertTrue(appUserService.login("password","GloryNwaeze@gmail.com"));
//        assertTrue(appUserService.login("password1","nelsonDapo90@gmail.com"));
        assertTrue(appUserService.login("password2","BillGate90@gmail.com"));

  }

  @Test
    void updateUser(){
      assertNotNull(appUserService.update(userUpdate));
  }


   @Test
    void deleteUser(){
        assertFalse(appUserService.deleteById(2));
   }


}