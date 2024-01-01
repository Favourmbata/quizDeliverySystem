package com.logisticsSystem.logisticApp.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AddressTResponse {
    private String houseNo;
    private String streetAddress;
    private String localGovtArea;
    private String customerEmail;
}
