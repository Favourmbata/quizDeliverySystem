package com.passwordManagementSystem.appUser.DTO.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserUpdate {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private long id;

}
