package com.logisticsSystem.logisticApp.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class OrderK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public final List <Product> listOfProducts = new ArrayList<>();

    private  int riderNumber;

    private double paymentReceipt;

    @ManyToOne
    private AppUser customer;

    @ManyToOne
    private AppUser dispatch_Rider;

}
