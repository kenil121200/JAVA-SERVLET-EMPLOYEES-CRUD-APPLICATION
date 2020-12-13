package com.bean;

import java.sql.Date;

public class EmployeesBean 
{
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date bday;
	private String gender;
	private String email;
	private String password;
	private long contact;
	private String address;
	private int pincode;
	private String state;
	private String city;	
	
	public EmployeesBean(int id, String firstName, String middleName, String lastName, Date bday, String gender,String email, String password, long contact, String address, int pincode, String state, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bday = bday;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.address = address;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
	}
	public EmployeesBean() {
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
	
		return id+" "+firstName+" "+middleName+" "+lastName;
	}
}
