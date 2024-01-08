package com.expenseTracker.data.repository;

import com.expenseTracker.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    boolean existsByEmailAddress(String emailAddress);


    AppUser findByEmailAddress(String emailAddress);

    AppUser findAppUserById(long id);

}
