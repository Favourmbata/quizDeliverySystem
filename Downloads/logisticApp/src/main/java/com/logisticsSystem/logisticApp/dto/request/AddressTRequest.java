package com.logisticsSystem.logisticApp.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter@RequiredArgsConstructor
public class AddressTRequest {
    private String houseNo;
    private String streetAddress;
    private String localGovtArea;
    private String customerEmail;
}
