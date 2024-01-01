package com.logisticsSystem.logisticApp.dto.request;

import com.logisticsSystem.logisticApp.data.model.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@RequiredArgsConstructor
public class OrderRequest {

    private String productNameQ;
    private String customerEmail;
    private long pickUpAddressId;
    private long deliveryAddressId;




}
