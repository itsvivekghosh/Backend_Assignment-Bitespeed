package com.bitespeed.backendassignment.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bitespeed.backendassignment.helpers.ContactCustomResponse;
import com.bitespeed.backendassignment.helpers.ContactResponse;
import com.bitespeed.backendassignment.helpers.ResponseUtil;
import com.bitespeed.backendassignment.models.Contact;
import com.bitespeed.backendassignment.repositories.ContactRepository;


@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public ResponseEntity<List<Contact>> getAllContacts() {
		
		List<Contact> contacts = new ArrayList<>();
		try {
			
			contactRepository.findAll().forEach(contacts::add);
			
			return new ResponseEntity<>(contacts, HttpStatus.OK);
			
		} catch (Exception e) {
			
			System.err.println("Error while getting all the contacts list, Error: " + e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@Override
	public ResponseEntity<Contact> getByContactId(Long id) {


		try {
			
			Contact contact = contactRepository.findById(id).get();
			return new ResponseEntity<>(contact, HttpStatus.OK);

		} catch (Exception e) {
			System.err.println("Error while getting the contact by ID: " + id +" , Error: " + e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<ResponseUtil> updateContact(Long id, Contact contact) {
		
		try {
			
			Contact existingContact = contactRepository.findById(id).orElseGet(null);
			
			if (existingContact == null) {
				String message = "Error while updating the contact, Can't find the Contact ID.";
				System.err.println(message);
				return new ResponseEntity<ResponseUtil>(new ResponseUtil(500, message), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			existingContact.setEmail(contact.getEmail());
			existingContact.setPhoneNumber(contact.getPhoneNumber());
			existingContact.setUpdated_at(LocalDateTime.now());
			
			contactRepository.save(existingContact);
			
			String message = "Contact ID Updated Successfully!";
			return new ResponseEntity<ResponseUtil>(new ResponseUtil(200, message), HttpStatus.OK);
			
		} catch (Exception e) {
			String message = "Error while Updating the contact, Error: " + e.getLocalizedMessage();
			System.err.println(message);
			return new ResponseEntity<ResponseUtil>(new ResponseUtil(500, message), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> deleteContact(Long id) {
		
		try {
			
			contactRepository.deleteById(id);
			return new ResponseEntity<>("Contact Deleted Successfully!", HttpStatus.OK);
			
		} catch (Exception e) {
			String message = "Error while Deleting the contact, Error: " + e.getLocalizedMessage();
			System.err.println(message);
			return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ContactResponse> createContact(Contact contact) {
		
		try {
			
			String email = contact.getEmail();
			String phoneNumber = contact.getPhoneNumber();
			
			if (email == null) email = "";
			if (phoneNumber == null) phoneNumber = "";
			
			List<Contact> contactList = contactRepository.findByContactsEmailAddressOrPhoneNumber(email, phoneNumber);

			if (!contactList.isEmpty()) {
				return generateSecondaryResponse(contact, contactList);
			}
			
			return generatePrimaryResponse(contact);
			
			
		} catch (Exception e) {
			System.err.println("Error while creating the contact, Error: " + e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	Boolean isEmailSame = false;
	Boolean isPhoneSame = false;
	Contact primaryContact = null;
	
	private ResponseEntity<ContactResponse> generateSecondaryResponse(Contact contact, List<Contact> contacts) {

		ContactCustomResponse contactResponse = new ContactCustomResponse();
		isEmailSame = false;
		isPhoneSame = false;
		
		try {
			
			HashSet<Long> ids = new HashSet<Long>();
			HashSet<String> emails = new HashSet<String>();
			HashSet<String> phoneNumbers = new HashSet<String>();
			HashSet<Long> secondaryContactIds = new HashSet<Long>();
			
			if (
					contacts.size() == 2 && 
					(contacts.get(0).getLinkPrecedence().equals("primary")) && (contacts.get(1).getLinkPrecedence().equals("primary"))
				) {
				
				contacts.get(1).setLinkPrecedence("secondary");
				contacts.get(1).setLinkedId(contacts.get(0).getId());
				contactRepository.save(contacts.get(1));
				primaryContact = contacts.get(1);
				
				return getPartialReponse(contacts);
			}
			
			primaryContact = contacts.get(0);
			
			if (primaryContact.getLinkedId() != null) {
				primaryContact = contactRepository.findById(primaryContact.getLinkedId()).get();
			}
			
			List<Contact> otherContacts = contactRepository.findAll();
			otherContacts.forEach((c) -> {

				if (primaryContact.getId().equals(c.getLinkedId()) && c.getLinkPrecedence().equals("secondary")) {
					
					if (c.getEmail() != null) {
						emails.add(c.getEmail());
					}
					
					if (c.getPhoneNumber() != null) {
						phoneNumbers.add(c.getPhoneNumber());
					}
					
					if (c.getLinkPrecedence() != null && c.getLinkPrecedence().equalsIgnoreCase("secondary")) {
						secondaryContactIds.add(c.getId());
					}
					
					ids.add(c.getId());
					
				}

				if (contact.getEmail() != null) {
					if (c.getEmail() != null) {
						emails.add(c.getEmail());
					}
					
					if (c.getPhoneNumber() != null) {
						phoneNumbers.add(c.getPhoneNumber());
					}
				}
				
				if (contact.getPhoneNumber() != null) {
					if (c.getEmail() != null) {
						emails.add(c.getEmail());
					}
					
					if (c.getPhoneNumber() != null) {
						phoneNumbers.add(c.getPhoneNumber());
					}
				}
				
			});
			
			if (contact.getPhoneNumber() != null)
				phoneNumbers.add(contact.getPhoneNumber());
			
			if (contact.getEmail() != null)
				emails.add(contact.getEmail());
			
			contact.setLinkPrecedence("secondary");
			contact.setLinkedId(primaryContact.getId());
			
			Contact createdContact = null;
			createdContact = contactRepository.save(contact);
			
			if (createdContact != null)
				secondaryContactIds.add(createdContact.getId());
			
			emails.remove(primaryContact.getEmail());
			List<String> emailList = emails.stream().collect(Collectors.toList());
			emailList.add(0, primaryContact.getEmail());

			phoneNumbers.remove(primaryContact.getPhoneNumber());
			List<String> phoneNumberList = phoneNumbers.stream().collect(Collectors.toList());
			phoneNumberList.add(0, primaryContact.getPhoneNumber());
			
			contactResponse.setEmails(emailList);
			contactResponse.setPhoneNumbers(phoneNumberList);
			contactResponse.setPrimaryContactId(primaryContact.getId());
			contactResponse.setSecondaryContactIds(secondaryContactIds.stream().collect(Collectors.toList()));
			
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
		
		} catch (Exception e) {
			System.err.print("Error while saving the Secondary Contact Details" + e.getLocalizedMessage());
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
		}
	}
	
	private ResponseEntity<ContactResponse> generatePrimaryResponse(Contact contact) {
		
		ContactCustomResponse contactResponse = new ContactCustomResponse();
		
		try {
			
			contact.setLinkPrecedence("primary");
			Contact createdContact = contactRepository.save(contact);
			
			List<String> emails = new ArrayList<>();
			
			if (contact.getEmail() != null)
				emails.add(contact.getEmail());
			
			List<String> phoneNumbers = new ArrayList<>();
			
			if (contact.getPhoneNumber() != null)
				phoneNumbers.add(contact.getPhoneNumber());
			
			contactResponse.setEmails(emails);
			contactResponse.setPhoneNumbers(phoneNumbers);
			contactResponse.setPrimaryContactId(createdContact.getId());
			contactResponse.setSecondaryContactIds(new ArrayList<>());
			
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
			
		} catch (Exception e) {
			System.err.print("Error while saving the primary contact data" + e.getLocalizedMessage());
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
		}
		
	}
	
	private ResponseEntity<ContactResponse> getPartialReponse(List<Contact> contacts) {
		
		HashSet<String> emails = new HashSet<String>();
		HashSet<String> phoneNumbers = new HashSet<String>();
		HashSet<Long> secondaryContactIds = new HashSet<Long>();
		ContactCustomResponse contactResponse = new ContactCustomResponse();
		
		try {
			
			contacts.forEach((c) -> {
				if (c.getEmail() != null) {
					emails.add(c.getEmail());
				}
				
				if (c.getPhoneNumber() != null) {
					phoneNumbers.add(c.getPhoneNumber());
				}
				
				if (c.getLinkPrecedence() != null && c.getLinkPrecedence().equalsIgnoreCase("secondary")) {
					secondaryContactIds.add(c.getId());
				}
			});
			
			contactResponse.setEmails(emails.stream().collect(Collectors.toList()));
			contactResponse.setPhoneNumbers(phoneNumbers.stream().collect(Collectors.toList()));
			contactResponse.setPrimaryContactId(contacts.get(0).getId());
			contactResponse.setSecondaryContactIds(secondaryContactIds.stream().collect(Collectors.toList()));
			
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
		
		} catch (Exception e) {
			System.err.print("Error while saving the Secondary Partial Contact Details" + e.getLocalizedMessage());
			return new ResponseEntity<ContactResponse>(new ContactResponse(contactResponse), HttpStatus.OK);
		}
		
	}
}
