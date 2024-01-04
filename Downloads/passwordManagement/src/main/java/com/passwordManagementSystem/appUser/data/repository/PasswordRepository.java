package com.passwordManagementSystem.appUser.data.repository;

import com.passwordManagementSystem.appUser.DTO.request.UpdatePasswordRequest;
import com.passwordManagementSystem.appUser.data.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository  extends JpaRepository <Password,Long> {
    boolean existsByTitleAndCustomerEmailAddress(String title, String userEmail);


    Password findByIdAndCustomerEmailAddress(long passwordId, String userEmail);

    Password findPasswordByTitle(String passwordTitle);


    boolean existsByTitle(String passwordTitle);


    Password findByTitleAndCustomerEmailAddress(String title, String customerEmail);

    boolean existsByIdAndAndCustomer_EmailAddress(long Id, String emailAddress);


}
