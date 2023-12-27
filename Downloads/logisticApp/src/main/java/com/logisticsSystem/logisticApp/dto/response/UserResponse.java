package com.logisticsSystem.logisticApp.dto.response;

import com.logisticsSystem.logisticApp.data.model.AppUserType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class UserResponse {
    private String username;
    private String email;
    private String password;
    private AppUserType appUserType;

}
