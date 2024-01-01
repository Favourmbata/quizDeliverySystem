package com.logisticsSystem.logisticApp.service.implemenations;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.model.AppUserType;
import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.data.repository.AppRepository;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.AppUserRequest;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;
import com.logisticsSystem.logisticApp.dto.response.UserResponse;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppUserImp implements AppUserService {
    private final AppRepository appRepository;
    private final ProductService productService;



    @Override
    public UserResponse registerCustomer(AppUserRequest userRequest) {
        if (appRepository.existsByEmail(userRequest.getEmail())) throw new RuntimeException("email already exist");
        AppUser foundUser = getAppUser(userRequest);
        AppUser saveUser = appRepository.save(foundUser);
        return getUserResponse(saveUser);
    }

    @Override
    public Product findProduct(String name, String customerEmail) {
        if (!appRepository.findByEmail(customerEmail).isLogin())throw new RuntimeException("you must login");
      return productService.findProduct(name, customerEmail);
    }

    private static AppUser getAppUser(AppUserRequest userRequest) {
        AppUser foundUser = new AppUser();
        foundUser.setUsername(userRequest.getUsername());
        foundUser.setEmail(userRequest.getEmail());
        foundUser.setPassword(userRequest.getPassword());
        foundUser.setAppUserType(userRequest.getAppUserType());
        foundUser.setCreatedDate(LocalDateTime.now());
        return foundUser;
    }

    private static UserResponse getUserResponse(AppUser appUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(appUser.getUsername());
        userResponse.setEmail(appUser.getEmail());
        userResponse.setPassword(appUser.getPassword());
        userResponse.setAppUserType(appUser.getAppUserType());
        return userResponse;
    }

    @Override
    public boolean loginUser(String email, String password) {
        AppUser foundUser = appRepository.findByEmail(email);

        if (!foundUser.getPassword().equalsIgnoreCase(password)) throw new RuntimeException("incorrect password ");
        foundUser.setLogin(true);
        appRepository.save(foundUser);
        return foundUser.isLogin();
    }


    public boolean deleteAccount(String email) {
        AppUser foundAccount = appRepository.findByEmail(email);
        appRepository.delete(foundAccount);
        if (!appRepository.existsByEmail(email)) return true;
        return false;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {


        AppUser foundAppUser = appRepository.findByEmail(productRequest.getCustomerEmail());
        if (foundAppUser == null) throw new RuntimeException("appUser not found");
        if (!foundAppUser.isLogin())throw new RuntimeException("you have to login");
        productRequest.setCustomer(foundAppUser);
      return   productService.createProduct(productRequest);



    }
     public Product updateProduct(ProductUpdate productUpdate){
        AppUser foundProduct = appRepository.findByEmail(productUpdate.getCustomerEmail());
         if (foundProduct == null) throw new RuntimeException("product  not found");
         if (!foundProduct.isLogin())throw new RuntimeException("you have to login");
        return productService.updateProduct(productUpdate);
     }

    @Override
    public Product updateAccount(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public boolean deleteProduct(String name, String customerEmail) {
        productService.findProduct(name, customerEmail);
        return productService.delete_Product(name, customerEmail);
    }

    @Override
    public AppUser registerDispatchRider(AppUserRequest dispatchRiderRequest) {
        try {
            if (appRepository.existsByEmail(dispatchRiderRequest.getEmail())) throw new RuntimeException("email already exist");
            AppUser mappedAppUser = getAppUser(dispatchRiderRequest);
            mappedAppUser.setAppUserType(AppUserType.DISPATCH_RIDER);
            return appRepository.save(mappedAppUser);
        }catch (Exception e){
            return appRepository.findByEmail(dispatchRiderRequest.getEmail());
        }

    }

    @Override
    public AppUser findUserByEmail(String email) {
        AppUser foundUser = appRepository.findByEmail(email);
         if (foundUser == null) throw new RuntimeException(" user account  not found");
        return foundUser;
    }

    @Override
    public AppUser saveAppUser(AppUser appUser2) {
        try {
            if (appRepository.existsByEmail(appUser2.getEmail())) throw new RuntimeException("user already exist");
        } catch (Exception e) {
            return appRepository.findByEmail(appUser2.getEmail());
        }
        return appRepository.save(appUser2);
    }


}
