package com.ToDo.List.ToDo.List.appUser.DTO.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private  String password;

}
