package com.expenseTracker.dto.request;

import lombok.Data;

@Data
public class UserUpdate {

    private long id;
    private String userName;
    private String emailAddress;
}
