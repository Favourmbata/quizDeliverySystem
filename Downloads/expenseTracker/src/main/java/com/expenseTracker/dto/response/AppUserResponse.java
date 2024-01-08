package com.expenseTracker.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AppUserResponse {
    private String userName;
    private String emailAddress;
    private String password;
}
