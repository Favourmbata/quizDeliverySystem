package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.UserRequest;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;
import com.logisticsSystem.logisticApp.dto.response.UserResponse;

public interface AppUserService   {
    UserResponse register(UserRequest userRequest);



    boolean loginUser(String email, String password);

    UserResponse updateAccount(UpdateUserRequest userRequest);

    boolean deleteAccount(String email);

    ProductResponse createProduct(ProductRequest productRequest);


    AppUser saveAppUser(AppUser appUser2);
}
