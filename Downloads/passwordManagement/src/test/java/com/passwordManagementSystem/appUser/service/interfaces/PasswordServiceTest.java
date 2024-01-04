package com.passwordManagementSystem.appUser.service.interfaces;

import com.passwordManagementSystem.appUser.DTO.request.PasswordRequest;
import com.passwordManagementSystem.appUser.DTO.request.UpdatePasswordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordServiceTest {
    @Autowired
    private PasswordService passwordService;


    private PasswordRequest passwordRequest;
    private PasswordRequest passwordRequest1;
    private PasswordRequest passwordRequest2;
    private PasswordRequest passwordRequest3;

    private UpdatePasswordRequest updatePasswordRequest;

    @BeforeEach
    void setUp() {
        passwordRequest = new PasswordRequest();
        passwordRequest.setPassword("123daniel@");
        passwordRequest.setUserEmail("cindyLoPete@gmail.com");
        passwordRequest.setTitle("diary");


        passwordRequest1 = new PasswordRequest();
        passwordRequest1.setPassword("philip111$");
        passwordRequest1.setUserEmail("DanielBassey@gmail.com");
        passwordRequest1.setTitle("github");

        passwordRequest2 = new PasswordRequest();
        passwordRequest2.setPassword("dominionC!0");
        passwordRequest2.setUserEmail("favourmbata520@gmail.com");
        passwordRequest2.setTitle("Bible");

        passwordRequest3 = new PasswordRequest();
        passwordRequest3.setPassword("zenithxil@1");
        passwordRequest3.setUserEmail("cindyLoPete@gmail.com");
        passwordRequest3.setTitle("facebook");


        updatePasswordRequest = new UpdatePasswordRequest();
        updatePasswordRequest.setUserEmail("cindyLoPete@gmail.com");
        updatePasswordRequest.setPasswordId(4);
        updatePasswordRequest.setNewPassword("starGirl20#");
        updatePasswordRequest.setTitle("facebook");
    }


    @Test
    void createNewPassword() {
        assertDoesNotThrow(() -> {
            passwordService.createPassword(passwordRequest3);

        });
    }

    @Test
    void updatePassword() {
        assertNotNull(passwordService.updatepassword(updatePasswordRequest));

    }

    @Test
    public void findPasswordByTitleAndCustomerEmail() {

        assertEquals("cindyLoPete@gmail.com",passwordService.findPassword("facebook","cindyLoPete@gmail.com").getPassword());
    }

    @Test
    void testThatWeCanViewPassword(){
        assertEquals("cindyLoPete@gmail.com",passwordService.viewPassword("cindyLoPete@gmail.com","facebook").getCustomerEmail());
        assertEquals("facebook",passwordService.viewPassword("cindyLoPete@gmail.com","facebook").getTitle());
        assertEquals("starGirl20#",passwordService.viewPassword("cindyLoPete@gmail.com","facebook").getPassword());
    }


   @Test
  void findPasswordById(){
        assertDoesNotThrow(()->{
            passwordService.findPasswordById(1);
        });
}


   @Test
    void deletePassword(){
        assertFalse(passwordService.deletePassword("github"));

   }
  @Test
  void deletePasswordWithEmailAndTitle(){
     assertFalse(passwordService.deletePasswordWithIdAndCustomerEmail(3,"favourmbata520@gmail.com"));
  }




}