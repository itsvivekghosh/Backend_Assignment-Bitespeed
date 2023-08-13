package com.bitespeed.backendassignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bitespeed.backendassignment.models.Contact;



public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Query(value = "SELECT * FROM contact c WHERE (:email is null or c.email = :email) OR (:phone is null or c.phone_number = :phone)", nativeQuery = true)
	List<Contact> findByContactsEmailAddressOrPhoneNumber(@Param("email") String email, String phone);
	
}