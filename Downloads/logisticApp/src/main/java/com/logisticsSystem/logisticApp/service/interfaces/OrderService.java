package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.OrderK;
import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.dto.request.OrderRequest;
import com.logisticsSystem.logisticApp.dto.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService {


    OrderResponse placeOrder(OrderRequest orderRequest);

}
