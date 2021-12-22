package com.abufara.models;

import java.time.LocalDateTime;

/**
 * 
 * Bill model
 * 
 * Attributes:
 * 1- billId, int
 * 2- user, User
 * 3- amount, double
 * 4- billDateTime, LocalDateTime
 * 
 * @author PC
 *
 */
public class Bill {

	// billId counter
	private static int id = 1;

	// Attributes
	int billId;
	private User user;
	private double amount;
	private LocalDateTime billDateTime;

	// Constructors
	public Bill(User user, double amount, LocalDateTime billDateTime) {

		this.billId = id++;
		this.user = user;
		this.amount = amount;
		this.billDateTime = billDateTime;
	}

	public Bill(Bill bill) {

		this.billId = bill.getBillId();
		this.user = bill.getUser();
		this.amount = bill.getAmount();
		this.billDateTime = bill.getBillDateTime();
	}

	// Setters and Getters
	public int getBillId() {
		return billId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getBillDateTime() {
		return billDateTime;
	}

	public void setBillDateTime(LocalDateTime billDateTime) {
		this.billDateTime = billDateTime;
	}

}
