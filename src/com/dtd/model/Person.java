package com.dtd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String personName;
	private String personAddress;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ContactDetails> contactDetails=new HashSet<ContactDetails>();

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public Set<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(Set<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}
	
}
