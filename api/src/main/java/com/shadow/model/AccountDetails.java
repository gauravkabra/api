package com.shadow.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountDetails {

	private int requestId;

	private String aadharNumber;

	private String status;

	private String user;

	private int salary;

	private String firstName;

	private String lastName;

	private String contactNumber;

	private String emailId;

	private String address1;
	private String address2;
	private String address3;

	private String profilePhoto;

	private String idProof;

	private String addressProof;

	private String nationality;

	private String alternateAddress;

	@XmlElement
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@XmlElement
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@XmlElement
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@XmlElement
	public String getAlternateAddress() {
		return alternateAddress;
	}

	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}

	@XmlElement
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@XmlElement
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@XmlElement
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@XmlElement
	public String getAddress2() {
		return address2;
	}

	@XmlElement
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@XmlElement
	public String getAddress3() {
		return address3;
	}

	@XmlElement
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@XmlElement
	public String getProfilePhoto() {
		return profilePhoto;
	}

	@XmlElement
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@XmlElement
	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	@XmlElement
	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	@XmlElement
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
