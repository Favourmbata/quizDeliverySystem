package com.ToDo.List.ToDo.List.appUser.service.interfaces;

import com.ToDo.List.ToDo.List.appUser.DTO.request.UpdateUserRequest;
import com.ToDo.List.ToDo.List.appUser.DTO.request.UserRegisterRequest;
import com.ToDo.List.ToDo.List.appUser.DTO.response.UserResponse;

public interface AppUserService {

    UserResponse registerUser(UserRegisterRequest userRegisterRequest);

    boolean loginUser(String email, String password);


    UserResponse updateUser(UpdateUserRequest updateUserRequest);

    boolean deleteUser(String mail);

}
