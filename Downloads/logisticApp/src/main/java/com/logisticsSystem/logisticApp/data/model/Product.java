package com.logisticsSystem.logisticApp.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Product {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private AppUser customer;
    private  String name;
    private int quantity;
    private  long product_Price;
    private LocalDateTime dateCreated;


}
