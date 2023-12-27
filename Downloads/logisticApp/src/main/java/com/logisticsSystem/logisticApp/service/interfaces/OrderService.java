package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.OrderK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService extends JpaRepository <OrderK,Long>{
}
