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
    private ProductRequest productRequest4;
    private ProductRequest productRequest5;
    private AppUser appUser1;
    private AppUser appUser2;

    private ProductUpdate productUpdate;
    public
    @BeforeEach
    void setUp() {


        appUser1 = new AppUser();
        appUser1.setUsername("dera");
        appUser1.setPassword("password");
        appUser1.setEmail("shepardl@gmail.com");
        appUser1.setAppUserType(AppUserType.CUSTOMER);

        appUser2 = new AppUser();
        appUser2.setUsername("Darling");
        appUser2.setPassword("password");
        appUser2.setEmail("mbatafavour123@gmail.com");
        appUser2.setAppUserType(AppUserType.CUSTOMER);

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
        productRequest1.setCustomer(savedAppUser);



        productRequest3 = new ProductRequest();
        productRequest3. setProductName("noodles");
        productRequest3.setProduct_Price(5000);
        productRequest3.setQuantity(4);
        AppUser saveAppUser = appUserService.saveAppUser(appUser1);
        productRequest2.setCustomer(saveAppUser);





        productRequest4 = new ProductRequest();
        productRequest4. setProductName("salt");
        productRequest4.setProduct_Price(500);
        productRequest4.setQuantity(4);
        AppUser saveApp = appUserService.saveAppUser(appUser2);
        productRequest4.setCustomer(saveApp);

        productRequest5 = new ProductRequest();
        productRequest5. setProductName("egusi");
        productRequest5.setProduct_Price(500);
        productRequest5.setQuantity(10);
        AppUser savepp1 = appUserService.saveAppUser(appUser2);
        productRequest5.setCustomer(savepp1);


        productUpdate = new ProductUpdate();
        productUpdate.setProductName("cookies");
        productUpdate.setQuantity(4);
        productUpdate.setProduct_Price(2000);
        AppUser savedApp = appUserService.saveAppUser(appUser1);
        productRequest1.setCustomer(savedApp);
    }

@Test
   public void  createProduct(){
     assertDoesNotThrow (()-> {
         productService.createProduct(productRequest1);
         productService.createProduct(productRequest2);
         productService.createProduct(productRequest3);
           productService.createProduct(productRequest4);
         productService.createProduct(productRequest5);

     });

}

@Test
    public void findProduct_withProductNameAndUserEmail(){
//      assertNotNull(productService.findProduct("Peak","deragirl@gmail.com"));
//      assertNotNull(productService.findProduct("Peak","samuelshola123@gmail.com"));


    assertEquals("egusi",productService.findProduct("egusi","mbatafavour123@gmail.com").getName());

   //   assertNotNull(productService.findProduct("egusi","samuelshola123@gmail.com"));
}

@Test
public void updateProduct(){
   assertNotNull( productService.updateProduct("cookies","mbatafavour123@gmail.com"));
}

//  @Test
//    public void deleteProduct(){
//        assertTrue(productService.delete_Product("chocolate","beauty123@gmail.com"));
//  }
}