package com.ContactsManagementService.service.implementation;

import com.ContactsManagementService.data.model.AppUser;
import com.ContactsManagementService.data.model.Contacts;
import com.ContactsManagementService.data.repository.ContactRepository;
import com.ContactsManagementService.dto.request.AppUserUpdate;
import com.ContactsManagementService.dto.request.ContactRequest;
import com.ContactsManagementService.dto.response.ContactResponse;
import com.ContactsManagementService.service.interfaces.AppUserService;
import com.ContactsManagementService.service.interfaces.ContactService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService {
    private final ContactRepository contactRepository;
    private final AppUserService appUserService;

    @Override
    public ContactResponse addContact(ContactRequest contactRequest) {
        Contacts savedContact = mapAndValidateContacts(contactRequest);
        AppUser appUser = savedContact.getAppUser();
        appUser.getListOfContacts().add(savedContact);
        appUserService.saveAppUser(appUser);
        return ContactResponse.builder()
                .firstName(savedContact.getFirstName())
                .lastName(savedContact.getLastName())
                .phoneNumber(savedContact.getPhoneNumber())
                .emailAddress(savedContact.getAppUser().getEmailAddress()).

                build();

    }

    private Contacts mapAndValidateContacts(ContactRequest contactRequest) {
        if (contactRepository.existsByPhoneNumber(contactRequest.getPhoneNumber()))
            throw new RuntimeException("phone number already exist");
        if (contactRepository.existsByFirstNameAndLastName(contactRequest.getFirstName(), contactRequest.getLastName()))
            throw new RuntimeException("contact already exist");
        return Contacts.builder()
                .firstName(contactRequest.getFirstName())
                .lastName(contactRequest.getLastName())
                .phoneNumber(contactRequest.getPhoneNumber())
                .appUser(appUserService.findAppUserByEmail(contactRequest.getEmailAddress()))
                .createdTime(LocalDateTime.now())
                .build();
    }

    @Override
    public ContactResponse updateContact(AppUserUpdate appUserUpdate) {
        Contacts savedContact = updateMapAndValidateContacts(appUserUpdate);
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setFirstName(savedContact.getFirstName());
        contactResponse.setLastName(savedContact.getLastName());
        contactResponse.setPhoneNumber(savedContact.getPhoneNumber());
        contactResponse.setEmailAddress(savedContact.getAppUser().getEmailAddress());


        return contactResponse;
    }

    private Contacts updateMapAndValidateContacts(AppUserUpdate appUserUpdate) {
        Contacts foundContact = findContactById(appUserUpdate.getContactId());
        if (foundContact == null) throw new RuntimeException("Contact not found");
        foundContact.setFirstName(appUserUpdate.getFirstName());
        foundContact.setLastName(appUserUpdate.getLastName());
        foundContact.setPhoneNumber(appUserUpdate.getPhoneNumber());
        foundContact.setContactId(appUserUpdate.getContactId());
        return contactRepository.save(foundContact);
    }

    @Override
    public boolean deleteContact(long id, String email) {
        Contacts foundContact = contactRepository.findByContactIdAndAppUserEmailAddress(id, email);
        contactRepository.delete(foundContact);
        return contactRepository.existsByContactIdAndAppUserEmailAddress(id, email);
    }

    @Override
    public List<Contacts> findAllContact(String email) {
        AppUser foundAppUser = appUserService.findAppUserByEmail(email);
        return foundAppUser.getListOfContacts();
    }


    @Override
    public Contacts findContactById(long contactId) {
        Optional<Contacts> foundContact = contactRepository.findById(contactId);
        if (foundContact.isEmpty()) throw new RuntimeException("Could not find user");
        return foundContact.get();
    }


}
