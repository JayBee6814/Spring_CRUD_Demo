package com.CRUDDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id @GeneratedValue
	private long id;
	
	@Column(name = "first_name", length = 50)
	@NotBlank(message = "First name is required.")
	@Pattern(regexp = "^[A-Za-z0-9\\s\\-._~:\\/?#\\[\\]@!$&'()*+,;=]*$", message = "Input contains illegal characters.")
	@Size(max = 50, message = "Input exceeds size limits.")
	private String firstName;
	
	@Column(name = "last_name", length = 50)
	@NotBlank(message = "Last name is required.")
	@Pattern(regexp = "^[A-Za-z0-9\\s\\-._~:\\/?#\\[\\]@!$&'()*+,;=]*$", message = "Input contains illegal characters.")
	@Size(max = 50, message = "Input exceeds size limits.")
	private String lastName;
	
	@Column(name = "email", length = 320, unique = true)
    @NotBlank(message = "Email is required.")
    // Check if text is valid per RFC 3986.
    @Email(message = "Invalid email address.")
	private String email;
	
	@Column(name = "phone", length = 10)
    @NotBlank(message = "Phone number is required.")
    @Pattern(regexp = "^[2-9]\\d{2}\\d{3}\\d{4}$", message = "Invalid phone number.")
    @Size(min = 10, max = 10, message = "Incorrect Phone Length")
    private String phone;
	
	
	public User() {}
	
	public User(String firstName, String lastName, String email, String phone) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + "]";
	}
	
}

