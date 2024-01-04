package com.passwordManagementSystem.appUser.data.model;

import com.passwordManagementSystem.appUser.DTO.request.AppUserRequest;
import com.passwordManagementSystem.appUser.DTO.request.AppUserUpdate;
import com.passwordManagementSystem.appUser.service.interfaces.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserTest {
  @Autowired
  private AppUserService appUserService;

  private AppUserRequest appUserRequest1;
  private AppUserRequest appUserRequest2;
  private AppUserUpdate appUserUpdate;
    @BeforeEach
    void setUp() {
        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setFirstName("senior goat");
        appUserRequest1.setLastName("goat");
        appUserRequest1.setEmailAddress("appUser1@gmail.com");
        appUserRequest1.setPhoneNumber("09012533092");
        appUserRequest1.setLoginPassword("password");

        appUserRequest2 = new AppUserRequest();
        appUserRequest2.setFirstName("cindyLo");
        appUserRequest2.setLastName("pete");
        appUserRequest2.setEmailAddress("cindyLoPete@gmail.com");
        appUserRequest2.setPhoneNumber("09012533415");
        appUserRequest2.setLoginPassword("password");

        appUserUpdate = new AppUserUpdate();
        appUserUpdate.setFirstName("Anna");
        appUserUpdate.setLastName("madueke");
        appUserUpdate.setPhoneNumber("08104427559");
        appUserUpdate.setId(2);
    }


    @Test
    public void registerUser(){
        assertDoesNotThrow(() -> {
          appUserService.registerAppUser(appUserRequest2);

        });
    }

    @Test
  public void loginUserWith_PasswordAndEmail(){
        assertDoesNotThrow(() -> {
//          appUserService.loginUser("delightMbata@gmail.com","2023");
          appUserService.loginUser("cindyLoPete@gmail.com","password");

        });
  }

   @Test
    public void findByEmail(){
        assertDoesNotThrow(() ->{

            assertNotNull(appUserService.findAppUserByEmail("cindyLoPete@gmail.com"));
//
        });
   }


   @Test
    public void findAppUserById(){
     assertDoesNotThrow(()->{
         appUserService.findAppUserById(1);
     });
   }
   @Test
    public void updateAppUser(){
        assertEquals("madueke",appUserService.updateUser(appUserUpdate).getLastName());
    }

  @Test
    public void deleteAppUser(){
     assertFalse(appUserService.deleteAppUserById(2));
  }

    @Test
    public void logOutUserFromApp(){
        assertDoesNotThrow(()-> {
            assertFalse( appUserService.logOut("cindyLoPete@gmail.com","password"));

        });
    }

    @Test
    void getListOfAllCustomersPassword(){
        assertEquals(1,appUserService.getListOfCustomersPassword("cindyLoPete@gmail.com").size());
//        assertFalse(appUserService.getListOfCustomersPassword("cindyLoPete@gmail.com").isEmpty());
    }

}