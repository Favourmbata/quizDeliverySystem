package com.logisticsSystem.logisticApp.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class ProductUpdate {
    private  String ProductName;
    private int quantity;
    private long product_Price;

}
