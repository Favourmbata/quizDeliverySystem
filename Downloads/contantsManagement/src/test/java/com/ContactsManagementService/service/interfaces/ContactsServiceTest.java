package com.ContactsManagementService.service.interfaces;

import com.ContactsManagementService.dto.request.AppUserUpdate;
import com.ContactsManagementService.dto.request.ContactRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactsServiceTest {
    @Autowired
    private ContactService contactService;

    private ContactRequest contactRequest;
    private ContactRequest contactRequest1;
    private ContactRequest contactRequest2;
    private AppUserUpdate appUserUpdate;

    @BeforeEach
    void setUp() {
        contactRequest = new ContactRequest();
        contactRequest.setFirstName("favour");
        contactRequest.setLastName("mbata");
        contactRequest.setPhoneNumber("08104427559");
        contactRequest.setEmailAddress("adaOzor60@gmail.com");

        contactRequest1 = new ContactRequest();
        contactRequest1.setFirstName("delight");
        contactRequest1.setLastName("obinna");
        contactRequest1.setPhoneNumber("081228345121");
        contactRequest1.setEmailAddress("bestJohn@gmail.com");


        contactRequest2 = new ContactRequest();
        contactRequest2.setFirstName("queen");
        contactRequest2.setLastName("emeka");
        contactRequest2.setPhoneNumber("070653771456");
        contactRequest2.setEmailAddress("bestJohn@gmail.com");

        appUserUpdate = new AppUserUpdate();
        appUserUpdate.setFirstName("Debby");
        appUserUpdate.setLastName("mbata");
        appUserUpdate.setContactId(2);
        appUserUpdate.setEmailAddress("adaOzor60@gmail.com");
        appUserUpdate.setPhoneNumber("081223567886");
    }

    @Test
    void addContact() {

//        assertEquals("adaOzor60@gmail.com", contactService.addContact(contactRequest).getEmailAddress());
//        assertEquals("bestJohn@gmail.com", contactService.addContact(contactRequest1).getEmailAddress());
        assertEquals("bestJohn@gmail.com", contactService.addContact(contactRequest2).getEmailAddress());
//
    }

    @Test
    void findContactById() {
        assertDoesNotThrow(() -> {
            contactService.findContactById(1);
        });
    }

    @Test
    void updateContacts() {

        assertEquals("bestJohn@gmail.com", contactService.updateContact(appUserUpdate).getEmailAddress());
       
    }

    @Test
    void deleteContact() {
        assertFalse(contactService.deleteContact(2, "adaOzor60@gmail.com"));
    }



  @Test
    void findAllContact_OfAUser(){
        assertEquals(2,contactService.findAllContact("bestJohn@gmail.com").size());
  }

 @Test
    void findContactByPhoneNumber(){

 }
}



