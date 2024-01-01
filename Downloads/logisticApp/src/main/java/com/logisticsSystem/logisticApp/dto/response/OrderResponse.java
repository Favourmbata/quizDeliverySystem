package com.logisticsSystem.logisticApp.dto.response;

import com.logisticsSystem.logisticApp.data.model.*;
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

    private String productNameQ;
    private String customerEmail;
    private long pickUpAddressId;
    private long deliveryAddressId;

}
