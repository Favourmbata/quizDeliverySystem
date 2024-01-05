package com.ContactsManagementService.service.implementation;

import com.ContactsManagementService.data.model.AppUser;
import com.ContactsManagementService.data.repository.AppUserContactRepository;
import com.ContactsManagementService.dto.request.AppUserRequest;
import com.ContactsManagementService.dto.response.AppUserResponse;
import com.ContactsManagementService.service.interfaces.AppUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AppUserServiceImp implements AppUserService {
    private  final AppUserContactRepository appUserManagementRepository;

    @Override
    public AppUserResponse registerUser(AppUserRequest appUserRequest) {
        AppUser saveUser = mapAndValidateNewAppUser(appUserRequest);
        return AppUserResponse.builder()
                .address(saveUser.getAddress())
                .emailAddress(saveUser.getEmailAddress())
                .firstName(saveUser.getFirstName())
                .lastName(saveUser.getLastName())
                .phoneNumber(saveUser.getPhoneNumber())
                .build();
    }

    private AppUser mapAndValidateNewAppUser(AppUserRequest appUserRequest) {
        if (appUserManagementRepository.existsByEmailAddress(appUserRequest.getAddress()))throw new RuntimeException("email already exist");
        if (appUserManagementRepository.existsByPhoneNumber(appUserRequest.getPhoneNumber()))throw new RuntimeException("phoneNumber exist");

        AppUser fountUser = AppUser.builder()
                .password(encryptPassword(appUserRequest.getPassword()))
                .phoneNumber(appUserRequest.getPhoneNumber())
                .firstName(appUserRequest.getFirstName())
                .lastName(appUserRequest.getFirstName())
                .address(appUserRequest.getAddress())
                .emailAddress(appUserRequest.getEmailAddress())
                .registrationDate(LocalDateTime.now())
                .build();
        return appUserManagementRepository.save(fountUser);

    }
    private String encryptPassword(String password) {
        if (password.contains(" ")) throw new RuntimeException("Encrypt  password()-->  invalid password input");
        byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes);
    }

    public String decryptPassword(String encodedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes);
    }
    @Override
    public boolean login(String email, String password) {
        AppUser foundContact = appUserManagementRepository.findByEmailAddress(email);
        if (foundContact == null)throw new RuntimeException("App User not found");
        String encryptedLoginPassword = encryptPassword(password);
        if (!foundContact.getPassword().equalsIgnoreCase(encryptedLoginPassword))throw new RuntimeException("incorrect password");
        foundContact.setLogin(true);
        return appUserManagementRepository.save(foundContact).isLogin();
    }

    @Override
    public boolean logOut(String email, String password) {
        AppUser foundContact = appUserManagementRepository.findByEmailAddress(email);
        String encryptedPassword = encryptPassword(password);
        if (!foundContact.getPassword().equalsIgnoreCase(encryptedPassword))throw new RuntimeException("incorrect password");
       if (!foundContact.isLogin())throw new RuntimeException("you have to login before you can logout ");
       foundContact.setLogin(false);
        return appUserManagementRepository.save(foundContact).isLogin();
    }

    @Override
    public AppUser findAppUserByEmail(String emailAddress) {
        AppUser foundUser = appUserManagementRepository.findByEmailAddress(emailAddress);
        if (foundUser == null)throw new RuntimeException("User Email not found");
        return foundUser;
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        return appUserManagementRepository.save(appUser);
    }


}
