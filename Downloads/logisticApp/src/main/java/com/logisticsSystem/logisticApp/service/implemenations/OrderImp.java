package com.logisticsSystem.logisticApp.service.implemenations;


import com.logisticsSystem.logisticApp.data.repository.OrderRepository;
import com.logisticsSystem.logisticApp.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public  class OrderImp    {

    private final OrderRepository orderRepository;


}