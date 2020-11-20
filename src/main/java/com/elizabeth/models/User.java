package com.elizabeth.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
@Entity @ToString 
@Table(name="users")
public class User {
	/*
	 * Possible refactor of String phoneNumber 
	 * into three number segments for additional validation?
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	@Column(unique = true)
	private String email;
	private boolean receivesNotifications;
	
	public User(String firstName, String lastName, String phoneNumber, String email, boolean receivesNotifications) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.receivesNotifications = receivesNotifications;
	}
	
	public User(int id, String firstName, String lastName, String phoneNumber, String email, boolean receivesNotifications) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.receivesNotifications = receivesNotifications;
	}
}
