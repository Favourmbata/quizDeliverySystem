package com.passwordManagementSystem.appUser.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@RequiredArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String emailAddress;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String loginPassword;
    @Column(name = "is_login",columnDefinition = "BOOLEAN")
    private boolean isLogin;
    private LocalDateTime registrationDate;
}
