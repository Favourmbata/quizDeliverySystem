package com.ContactsManagementService.dto.request;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AppUserUpdate {
    @Id
    private long contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
}
