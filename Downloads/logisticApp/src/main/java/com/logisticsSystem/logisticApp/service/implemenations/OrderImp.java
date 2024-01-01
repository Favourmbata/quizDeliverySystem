package com.logisticsSystem.logisticApp.service.implemenations;


import com.logisticsSystem.logisticApp.data.model.*;
import com.logisticsSystem.logisticApp.data.repository.OrderRepository;
import com.logisticsSystem.logisticApp.dto.request.OrderRequest;
import com.logisticsSystem.logisticApp.dto.response.OrderResponse;
import com.logisticsSystem.logisticApp.service.interfaces.AddressTService;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.OrderService;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderImp implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final AppUserService appUserService;
    private final AddressTService addressTService;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        AppUser customer = appUserService.findUserByEmail(orderRequest.getCustomerEmail());
        Product foundProduct = productService.findProduct(orderRequest.getProductNameQ(), orderRequest.getCustomerEmail());
        AddressT deliveryAddress = addressTService.findAddressById(orderRequest.getDeliveryAddressId());
        AddressT pickUpAddress = addressTService.findAddressById(orderRequest.getPickUpAddressId());
        if (customer.getAppUserType() != AppUserType.CUSTOMER)
            throw new RuntimeException("You must be a customer to place order");
        if (pickUpAddress.getAddressType() != AddressType.Pickup_Address)
            throw new RuntimeException("please place a pickUp address");
        if (deliveryAddress.getAddressType() != AddressType.Delivery_Address)
            throw new RuntimeException("please a delivery address");

        OrderK orderK = new OrderK();
        orderK.setProduct(foundProduct);
        orderK.setCustomer(customer);
        orderK.setDeliveryAddress(deliveryAddress);
        orderK.setPickUpAddress(pickUpAddress);
        orderK.setDateCreated(LocalDateTime.now());
        OrderK saveOrder = orderRepository.save(orderK);

        OrderResponse orderResponse = new OrderResponse();
       orderResponse.setCustomerEmail(saveOrder.getCustomer().getEmail());
       orderResponse.setProductNameQ(saveOrder.getProduct().getName());
       orderResponse.setDeliveryAddressId(saveOrder.getDeliveryAddress().getId());
       orderResponse.setPickUpAddressId(saveOrder.getPickUpAddress().getId());
        return orderResponse;
    }
}