package com.ContactsManagementService.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long UserId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private  String address;
    private String password;
    private  boolean isLogin;
    private LocalDateTime registrationDate;
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "appUser" ,fetch = FetchType.EAGER)
private List<Contacts> listOfContacts = new ArrayList<>();

}
