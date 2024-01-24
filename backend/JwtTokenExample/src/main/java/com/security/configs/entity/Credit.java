package com.security.configs.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credit")
@CrossOrigin(origins = "*")
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bankcustmer;
	private String pan;
	private long mobile;
	private String occupation;
	private String organization;
	private String addresslineone;
	private String addresslinetwo;
	private long pincode;
	private String city;
	private String communication;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankcustmer() {
		return bankcustmer;
	}
	public void setBankcustmer(String bankcustmer) {
		this.bankcustmer = bankcustmer;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAddresslineone() {
		return addresslineone;
	}
	public void setAddresslineone(String addresslineone) {
		this.addresslineone = addresslineone;
	}
	public String getAddresslinetwo() {
		return addresslinetwo;
	}
	public void setAddresslinetwo(String addresslinetwo) {
		this.addresslinetwo = addresslinetwo;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	

	
}
