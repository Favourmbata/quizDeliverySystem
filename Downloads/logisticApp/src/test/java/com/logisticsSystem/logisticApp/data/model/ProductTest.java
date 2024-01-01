package com.logisticsSystem.logisticApp.data.model;

import com.logisticsSystem.logisticApp.data.repository.ProductRepository;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    @Autowired
    private ProductService productService;

    @Autowired
    AppUserService appUserService;

    private ProductRequest productRequest1;
    private ProductRequest productRequest2;
    private ProductRequest productRequest3;



    private AppUser appUser1;
    private AppUser appUser2;
    private AppUser appUser3;



    private ProductUpdate productUpdate;

    public
    @BeforeEach
    void setUp() {


        appUser1 = new AppUser();
        appUser1.setUsername("david");
        appUser1.setPassword("1111");
        appUser1.setEmail("shepardl@gmail.com");
        appUser1.setAppUserType(AppUserType.CUSTOMER);

        appUser2 = new AppUser();
        appUser2.setUsername("favour");
        appUser2.setPassword("1313");
        appUser2.setEmail("mbatafavour123@gmail.com");
        appUser2.setAppUserType(AppUserType.CUSTOMER);


        appUser3 = new AppUser();
        appUser3.setUsername("Ibuchi");
        appUser3.setPassword("2006");
        appUser3.setEmail("ibuchiChristopher63@gmail.com");
        appUser3.setAppUserType(AppUserType.CUSTOMER);





        productRequest1 = new ProductRequest();
        productRequest1.setProductName("Peak");
        productRequest1.setProduct_Price(2500);
        productRequest1.setQuantity(5);
        productRequest1.setCustomer(appUser1);



        productRequest2 = new ProductRequest();
        productRequest2.setProductName("chocolate");
        productRequest2.setProduct_Price(1500);
        productRequest2.setQuantity(10);
        AppUser savedAppUser = appUserService.saveAppUser(appUser2);
        productRequest2.setCustomer(savedAppUser);


        productRequest3 = new ProductRequest();
        productRequest3.setProductName("noodles");
        productRequest3.setProduct_Price(5000);
        productRequest3.setQuantity(4);
        AppUser saveAppUser = appUserService.saveAppUser(appUser3);
        productRequest3.setCustomer(saveAppUser);





        productUpdate = new ProductUpdate();
        productUpdate.setProductName("egusi");
        productUpdate.setCustomerEmail("mbatafavour123@gmail.com");
        productUpdate.setQuantity(4);
        productUpdate.setProduct_Price(2000);

    }

    @Test
    public void createProduct() {
        assertDoesNotThrow(() -> {
          productService.createProduct(productRequest1);
          productService.createProduct(productRequest2);
          productService.createProduct(productRequest3);



        });

    }

    @Test
    public void findProduct_withProductNameAndUserEmail() {
        assertEquals("Peak", productService.findProduct("Peak", "shepardl@gmail.com").getName());
        assertEquals("chocolate", productService.findProduct("chocolate", "mbatafavour123@gmail.com").getName());
        assertEquals("noodles", productService.findProduct("noodles", "favourDenis@gmail.com").getName());
        assertEquals("salt", productService.findProduct("salt", "charityOsisiagu@gmail.com").getName());


    }




    @Test
    public void updateProduct() {
        assertNotNull(productService.updateProduct(productUpdate));
    }

    @Test
    public void deleteProduct() {
        assertEquals("chocolate",productService.delete_Product("chocolate","shepardl@gmail.com"));
        assertFalse(productService.delete_Product("salt","mbatafavour123@gmail.com"));
//        assertFalse(productService.delete_Product("onions", "favourDenis@gmail.com"));
    }



}