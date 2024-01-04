package com.passwordManagementSystem.appUser.DTO.request;

import com.passwordManagementSystem.appUser.data.model.AppUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdatePasswordRequest {
    private String title;
    private String newPassword;
    private String userEmail;
    private long passwordId;
}
