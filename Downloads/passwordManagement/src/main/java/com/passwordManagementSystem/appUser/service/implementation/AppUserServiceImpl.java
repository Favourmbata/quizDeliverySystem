package com.passwordManagementSystem.appUser.service.implementation;

import com.passwordManagementSystem.appUser.DTO.request.AppUserRequest;
import com.passwordManagementSystem.appUser.DTO.request.AppUserUpdate;
import com.passwordManagementSystem.appUser.DTO.response.AppUserResponse;
import com.passwordManagementSystem.appUser.data.model.AppUser;
import com.passwordManagementSystem.appUser.data.model.Password;
import com.passwordManagementSystem.appUser.data.repository.AppUserRepository;
import com.passwordManagementSystem.appUser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Override
    public AppUserResponse registerAppUser(AppUserRequest appUserRequest) {
        if (appUserRepository.existsByEmailAddress(appUserRequest.getEmailAddress()))
            throw new RuntimeException("Email already exist");
        if (appUserRepository.existsByPhoneNumber(appUserRequest.getPhoneNumber()))
            throw new RuntimeException("phone number already exist");
        AppUser newUser = new AppUser();
        newUser.setFirstName(appUserRequest.getFirstName());
        newUser.setLastName(appUserRequest.getLastName());
        newUser.setEmailAddress(appUserRequest.getEmailAddress());
        newUser.setLoginPassword(appUserRequest.getLoginPassword());
        newUser.setPhoneNumber(appUserRequest.getPhoneNumber());
        newUser.setRegistrationDate(LocalDateTime.now());

        AppUser saveUser = appUserRepository.save(newUser);

        return AppUserResponse.builder()
                .firstName(saveUser.getFirstName())
                .lastName(saveUser.getLastName())
                .emailAddress(saveUser.getEmailAddress())
                .phoneNumber(saveUser.getPhoneNumber())
                .build();


    }

    @Override
    public boolean loginUser(String email, String password) {
        AppUser foundUser = appUserRepository.findByEmailAddress(email);
        if (foundUser == null) throw new RuntimeException("User not found");
        if (!foundUser.getLoginPassword().equalsIgnoreCase(password)) throw new RuntimeException("Incorrect password");
        foundUser.setLogin(true);
        return appUserRepository.save(foundUser).isLogin();
    }

    @Override
    public AppUser findAppUserByEmail(String email) {
        AppUser foundUser = appUserRepository.findByEmailAddress(email);
        if (foundUser == null) throw new RuntimeException("User not found");
        return foundUser;
    }

    @Override
    public AppUser findAppUserById(long appUserId) {
        Optional<AppUser> foundUser = appUserRepository.findById(appUserId);
        if (foundUser.isEmpty()) throw new RuntimeException("could not find user Id");
        return foundUser.get();
    }

    @Override
    public AppUserResponse updateUser(AppUserUpdate appUserUpdate) {
        AppUser foundUser = findAppUserById(appUserUpdate.getId());
        if (!foundUser.isLogin()) throw new RuntimeException("You must login");
        foundUser.setFirstName(appUserUpdate.getFirstName());
        foundUser.setLastName(appUserUpdate.getLastName());
        foundUser.setPhoneNumber(appUserUpdate.getPhoneNumber());
        AppUser saveUser = appUserRepository.save(foundUser);

        return AppUserResponse.builder().
                firstName(saveUser.getFirstName())
                .lastName(saveUser.getLastName())
                .phoneNumber(saveUser.getPhoneNumber()).build();
    }

    @Override
    public boolean deleteAppUserById(long appUserId) {
        AppUser foundUser = findAppUserById(appUserId);
        appUserRepository.delete(foundUser);
        return appUserRepository.existsById(appUserId);
    }

    @Override
    public boolean logOut(String email, String password) {
        AppUser foundUser = findAppUserByEmail(email);
        if (!foundUser.getLoginPassword().equalsIgnoreCase(password)) throw new RuntimeException("Incorrect password");
        if (!foundUser.isLogin()) throw new RuntimeException("You are have to login before you can log out");
        foundUser.setLogin(false);
        return appUserRepository.save(foundUser).isLogin();
    }

    @Override
    public void saveAppUser(AppUser foundUser) {
        appUserRepository.save(foundUser);
    }

    @Override
    public List<Password> getListOfCustomersPassword(String email) {
        AppUser foundUser = findAppUserByEmail(email);
        return foundUser.getListOfPassword();
    }


}
