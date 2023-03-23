package com.dtd.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ContactDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ContactId;
	private long Mobileno;
	private String operatorName;
	

	public int getContactId() {
		return ContactId;
	}

	public void setContactId(int contactId) {
		ContactId = contactId;
	}

	public long getMobileno() {
		return Mobileno;
	}

	public void setMobileno(long mobileno) {
		Mobileno = mobileno;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

		
}
