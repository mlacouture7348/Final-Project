package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.app.constraint.FieldMatch;

@FieldMatch.List({
	@FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class CustomerDto {

	@NotEmpty(message = "First name cannot be null")
	private String firstName;
	
	@NotEmpty(message = "Last name cannot be null")
	private String lastName;
	
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be null")
	private String email;
	
	@Email(message = "Email should be valid")
	@NotEmpty
	private String confirmEmail;
	
	@NotEmpty
	private String address;
	
	private String sex;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
