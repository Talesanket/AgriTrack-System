package com.example.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Component
@Entity
public class Farmer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private String name;
	private String contactNumber;
	private String email;
	private String address;
	@ManyToOne
	  @JsonBackReference
	Crop crop;

	public Farmer() {
		super();
	}

	public Farmer(String name, String contactNumber, String email, String address, Crop crop) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.crop = crop;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", email=" + email
				+ ", address=" + address + "]";
	}

}
