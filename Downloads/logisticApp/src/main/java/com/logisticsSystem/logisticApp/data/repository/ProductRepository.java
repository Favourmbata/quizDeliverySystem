package com.logisticsSystem.logisticApp.data.repository;

import com.logisticsSystem.logisticApp.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long> {
    boolean existsByNameAndCustomer_Email(String name, String customerEmail);


    Product findByNameAndCustomerEmail(String name, String customerEmail);



}
