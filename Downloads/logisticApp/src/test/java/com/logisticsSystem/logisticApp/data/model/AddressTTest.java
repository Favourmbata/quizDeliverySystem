package com.logisticsSystem.logisticApp.data.model;

import com.logisticsSystem.logisticApp.dto.request.AddressTRequest;
import com.logisticsSystem.logisticApp.service.interfaces.AddressTService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressTTest {
    @Autowired
    private AddressTService addressTService;


    private AddressT pickUpAddress;
    private AddressT deliverAddress;
    @BeforeEach
    void setUp() {
        pickUpAddress = new AddressT();
        pickUpAddress.setHouseNo("No314");
        pickUpAddress.setStreetAddress("onukubeh");
        pickUpAddress.setLocalGovtArea("Ikwerre Local Govt");
        pickUpAddress.setCustomerEmail("DorcasGodwill@gmail.com");


        deliverAddress = new AddressT();
        deliverAddress.setHouseNo("No40");
        deliverAddress.setStreetAddress("lawal's street");
        deliverAddress.setLocalGovtArea("Ikwerre Local Govt");
        deliverAddress.setCustomerEmail("steveMaduka@gmail.com");

    }

    @Test
       public void createPickUpAddress(){
        assertEquals(AddressType.Pickup_Address,addressTService.createPickUpAddress(pickUpAddress));
    }

   @Test
   public void  createDeliveryAddress(){
        assertEquals(AddressType.Delivery_Address,addressTService.createDeliveryAddress(deliverAddress));
   }


}