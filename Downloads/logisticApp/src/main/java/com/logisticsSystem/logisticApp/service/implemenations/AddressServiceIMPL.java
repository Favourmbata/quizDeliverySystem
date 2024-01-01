package com.logisticsSystem.logisticApp.service.implemenations;

import com.logisticsSystem.logisticApp.data.model.AddressT;
import com.logisticsSystem.logisticApp.data.model.AddressType;
import com.logisticsSystem.logisticApp.data.repository.AddressTRepository;
import com.logisticsSystem.logisticApp.service.interfaces.AddressTService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceIMPL implements AddressTService {
    private final AddressTRepository addressTRepository;

    @Transactional
    @Override
    public AddressT saveUser(AddressT addressT) {
       return addressTRepository.save(addressT);
    }

    @Override
    public AddressT findAddressById(long deliveryAddressId) {
       Optional<AddressT>  foundAddress = addressTRepository.findById(deliveryAddressId);
        if (!foundAddress.isPresent()) throw new RuntimeException("could not find address");
        return foundAddress.get();
    }

    @Override
    public AddressType createPickUpAddress(AddressT pickUpAddress) {

        if (addressTRepository.existsByHouseNoAndStreetAddressAndLocalGovtArea(pickUpAddress.getHouseNo(), pickUpAddress.getStreetAddress(), pickUpAddress.getLocalGovtArea()))
            throw new RuntimeException("address already exist");
          pickUpAddress.setAddressType(AddressType.Pickup_Address);

          return addressTRepository.save(pickUpAddress).getAddressType();
    }

    @Override
    public AddressType createDeliveryAddress(AddressT deliverAddress) {
        if (addressTRepository.existsByHouseNoAndStreetAddressAndLocalGovtArea(deliverAddress.getHouseNo(),deliverAddress.getStreetAddress(),deliverAddress.getLocalGovtArea()))throw new RuntimeException("address already exist");
        deliverAddress.setAddressType(AddressType.Delivery_Address);

        return addressTRepository.save(deliverAddress).getAddressType();
    }


}