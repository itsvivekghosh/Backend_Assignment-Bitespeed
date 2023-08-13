package com.bitespeed.backendassignment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bitespeed.backendassignment.helpers.ContactResponse;
import com.bitespeed.backendassignment.helpers.ResponseUtil;
import com.bitespeed.backendassignment.models.Contact;

public interface ContactService {
	
	ResponseEntity<List<Contact>> getAllContacts();
	
	ResponseEntity<Contact> getByContactId(Long id);
	
	ResponseEntity<ContactResponse> createContact(Contact contact);

	ResponseEntity<ResponseUtil> updateContact(Long id, Contact contact);

	ResponseEntity<String> deleteContact(Long id);
}
