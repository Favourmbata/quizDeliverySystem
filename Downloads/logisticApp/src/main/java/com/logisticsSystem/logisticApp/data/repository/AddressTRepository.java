package com.logisticsSystem.logisticApp.data.repository;

import com.logisticsSystem.logisticApp.data.model.AddressT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressTRepository extends JpaRepository<AddressT,Long> {

    boolean existsByHouseNoAndStreetAddressAndLocalGovtArea(String houseNo, String streetAddress, String localGovtArea);
}
