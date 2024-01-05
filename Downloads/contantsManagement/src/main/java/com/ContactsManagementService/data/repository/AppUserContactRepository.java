package com.ContactsManagementService.data.repository;

import com.ContactsManagementService.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface AppUserContactRepository extends JpaRepository<AppUser,Long> {

    boolean existsByEmailAddress(String address);

    boolean existsByPhoneNumber(String phoneNumber);

    AppUser findByEmailAddress(String email);

}
