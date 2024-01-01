package com.logisticsSystem.logisticApp.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class OrderK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private  AppUser customer;
    @ManyToOne
    private  AddressT pickUpAddress;
    @ManyToOne
    private AddressT deliveryAddress;
    private LocalDateTime dateCreated;
}
