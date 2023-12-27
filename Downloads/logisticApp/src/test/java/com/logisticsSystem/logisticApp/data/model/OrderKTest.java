package com.logisticsSystem.logisticApp.data.model;

import com.logisticsSystem.logisticApp.dto.request.OrderRequest;
import com.logisticsSystem.logisticApp.service.interfaces.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderKTest {
  private OrderService orderService;
  private OrderRequest orderRequest;



    @BeforeEach
    void setUp() {

    }

   @Test
    public void createOrder(){
        orderRequest = new OrderRequest();

   }

}