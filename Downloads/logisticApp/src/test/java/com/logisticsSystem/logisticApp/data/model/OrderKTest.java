package com.logisticsSystem.logisticApp.data.model;

import com.logisticsSystem.logisticApp.dto.request.OrderRequest;
import com.logisticsSystem.logisticApp.dto.request.AppUserRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AddressTService;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderKTest {
    @Autowired
    private OrderService orderService;




   private  OrderRequest orderRequest;



    @BeforeEach
    void setUp() {
     orderRequest = new OrderRequest();
    orderRequest.setCustomerEmail("mbatafavour123@gmail.com");
    orderRequest.setProductNameQ("StockFish");
    orderRequest.setPickUpAddressId(4);
    orderRequest.setDeliveryAddressId(2);






    }

    @Test
    public void placeOrder() {
          assertDoesNotThrow(() -> {
//              UserRequest dispatchRiderRequest =  new UserRequest();
//              AppUser dispatchRider = appUserService.registerDispatchRider(dispatchRiderRequest);
            orderService.placeOrder(orderRequest);


        });


    }
}