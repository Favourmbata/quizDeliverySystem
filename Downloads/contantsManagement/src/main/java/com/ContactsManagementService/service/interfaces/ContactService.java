package com.ContactsManagementService.service.interfaces;

import com.ContactsManagementService.data.model.Contacts;
import com.ContactsManagementService.dto.request.AppUserUpdate;
import com.ContactsManagementService.dto.request.ContactRequest;
import com.ContactsManagementService.dto.response.ContactResponse;

import java.util.Collection;
import java.util.List;


public interface ContactService {
    ContactResponse addContact(ContactRequest contactRequest);



    Contacts findContactById(long contactId);

    ContactResponse updateContact(AppUserUpdate appUserUpdate);

    boolean deleteContact(long id, String email);

    List<Contacts> findAllContact(String email);



}
