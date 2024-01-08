package com.expenseTracker.data.service.interfaces;

import com.expenseTracker.data.model.AppUser;
import com.expenseTracker.dto.request.CategoryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceTest {
@Autowired
    private CategoryService categoryService;
    private CategoryRequest categoryRequest;
    private CategoryRequest categoryRequest1;

    private AppUser appUser1;
    private AppUser appUser2;

    @BeforeEach
    void setUp() {


        appUser1 = new AppUser();
        appUser1.setEmailAddress("GloryNwaeze@gmail.com");
        appUser1.setUserName("ChineyeNwa");
        appUser1.setCategories(appUser1.getCategories());
        appUser1.setPassword("password");
        appUser1.setId(1);

        appUser2 = new AppUser();
        appUser2.setEmailAddress("BillGate90@gmail.com");
        appUser2.setUserName("BillGate");
        appUser2.setCategories(appUser2.getCategories());
        appUser2.setPassword("password");
        appUser2.setId(1);




        categoryRequest = new CategoryRequest();
        categoryRequest.setUserName("Travel");
        categoryRequest.setId(1);

        categoryRequest1 = new CategoryRequest();
        categoryRequest1.setUserName("Student Loan");
        categoryRequest1.setId(3);

    }
  @Test
    void createCategory(){
        assertDoesNotThrow(()->{
             categoryService.createCategory(categoryRequest);
             categoryService.createCategory(categoryRequest1);
        });
//   assertTrue(categoryService.nameOfCategory("Travel",1));

  }


}