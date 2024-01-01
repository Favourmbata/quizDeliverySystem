package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.AddressT;
import com.logisticsSystem.logisticApp.data.model.AddressType;

public interface AddressTService {
    AddressT saveUser(AddressT addressT);


    AddressT findAddressById(long deliveryAddressId);

    AddressType createPickUpAddress(AddressT pickUpAddress);

    AddressType createDeliveryAddress(AddressT deliverAddress);

}
