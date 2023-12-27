package com.logisticsSystem.logisticApp.dto.response;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.model.Product;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
public class OrderResponse {
    public List<Product> listOfProducts = new ArrayList<>();
    private  int riderNumber;
    private double paymentReceipt;

    private AppUser customer;
    private AppUser dispatch_Rider;

}
