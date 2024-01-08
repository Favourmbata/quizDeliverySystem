package com.expenseTracker.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AppUserRequest {
    private String userName;
    private String emailAddress;
    private String password;
}
