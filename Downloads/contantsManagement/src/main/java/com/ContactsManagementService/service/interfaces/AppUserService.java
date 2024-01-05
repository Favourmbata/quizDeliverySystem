package com.ContactsManagementService.service.interfaces;


import com.ContactsManagementService.dto.request.AppUserRequest;
import com.ContactsManagementService.dto.response.AppUserResponse;

public interface AppUserService {
    AppUserResponse registerUser(AppUserRequest appUserRequest);

    boolean login(String email, String password);

    boolean logOut(String email, String password);

}
