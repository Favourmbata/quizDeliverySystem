package com.ToDo.List.ToDo.List.appUser.service.interfaces;

import com.ToDo.List.ToDo.List.appUser.DTO.request.UpdateUserRequest;
import com.ToDo.List.ToDo.List.appUser.DTO.request.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;
    private UpdateUserRequest updateUserRequest;


    private UserRegisterRequest userRegisterRequest;
    private UserRegisterRequest userRegisterRequest1;
    private UserRegisterRequest userRegisterRequest2;

    @BeforeEach
    void setUp() {


        userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("samuel");
        userRegisterRequest.setLastName("Mbata");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setEmail("favour123@gmal.com");

        userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setFirstName("samuel");
        userRegisterRequest2.setLastName("Mbata");
        userRegisterRequest2.setPassword("password");
        userRegisterRequest2.setEmail("megaGoat@gmal.com");


        userRegisterRequest1 = new UserRegisterRequest();
        userRegisterRequest1.setFirstName("favour");
        userRegisterRequest1.setLastName("Mbata");
        userRegisterRequest1.setPassword("password");
        userRegisterRequest1.setEmail("shola650@gmail.com");

        updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setEmail("favour123@gmal.com");
        updateUserRequest.setFirstName("faith");
        updateUserRequest.setLastName("Emeka");


    }

    @Test
    public void registerUser() {

        assertDoesNotThrow(() -> {
//            appUserService.registerUser(userRegisterRequest);
//            appUserService.registerUser(userRegisterRequest1);
//            appUserService.registerUser(userRegisterRequest2);
        });


    }


    @Test
    public void loginUser_withPasswordAndEmail() {

        assertTrue(appUserService.loginUser("favour123@gmal.com", userRegisterRequest.getPassword()));
    }


    @Test
    public void updateUserUserAccount() {
        assertNotNull(appUserService.updateUser(updateUserRequest));
    }

  @Test
    public void deleteUserAccount(){
       assertTrue( appUserService.deleteUser("megaGoat@gmal.com"));

  }


}