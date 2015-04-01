package edu.csumb.scd.csit;
/**
 * Title: Student.java
 * Abstract: This program creates an object which includes an
 * 			 instructor’s unique employee number, name,
 * 			 email, and phone number. 
 * Author: Brian De Anda
 * ID: 2222
 * Date: Oct 23, 2014
 */
public class Instructor {
	private int employeeNum;
	private String name;
	private String email;
	private String phoneNumber;

	public Instructor(int employeeNum, String name, String email,
			String phoneNumber) {
		this.employeeNum = employeeNum; 
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEmployeeNum() {
		return employeeNum;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
