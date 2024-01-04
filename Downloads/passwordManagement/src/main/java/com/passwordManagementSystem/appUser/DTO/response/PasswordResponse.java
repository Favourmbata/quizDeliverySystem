package com.passwordManagementSystem.appUser.DTO.response;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PasswordResponse {
    @ManyToOne(cascade = CascadeType.REMOVE)
    private String userEmail;
    private String password;
    private String title;
}
