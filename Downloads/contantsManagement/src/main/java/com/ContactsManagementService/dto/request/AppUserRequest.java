package com.ContactsManagementService.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private  String address;
    private String password;
    private LocalDateTime registrationDate;
}
