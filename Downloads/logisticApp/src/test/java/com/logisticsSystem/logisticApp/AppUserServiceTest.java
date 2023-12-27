package com.logisticsSystem.logisticApp;

import com.logisticsSystem.logisticApp.data.model.AppUserType;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.UserRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    private UserRequest userRequest1;
    private UserRequest userRequest2;
    private UserRequest userRequest3;
    private UserRequest userRequest4;



    private UpdateUserRequest userUpdate;


    @BeforeEach
    void setUp() {


        userRequest1 = new UserRequest();
        userRequest1.setUsername("samuel");
        userRequest1.setEmail("samuelShola123@gmail.com");
        userRequest1.setPassword("1990");
        userRequest1.setAppUserType(AppUserType.CUSTOMER);


        userRequest2 = new UserRequest();
        userRequest2.setUsername("bella");
        userRequest2.setEmail("ibuchiChristopher63@gmail.com");
        userRequest2.setPassword("1510");
        userRequest2.setAppUserType(AppUserType.CUSTOMER);


        userRequest3 = new UserRequest();
        userRequest3.setUsername("angel");
        userRequest3.setEmail("angelMan63@gmail.com");
        userRequest3.setPassword("1111");
        userRequest3.setAppUserType(AppUserType.CUSTOMER);

        userRequest4 = new UserRequest();
        userRequest4.setUsername("dera");
        userRequest4.setEmail("deragirl@gmail.com");
        userRequest4.setPassword("2020");
        userRequest4.setAppUserType(AppUserType.CUSTOMER);


        userUpdate = new UpdateUserRequest();


    }


    @Test
    public void createUser_withEmailPassword() {


        assertDoesNotThrow(() -> {
//		  appUserService.register(userRequest1);
//		  appUserService.register(userRequest2);
//		  appUserService.register(userRequest3);
            appUserService.register(userRequest4);
        });

    }
    @Test
    public void loginUser_withPasswordAndEmail() {
//		assertTrue(appUserService.loginUser("samuelShola123@gmail.com",userRequest1.getPassword()));
//		assertTrue(appUserService.loginUser("angelMan63@gmail.com",userRequest3.getPassword()));
        assertTrue(appUserService.loginUser("deragirl@gmail.com",userRequest4.getPassword()));
    }
    @Test
    public void updateUserAccount_nameAndEmail() {
        userUpdate.setUsername("shola");
        userUpdate.setEmail("samuelShola123@gmail.com");
        userUpdate.setPassword("4040");
        userUpdate.setAppUserType(AppUserType.CUSTOMER);
        assertNotNull(appUserService.updateAccount(userUpdate));
    }

    @Test
    public void delete_OneUserAccount() {
//        assertTrue(appUserService.deleteAccount("angelMan63@gmail.com"));
    }
}
