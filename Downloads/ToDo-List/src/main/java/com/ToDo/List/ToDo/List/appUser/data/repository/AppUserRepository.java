package com.ToDo.List.ToDo.List.appUser.data.repository;

import com.ToDo.List.ToDo.List.appUser.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository< AppUser, Long> {

    boolean existsByEmail(String email);

    AppUser findByEmail(String email);

}
