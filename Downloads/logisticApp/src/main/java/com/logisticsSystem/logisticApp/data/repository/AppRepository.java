package com.logisticsSystem.logisticApp.data.repository;

import com.logisticsSystem.logisticApp.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository  extends JpaRepository <AppUser , Long> {

    boolean existsByEmail(String email);

    AppUser findByEmail(String email);

}
