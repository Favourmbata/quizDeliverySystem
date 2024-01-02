package com.passwordManagementSystem.appUser.service.interfaces;

import com.passwordManagementSystem.appUser.DTO.request.AppUserRequest;
import com.passwordManagementSystem.appUser.DTO.request.AppUserUpdate;
import com.passwordManagementSystem.appUser.DTO.response.AppUserResponse;
import com.passwordManagementSystem.appUser.data.model.AppUser;
import org.springframework.stereotype.Service;


public interface AppUserService {
    AppUserResponse registerAppUser(AppUserRequest appUserRequest);


    boolean loginUser(String email, String password);

    AppUser findAppUserByEmail(String email);

    AppUser findAppUserById(long appUserId);

    AppUserResponse updateUser(AppUserUpdate appUserUpdate);


    boolean deleteAppUserById(long appUserId);

    boolean logOut(String email, String password);

}
