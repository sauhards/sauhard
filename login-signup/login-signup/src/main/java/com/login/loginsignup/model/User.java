package com.login.loginsignup.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@AllArgsConstructor
public class User {

	@Id
	String id;
	String firstName;
	String lastName;
	String email;
	String contact;
	String password;


	public String getId() { return this.id; }
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName;	}
	public String getEmail() { return this.email;	}
	public String getContact() { return this.contact;	}
	public String getPassword() {
		return this.password;
	}

	public void setId(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.password = firstName;
	}
	public void setLastName(String lastName) { this.password = lastName; }
	public void setEmail(String email) {
		this.password = email;
	}
	public void setContact(String contact) {
		this.password = contact;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
