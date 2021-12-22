package com.abufara.utils;

import com.abufara.models.Bill;

/**
 * 
 * Billing util
 * 
 * @author PC
 *
 */
public class BillingUtil {

	// apply discount rules on bill amount
	public static double getBillAmountAfterDiscount(Bill bill) {

		double amountAfterDiscount = bill.getAmount();

		// apply Employee/Regular user discount rule
		if (bill.getUser().isEmployee()) {

			amountAfterDiscount -= amountAfterDiscount * 0.3;

		} else {

			amountAfterDiscount -= amountAfterDiscount * 0.1;
		}

		// apply above 100$ discount rule
		if (bill.getAmount() >= 100) {

			int numberOfHundreds = ((int) bill.getAmount()) / 100;

			amountAfterDiscount -= numberOfHundreds * 5;
		}

		return amountAfterDiscount;
	}
}
