package com.ContactsManagementService.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

}
