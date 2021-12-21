package com.abufara.models;

import java.time.LocalDateTime;

public class Bill {

	private static int id = 1;

	int billId;
	private User user;
	private double amount;
	private LocalDateTime billDateTime;

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
