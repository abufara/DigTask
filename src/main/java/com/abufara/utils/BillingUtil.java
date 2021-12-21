package com.abufara.utils;

import com.abufara.models.Bill;

public class BillingUtil {

	public static double getBillAmountAfterDiscount(Bill bill) {

		double amountAfterDiscount = bill.getAmount();

		if (bill.getUser().isEmployee()) {

			amountAfterDiscount -= amountAfterDiscount * 0.3;

		} else {

			amountAfterDiscount -= amountAfterDiscount * 0.1;
		}

		if (bill.getAmount() >= 100) {

			int numberOfHundreds = ((int) bill.getAmount()) / 100;

			amountAfterDiscount -= numberOfHundreds * 5;
		}

		return amountAfterDiscount;
	}
}
