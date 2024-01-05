package com.ContactsManagementService.data.repository;

import com.ContactsManagementService.data.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository  extends JpaRepository<Contacts,Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByFirstNameAndLastName(String firstName,String lastName);

    Contacts findByContactIdAndAppUserEmailAddress(long id, String email);

    boolean existsByContactIdAndAppUserEmailAddress(long id, String email);

}
