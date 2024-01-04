package com.passwordManagementSystem.appUser.service.interfaces;

import com.passwordManagementSystem.appUser.DTO.request.PasswordRequest;
import com.passwordManagementSystem.appUser.DTO.request.UpdatePasswordRequest;
import com.passwordManagementSystem.appUser.DTO.response.PasswordResponse;
import com.passwordManagementSystem.appUser.DTO.response.ViewPasswordResponse;
import com.passwordManagementSystem.appUser.data.model.Password;

public interface PasswordService {


    PasswordResponse createPassword(PasswordRequest passwordRequest);


     PasswordResponse updatepassword(UpdatePasswordRequest updatePasswordRequest);


    Password findPassword(String title, String customerEmail);

    boolean deletePassword(String passwordTitle);

    Password findPasswordById(long passwordId);

    boolean deletePasswordWithIdAndCustomerEmail(long passwordId, String customerEmail);

    ViewPasswordResponse viewPassword(String email, String title);

}
