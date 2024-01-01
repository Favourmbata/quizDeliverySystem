package com.logisticsSystem.logisticApp.data.repository;

import com.logisticsSystem.logisticApp.data.model.AddressT;
import com.logisticsSystem.logisticApp.data.model.OrderK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository <OrderK,Long> {




}
