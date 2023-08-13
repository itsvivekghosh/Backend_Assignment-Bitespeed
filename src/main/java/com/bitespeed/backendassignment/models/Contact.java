/**
 * 
 */

package com.bitespeed.backendassignment.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	          
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "linkedId")
	@PrimaryKeyJoinColumn
	private Long linkedId; 
	
	@Value("primary")
	@Column(name = "linkPrecedence")
	private String linkPrecedence;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = true, updatable = false)
	private LocalDateTime created_at;                   
	
	@Column(name = "updated_at")
	private LocalDateTime updated_at;              
	
	@Column(name = "deleted_at")
	private LocalDateTime deleted_at;
	
}

