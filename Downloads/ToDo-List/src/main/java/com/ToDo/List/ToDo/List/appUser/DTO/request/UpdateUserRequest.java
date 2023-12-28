package com.ToDo.List.ToDo.List.appUser.DTO.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
}
