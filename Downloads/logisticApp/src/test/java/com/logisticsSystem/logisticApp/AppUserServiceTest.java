package com.logisticsSystem.logisticApp;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.model.AppUserType;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.AppUserRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
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
    @Autowired
    private ProductService productService;
   private ProductUpdate productUpdate;

    private AppUser appUser1 ;
    private AppUser appUser2 ;
    private AppUser appUser3;
    private AppUserRequest appUserRequest1;
    private AppUserRequest appUserRequest2;
    private ProductRequest productRequest1;
    private ProductRequest productRequest2;
    private ProductRequest productRequest3;

    private AppUserRequest userRequest3;



    private UpdateUserRequest userUpdate;


    @BeforeEach
    void setUp(){

        appUser1 = new AppUser();

        appUser1 = new AppUser();
        appUser1.setUsername("david");
        appUser1.setPassword("1111");
        appUser1.setEmail("shepardl@gmail.com");
        appUser1.setCreatedDate(LocalDateTime.now());
        appUser1.setAppUserType(AppUserType.CUSTOMER);



        appUser2 = new AppUser();
        appUser2.setUsername("favour");
        appUser2.setPassword("1313");
        appUser2.setEmail("mbatafavour123@gmail.com");
        appUser2.setCreatedDate(LocalDateTime.now());
        appUser2.setAppUserType(AppUserType.CUSTOMER);

        appUser3 = new AppUser();
        appUser3.setUsername("Ibuchi");
        appUser3.setPassword("2006");
        appUser3.setEmail("ibuchiChristopher63@gmail.com");
        appUser3.setCreatedDate(LocalDateTime.now());
        appUser3.setAppUserType(AppUserType.CUSTOMER);



        productRequest1 = new ProductRequest();
       productRequest1.setProductName("Plantain");
       productRequest1.setProduct_Price(4500);
       productRequest1.setQuantity(6);
       productRequest1.setCustomerEmail("shepardl@gmail.com");
       AppUser saveUser = appUserService.saveAppUser(appUser1);
      productRequest1.setCustomer(saveUser);

        productRequest2 = new ProductRequest();
        productRequest2.setProductName("StockFish");
        productRequest2.setProduct_Price(8000);
        productRequest2.setQuantity(10);
        productRequest2.setCustomerEmail("mbatafavour123@gmail.com");
        AppUser saveUser1 = appUserService.saveAppUser(appUser2);
        productRequest2.setCustomer(saveUser1);


        productRequest3 = new ProductRequest();
        productRequest3.setProductName("PowerOil");
        productRequest3.setProduct_Price(20000);
        productRequest3.setQuantity(6);
        productRequest3.setCustomerEmail("shepardl@gmail.com");
        AppUser save = appUserService.saveAppUser(appUser1);
        productRequest3.setCustomer(save);

       productUpdate = new ProductUpdate();
       productUpdate.setProductName("StockFish");
       productUpdate.setProduct_Price(15000);
       productUpdate.setCustomerEmail("mbatafavour123@gmail.com");


        appUserRequest1 = new AppUserRequest();
        appUserRequest1.setUsername("samuel");
        appUserRequest1.setEmail("samuelShola123@gmail.com");
        appUserRequest1.setPassword("1990");
        appUserRequest1.setAppUserType(AppUserType.CUSTOMER);


        appUserRequest2 = new AppUserRequest();
        appUserRequest2.setUsername("bella");
        appUserRequest2.setEmail("ibuchiChristopher63@gmail.com");
        appUserRequest2.setPassword("1510");
        appUserRequest2.setAppUserType(AppUserType.CUSTOMER);


        userRequest3 = new AppUserRequest();
        userRequest3.setUsername("angel");
        userRequest3.setEmail("angelMan63@gmail.com");
        userRequest3.setPassword("1111");
        userRequest3.setAppUserType(AppUserType.CUSTOMER);



        userUpdate = new UpdateUserRequest();


    }


    @Test
    public void createUser_withEmailPassword() {


        assertDoesNotThrow(() -> {
		  appUserService.registerCustomer(appUserRequest1);
		  appUserService.registerCustomer(appUserRequest2);
		  appUserService.registerCustomer(userRequest3);

        });

    }

    @Test
    public void loginUser_withPasswordAndEmail() {
        assertTrue(appUserService.loginUser("mbatafavour123@gmail.com","1313"));
		assertTrue(appUserService.loginUser("shepardl@gmail.com","1111"));
		assertTrue(appUserService.loginUser("ibuchiChristopher63@gmail.com", "2006"));
//
//		assertTrue(appUserService.loginUser("angelMan63@gmail.com",userRequest3.getPassword()));




    }

    @Test
    public void updateUserAccount_nameAndEmail() {
        userUpdate.setUsername("Daniel");
        userUpdate.setEmail("mbatafavour123@gmail.com");
        userUpdate.setAppUserType(AppUserType.CUSTOMER);

        assertNotNull(appUserService.updateAccount(userUpdate));
    }

    @Test
    public void delete_OneUserAccount() {

        assertTrue(appUserService.deleteAccount("ibuchiChristopher63@gmail.com"));
//        assertTrue(appUserService.deleteAccount("angelMan63@gmail.com"));
//        assertTrue(appUserService.deleteAccount("queenMbata@gmail.com"));

    }

 @Test
    public void create_product(){
        assertDoesNotThrow(()-> {
            productService.createProduct(productRequest1);
            productService.createProduct(productRequest2);
            productService.createProduct(productRequest3);

        });
 }
  @Test
    public void findProduct_withProductNameAndUserEmail(){
        assertEquals("Plantain",appUserService.findProduct("Plantain","shepardl@gmail.com").getName());
        assertEquals("StockFish",appUserService.findProduct("StockFish","mbatafavour123@gmail.com").getName());
        assertEquals("PowerOil",appUserService.findProduct("PowerOil","shepardl@gmail.com").getName());
  }

@Test
    public void updateProduct_withUserEmailAndProductName(){
        assertNotNull(appUserService.updateProduct(productUpdate));
}

@Test
    public void deleteProduct(){
        assertFalse(productService.delete_Product("PowerOil","shepardl@gmail.com"));
}

@Test
    void registerDispatchRider(){


}
}