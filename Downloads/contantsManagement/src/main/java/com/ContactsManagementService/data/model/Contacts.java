package com.ContactsManagementService.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private LocalDateTime createdTime;
    @ManyToOne
    private AppUser appUser;



}
