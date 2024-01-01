package com.logisticsSystem.logisticApp.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

public class AddressT {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
@Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String houseNo;
    private String streetAddress;
    private String localGovtArea;
    private String customerEmail;
}
