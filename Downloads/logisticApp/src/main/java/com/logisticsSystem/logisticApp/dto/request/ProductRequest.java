package com.logisticsSystem.logisticApp.dto.request;

import com.logisticsSystem.logisticApp.data.model.AddressT;
import com.logisticsSystem.logisticApp.data.model.AddressType;
import com.logisticsSystem.logisticApp.data.model.AppUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ProductRequest {

    private AppUser customer;
    private  String ProductName;
    private int quantity;
    private long product_Price;
    private String customerEmail;
    private AddressT deliveryAddress;
    private AddressT pick_upAddress;




}
