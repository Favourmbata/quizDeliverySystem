package com.logisticsSystem.logisticApp.dto.request;

import com.logisticsSystem.logisticApp.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    public List<Product> listOfProducts = new ArrayList<>();
    private  int riderNumber;
    private double paymentReceipt;
}
