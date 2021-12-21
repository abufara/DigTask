package com.abufara.models;

public class User {

	private static int id = 1;

	private int userId;
	private String name;
	private String phoneNumber;
	private boolean isEmployee;

	public User(String name, String phoneNumber, boolean isEmployee) {

		this.userId = id++;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isEmployee = isEmployee;
	}

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
