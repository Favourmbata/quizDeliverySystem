package com.passwordManagementSystem.appUser.DTO.request;

import com.passwordManagementSystem.appUser.data.model.AppUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PasswordRequest {
    @ManyToOne(cascade = CascadeType.REMOVE)
    private String userEmail;
    private String password;
    private String title;
}
