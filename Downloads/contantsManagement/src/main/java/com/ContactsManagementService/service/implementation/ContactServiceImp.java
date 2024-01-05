package com.ContactsManagementService.service.implementation;

import com.ContactsManagementService.data.model.Contacts;
import com.ContactsManagementService.data.repository.ContactRepository;
import com.ContactsManagementService.dto.request.AppUserUpdate;
import com.ContactsManagementService.dto.request.ContactRequest;
import com.ContactsManagementService.dto.response.ContactResponse;
import com.ContactsManagementService.service.interfaces.ContactService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public ContactResponse addContact(ContactRequest contactRequest) {
        Contacts savedContact = mapAndUpdateContact(contactRequest);
        return ContactResponse.builder()
                .firstName(savedContact.getFirstName())
                .lastName(savedContact.getLastName())
                .phoneNumber(savedContact.getPhoneNumber())
                .emailAddress(savedContact.getEmailAddress()).
        build();

    }

    @Override
    public Contacts findContactById(long contactId) {
        Optional<Contacts> foundContact = contactRepository.findById(contactId);
        if (foundContact.isEmpty())throw new RuntimeException("Could not find user");
        return foundContact.get();
    }

    @Override
    public ContactResponse updateContact(AppUserUpdate appUserUpdate) {
        Contacts savedContact = mapAndUpdateContact(appUserUpdate);
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setFirstName(savedContact.getFirstName());
        contactResponse.setLastName(savedContact.getLastName());
        contactResponse.setPhoneNumber(savedContact.getPhoneNumber());
        contactResponse.setEmailAddress(savedContact.getEmailAddress());

        return contactResponse;
    }

    @Override
    public boolean deleteContact(long id, String email) {
       Contacts foundContact = contactRepository.findByIdAndEmailAddress(id,email);
        return false;
    }

    private Contacts mapAndUpdateContact(AppUserUpdate appUserUpdate) {
        Contacts foundContact = findContactById(appUserUpdate.getContactId());
        if (foundContact == null)throw new RuntimeException("Contact not found");
        foundContact.setFirstName(appUserUpdate.getFirstName());
        foundContact.setLastName(appUserUpdate.getLastName());
        foundContact.setPhoneNumber(appUserUpdate.getPhoneNumber());
        foundContact.setContactId(appUserUpdate.getContactId());
        foundContact.setEmailAddress(appUserUpdate.getEmailAddress());
        Contacts savedContact = contactRepository.save(foundContact);
        return savedContact;
    }

    private Contacts mapAndUpdateContact(ContactRequest contactRequest) {
        if (contactRepository.existsByPhoneNumber(contactRequest.getPhoneNumber()))
            throw new RuntimeException("phone number already exist");
        if (contactRepository.existsByFirstNameAndLastName(contactRequest.getFirstName(), contactRequest.getLastName()))
            throw new RuntimeException("contact already exist");
        Contacts newContact = Contacts.builder()
                .firstName(contactRequest.getFirstName())
                .lastName(contactRequest.getLastName())
                .phoneNumber(contactRequest.getPhoneNumber())
                .emailAddress(contactRequest.getEmailAddress())
                .createdTime(LocalDateTime.now())
                .build();

        Contacts savedContact = new Contacts();
        contactRepository.save(newContact);
        return contactRepository.save(savedContact);
    }
}
