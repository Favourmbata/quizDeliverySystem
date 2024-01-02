package com.passwordManagementSystem.appUser.DTO.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponse {
    private String emailAddress;
    private String phoneNumber;
    private  String firstName;
    private String lastName;

}
