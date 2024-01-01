package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.AppUserRequest;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;
import com.logisticsSystem.logisticApp.dto.response.UserResponse;

public interface AppUserService   {

    UserResponse registerCustomer(AppUserRequest userRequest);

    Product findProduct(String name,String customerEmail);

    boolean loginUser(String email, String password);

//    UserResponse updateAccount(ProductUpdate userRequest);

    boolean deleteAccount(String email);

    ProductResponse createProduct(ProductRequest productRequest);


    AppUser saveAppUser(AppUser appUser2);

    Product updateProduct(ProductUpdate productUpdate);

    Product updateAccount(UpdateUserRequest updateUserRequest);

    boolean deleteProduct(String name ,String customerEmail);

    AppUser registerDispatchRider(AppUserRequest dispatchRiderRequest);

    AppUser findUserByEmail(String email);
}
