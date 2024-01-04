package com.passwordManagementSystem.appUser.DTO.response;

import lombok.Data;

@Data
public class ViewPasswordResponse {
    private String customerEmail;
    private String password;
    private String title;

}
