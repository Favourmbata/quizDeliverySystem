package com.ToDo.List.ToDo.List.appUser.service.implementation;

import com.ToDo.List.ToDo.List.appUser.DTO.request.UpdateUserRequest;
import com.ToDo.List.ToDo.List.appUser.DTO.request.UserRegisterRequest;
import com.ToDo.List.ToDo.List.appUser.DTO.response.UserResponse;
import com.ToDo.List.ToDo.List.appUser.data.model.AppUser;
import com.ToDo.List.ToDo.List.appUser.data.repository.AppUserRepository;
import com.ToDo.List.ToDo.List.appUser.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AppUserServiceImp implements AppUserService {

    private final AppUserRepository appUserRepository;
    @Override
    public UserResponse registerUser(UserRegisterRequest userRegisterRequest) {
        if (appUserRepository.existsByEmail(userRegisterRequest.getEmail())) throw new RuntimeException("email already exist");
        AppUser appUser = new AppUser();
        appUser.setEmail(userRegisterRequest.getEmail());
        appUser.setPassword(userRegisterRequest.getPassword());
        appUser.setFirstName(userRegisterRequest.getFirstName());
        appUser.setLastName(userRegisterRequest.getLastName());
        appUser.setRegistrationDate(LocalDateTime.now());
        AppUser savedAppUser = appUserRepository.save(appUser);

        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(savedAppUser.getFirstName());
        userResponse.setLastName(savedAppUser.getLastName());
        userResponse.setEmail(savedAppUser.getEmail());
        return userResponse;
    }

    @Override
    public boolean loginUser(String email, String password) {
        AppUser foundUser = appUserRepository.findByEmail(email);
        if (foundUser.getPassword().equalsIgnoreCase(password)){
            foundUser.setLogin(true);
            appUserRepository.save(foundUser);
        }
        return foundUser.isLogin();
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {
      AppUser oldUser = appUserRepository.findByEmail(updateUserRequest.getEmail());
       if (!oldUser.isLogin()) throw new RuntimeException("You have to login");
       oldUser.setFirstName(updateUserRequest.getFirstName());
       oldUser.setLastName(updateUserRequest.getLastName());
       AppUser savedAppUser =  appUserRepository.save(oldUser);

     UserResponse userResponse = new UserResponse();
     userResponse.setFirstName(savedAppUser.getFirstName());
     userResponse.setLastName(savedAppUser.getLastName());


        return userResponse;
    }

    @Override
    public boolean deleteUser(String mail) {
        AppUser userAccount = appUserRepository.findByEmail(mail);
        appUserRepository.delete(userAccount);
        if (!appUserRepository.existsByEmail(mail)) return true;
        return false;
    }


}
