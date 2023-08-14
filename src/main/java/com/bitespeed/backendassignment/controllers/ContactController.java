/**
 * @author Vivek Ghosh
 *
 */

package com.bitespeed.backendassignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitespeed.backendassignment.helpers.ContactResponse;
import com.bitespeed.backendassignment.helpers.ResponseUtil;
import com.bitespeed.backendassignment.models.Contact;
import com.bitespeed.backendassignment.services.ContactService;


@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		
		ResponseEntity<List<Contact>> contacts;
		
		try {
			
			contacts = contactService.getAllContacts();
			return contacts;
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id) {
		
		try {
			
			return contactService.getByContactId(id);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/contact")
	public ResponseEntity<ContactResponse> createContact(@RequestBody Contact contact) {
		
		try {
			
			return contactService.createContact(contact);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@PutMapping("/contact/{id}")
	public ResponseEntity<ResponseUtil> updateContact(@PathVariable("id") Long id, @RequestBody Contact contact) {
		
		try {
			
			return contactService.updateContact(id, contact);
			
		} catch (Exception e) {
			
			return new ResponseEntity<ResponseUtil>(
				new ResponseUtil(500, "Error while updating the contact"), 
				HttpStatus.INTERNAL_SERVER_ERROR
			);
			
		}
		
	}
	
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") Long id) {
		
		try {
			
			return contactService.deleteContact(id);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Error while deleting the contact", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
}
