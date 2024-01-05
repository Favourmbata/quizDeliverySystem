package com.ContactsManagementService.dto.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

}
