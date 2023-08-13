/**
 * 
 */

package com.bitespeed.backendassignment.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
	
	// the ID of another Contact linked to this one
	@Column(name = "linkedId")
	@PrimaryKeyJoinColumn
	private Long linkedId; 
	
	// "secondary"|"primary" -> "primary" if it's the first Contact in the link
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

