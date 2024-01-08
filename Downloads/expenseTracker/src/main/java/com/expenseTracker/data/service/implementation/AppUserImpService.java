package com.expenseTracker.data.service.implementation;

import com.expenseTracker.data.model.AppUser;
import com.expenseTracker.data.repository.AppUserRepository;
import com.expenseTracker.data.service.interfaces.AppUserService;
import com.expenseTracker.dto.request.AppUserRequest;
import com.expenseTracker.dto.request.UserUpdate;
import com.expenseTracker.dto.response.AppUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AppUserImpService implements AppUserService {
 private final AppUserRepository appUserRepository;

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
    public AppUserResponse registerUser(AppUserRequest appUserRequest) {
        AppUser saveUser = mapAndValidateUser(appUserRequest);
        AppUserResponse appUserResponse = new AppUserResponse();
        appUserResponse.setUserName(saveUser.getUserName());
        appUserResponse.setEmailAddress(saveUser.getEmailAddress());
        appUserResponse.setPassword(appUserRequest.getPassword());

        return appUserResponse;
    }

    private AppUser mapAndValidateUser(AppUserRequest appUserRequest) {
        if (appUserRepository.existsByEmailAddress(appUserRequest.getEmailAddress()))throw new RuntimeException("email already exist");
        AppUser foundUser = new AppUser();
        foundUser.setUserName(appUserRequest.getUserName());
        foundUser.setEmailAddress(appUserRequest.getEmailAddress());
        foundUser.setPassword(encryptPassword(appUserRequest.getPassword()));
        return appUserRepository.save(foundUser);

    }
    @Override
    public boolean login(String password, String emailAddress) {
        AppUser foundUser = appUserRepository. findByEmailAddress(emailAddress);
        if (foundUser == null)throw new RuntimeException("User not found");
        String encryptedPassword = encryptPassword(password);
        if (!foundUser.getPassword().equalsIgnoreCase(encryptedPassword))throw new RuntimeException("Incorrect password");
        foundUser.setLogin(true);
        return appUserRepository.save(foundUser).isLogin();
    }

    @Override
    public AppUserResponse update(UserUpdate userUpdate) {
        AppUser savedUser = getAppUser(userUpdate);
        AppUserResponse appUserResponse = new AppUserResponse();
        appUserResponse.setEmailAddress(savedUser.getEmailAddress());
        appUserResponse.setUserName(savedUser.getUserName());
        return appUserResponse;
    }

    @Override
    public boolean deleteById(long id) {
        AppUser foundUser = appUserRepository.findAppUserById(id);
        appUserRepository.delete(foundUser);
        return appUserRepository.existsById(id);
    }

    private AppUser getAppUser(UserUpdate userUpdate) {
        AppUser foundUser = appUserRepository.findAppUserById(userUpdate.getId());
        if (!foundUser.isLogin())throw new RuntimeException("you have not login");
        foundUser.setUserName(userUpdate.getUserName());
        foundUser.setEmailAddress(userUpdate.getEmailAddress());
        AppUser savedUser = appUserRepository.save(foundUser);
        return savedUser;
    }


}
