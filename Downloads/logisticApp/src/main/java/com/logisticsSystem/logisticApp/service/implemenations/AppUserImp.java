package com.logisticsSystem.logisticApp.service.implemenations;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.repository.AppRepository;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.request.UserRequest;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;
import com.logisticsSystem.logisticApp.dto.response.UserResponse;
import com.logisticsSystem.logisticApp.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppUserImp implements AppUserService {
    private final AppRepository appRepository;

    @Override
    public UserResponse register(UserRequest userRequest) {
        if (appRepository.existsByEmail(userRequest.getEmail())) throw new RuntimeException("email already exist");
        AppUser foundUser = getAppUser(userRequest);
        AppUser saveUser = appRepository.save(foundUser);
        return getUserResponse(saveUser);
    }

    private static AppUser getAppUser(UserRequest userRequest) {
        AppUser foundUser = new AppUser();
        foundUser.setUsername(userRequest.getUsername());
        foundUser.setEmail(userRequest.getEmail());
        foundUser.setPassword(userRequest.getPassword());
        foundUser.setAppUserType(userRequest.getAppUserType());
        foundUser.setCreatedDate(LocalDateTime.now());
        return foundUser;
    }

    private static UserResponse getUserResponse(AppUser appUser){
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

    @Override
    public UserResponse updateAccount(UpdateUserRequest userUpdate) {
      AppUser foundUser = appRepository.findByEmail(userUpdate.getEmail());
    if (!foundUser.isLogin())throw new RuntimeException("you have  to login");
    foundUser.setUsername(userUpdate.getUsername());
    foundUser.setPassword(userUpdate.getPassword());

    AppUser savedAccount = appRepository.save(foundUser);
    return getUserResponse(savedAccount);
    }

    public boolean deleteAccount( String email) {
        AppUser foundAccount = appRepository.findByEmail(email);
        appRepository.delete(foundAccount);
        if (!appRepository.existsByEmail(email))return true;
        return false;
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {

        return null;
    }

    @Override
    public AppUser saveAppUser(AppUser appUser2) {
        try{
            if (appRepository.existsByEmail(appUser2.getEmail())) throw new RuntimeException("user already exist");
        }catch (Exception e){
         return  appRepository.findByEmail(appUser2.getEmail());
        }
        return appRepository.save(appUser2);
    }


}
