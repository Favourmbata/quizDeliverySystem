package com.expenseTracker.data.service.interfaces;

import com.expenseTracker.dto.request.AppUserRequest;
import com.expenseTracker.dto.request.UserUpdate;
import com.expenseTracker.dto.response.AppUserResponse;

public interface AppUserService {
    AppUserResponse registerUser(AppUserRequest appUserRequest);

    boolean login(String password, String emailAddress);

    AppUserResponse update(UserUpdate userUpdate);

    boolean deleteById(long id);

}
