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
 private  ContactService contactService;

 private ContactRequest contactRequest;
 private ContactRequest contactRequest1;
 private AppUserUpdate appUserUpdate;
    @BeforeEach
    void setUp() {
        contactRequest = new ContactRequest();
        contactRequest.setFirstName("favour");
        contactRequest.setLastName("mbata");
        contactRequest.setPhoneNumber("08104427559");
        contactRequest.setEmailAddress("favourmbata007@gmail.com");

        contactRequest = new ContactRequest();
        contactRequest.setFirstName("delight");
        contactRequest.setLastName("obinna");
        contactRequest.setPhoneNumber("08104427509");
        contactRequest.setEmailAddress("delightObinna@gmail.com");

        appUserUpdate = new AppUserUpdate();
        appUserUpdate.setFirstName("Debby");
        appUserUpdate.setLastName("mbata");
       appUserUpdate.setContactId(1);
       appUserUpdate.setEmailAddress("favourmbata007@gmail.com");
        appUserUpdate.setPhoneNumber("081223567886");
    }

@Test
 void addContact(){

        assertEquals(1,contactService.addContact(contactRequest).getEmailAddress());
        assertEquals(3,contactService.addContact(contactRequest1).getEmailAddress());
//    assertEquals(1,contactService.addContact(contactRequest).getPhoneNumber());
 }
  @Test
    void findContactById(){
        assertDoesNotThrow(()->{
            contactService.findContactById(1);
        });
  }

   @Test
    void updateContacts(){

        assertEquals("favourmbata007@gmail.com",contactService.updateContact(appUserUpdate).getEmailAddress());
//     assertNull(contactService.updateContact(appUserUpdate).getEmailAddress());
   }
    @Test
    void deleteContact(){
        assertFalse(contactService.deleteContact(1,"favourmbata007@gmail.com"));
    }

  }



