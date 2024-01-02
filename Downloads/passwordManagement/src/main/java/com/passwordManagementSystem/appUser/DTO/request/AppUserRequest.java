package com.passwordManagementSystem.appUser.DTO.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AppUserRequest {
    private String emailAddress;
    private String phoneNumber;
    private  String firstName;
    private String lastName;
    private  String loginPassword;
}
