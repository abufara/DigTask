package com.abufara.models;

/**
 * 
 * User model
 * 
 * Attributes: 1- userId, int 2- name, String 3- phoneNumber, String 4-
 * isEmployee, boolean
 * 
 * @author PC
 *
 */
public class User {

	// userId counter
	private static int id = 1;

	// Attributes
	private int userId;
	private String name;
	private String phoneNumber;
	private boolean isEmployee;

	// Constructor
	public User(String name, String phoneNumber, boolean isEmployee) {

		this.userId = id++;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isEmployee = isEmployee;
	}

	// Setters and Getters
	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}
