package com.expenseTracker.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String emailAddress;
    private String password;
    private  boolean isLogin;
    @OneToMany
    private Set<Category>categories;
}
