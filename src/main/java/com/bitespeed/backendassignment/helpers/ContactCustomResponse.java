package com.bitespeed.backendassignment.helpers;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactCustomResponse {
	
	private Long primaryContactId;
	
	private List<String> emails;
	
	private List<String> phoneNumbers;
	
	private List<Long> secondaryContactIds;
	
}