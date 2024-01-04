package com.passwordManagementSystem.appUser.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private AppUser customer;
    private String password;
    private String title;
    private LocalDate creationDate;
}
