package com.passwordManagementSystem.appUser.service.implementation;

import com.passwordManagementSystem.appUser.DTO.request.PasswordRequest;
import com.passwordManagementSystem.appUser.DTO.request.UpdatePasswordRequest;
import com.passwordManagementSystem.appUser.DTO.response.PasswordResponse;
import com.passwordManagementSystem.appUser.DTO.response.ViewPasswordResponse;
import com.passwordManagementSystem.appUser.data.model.AppUser;
import com.passwordManagementSystem.appUser.data.model.Password;
import com.passwordManagementSystem.appUser.data.repository.PasswordRepository;
import com.passwordManagementSystem.appUser.service.interfaces.AppUserService;
import com.passwordManagementSystem.appUser.service.interfaces.PasswordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final PasswordRepository passwordRepository;
    private final AppUserService appUserService;


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
    public PasswordResponse createPassword(PasswordRequest passwordRequest) {
        if (passwordRepository.existsByTitleAndCustomerEmailAddress(passwordRequest.getTitle(), passwordRequest.getUserEmail()))
            throw new RuntimeException("password already exist");
        if (passwordRequest.getPassword().length() < 4 && passwordRequest.getPassword().length() > 13)
            throw new RuntimeException("password must not be less 4 and password must not be greater than 13");
        if (passwordRequest.getPassword().contains(" "))throw new RuntimeException("password should not contain space");
        AppUser foundUser = appUserService.findAppUserByEmail(passwordRequest.getUserEmail());
        String encryptedPassword = encryptPassword(passwordRequest.getPassword());
        Password newPassword = Password.builder()
                .password(encryptedPassword)
                .title(passwordRequest.getTitle())
                .customer(foundUser)
                .creationDate(LocalDate.now())
                .build();
        Password savedPassword = passwordRepository.save(newPassword);
        foundUser.getListOfPassword().add(savedPassword);
        appUserService.saveAppUser(foundUser);

        return PasswordResponse.builder()
                .password(savedPassword.getPassword())
                .title(savedPassword.getTitle())
                .userEmail(savedPassword.getPassword())
                .build();
    }

    @Override
    public PasswordResponse updatepassword(UpdatePasswordRequest updatePasswordRequest) {
        Password foundPassword = passwordRepository.findByIdAndCustomerEmailAddress(updatePasswordRequest.getPasswordId(), updatePasswordRequest.getUserEmail());
        if (foundPassword == null) throw new RuntimeException(" password not found");
        foundPassword.setPassword(encryptPassword(updatePasswordRequest.getNewPassword()));
        foundPassword.setTitle(updatePasswordRequest.getTitle());
        Password savedPassword = passwordRepository.save(foundPassword);

        PasswordResponse passwordResponse = new PasswordResponse();
        passwordResponse.setPassword(savedPassword.getPassword());
        passwordResponse.setTitle(savedPassword.getTitle());
        return passwordResponse;
    }

    @Override
    public Password findPassword(String title, String customerEmail) {
        Password foundPassword = passwordRepository.findByTitleAndCustomerEmailAddress(title, customerEmail);
        if (foundPassword == null) throw new RuntimeException("Password Not found");
        return foundPassword;
    }

    @Override
    public boolean deletePassword(String passwordTitle) {
        Password foundPassword = passwordRepository.findPasswordByTitle(passwordTitle);
        passwordRepository.delete(foundPassword);
        return passwordRepository.existsByTitle(passwordTitle);
    }

    @Override
    public Password findPasswordById(long passwordId) {
        Optional<Password> foundPasswordId = passwordRepository.findById(passwordId);
        if (foundPasswordId.isEmpty()) throw new RuntimeException("Could not find user");
        return foundPasswordId.get();
    }

    @Override
    public boolean deletePasswordWithIdAndCustomerEmail(long passwordId, String customerEmail) {
        Password foundPassword = passwordRepository.findByIdAndCustomerEmailAddress(passwordId, customerEmail);
        passwordRepository.delete(foundPassword);
        return passwordRepository.existsByIdAndAndCustomer_EmailAddress(passwordId, customerEmail);
    }

    @Override
    public ViewPasswordResponse viewPassword(String email, String title) {
        Password foundPassword = findPassword(title,email);


        ViewPasswordResponse viewPassword = new ViewPasswordResponse();
        viewPassword.setPassword(decryptPassword(foundPassword.getPassword()));
        viewPassword.setTitle(foundPassword.getTitle());
        viewPassword.setCustomerEmail(foundPassword.getCustomer().getEmailAddress());

        return viewPassword;
    }


}
