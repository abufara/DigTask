package com.abufara.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abufara.datacenter.DataContainer;
import com.abufara.models.Bill;
import com.abufara.utils.BillingUtil;

/**
 * 
 * Billing Service
 * 
 * @author PC
 *
 */
@Service
public class BillService {

	// List of bill after applying the discount
	private List<Bill> billsAfterDiscount;

	// get all Bills before applying the discount
	public List<Bill> getAllBills() {

		return DataContainer.getInstance().getBills();
	}

	// get all Bills after applying the discount
	public List<Bill> getAllBillsAfterDiscount() {

		// calculate bills' amounts after applying the discount
		initializeBillsAfterDiscount();

		return billsAfterDiscount;
	}

	// get Bill by id before applying the discount
	public Bill getBillById(int billId) {

		// find the bill by billId
		Bill bill = DataContainer.getInstance().getBills().stream().filter(tempBill -> tempBill.getBillId() == billId)
				.findFirst().orElse(null);

		return bill;
	}

	// get Bill by id after applying the discount
	public Bill getBillByIdAfterDiscount(int billId) {

		// calculate bills' amounts after applying the discount
		initializeBillsAfterDiscount();

		// find the bill by billId
		Bill billAfterDiscount = billsAfterDiscount.stream().filter(bill -> bill.getBillId() == billId).findFirst()
				.orElse(null);

		return billAfterDiscount;
	}

	/*
	 * calculate bills' amounts after applying the discount and add them to
	 * billsAfterDiscount List
	 */
	private void initializeBillsAfterDiscount() {

		if (billsAfterDiscount == null) {

			billsAfterDiscount = new ArrayList<Bill>(DataContainer.getInstance().getBills());

			// map bills to new bills with new amounts after applying the discount
			billsAfterDiscount = billsAfterDiscount.stream().map(bill -> {
				Bill newBill = new Bill(bill);
				newBill.setAmount(BillingUtil.getBillAmountAfterDiscount(bill));
				return newBill;
			}).toList();
		}
	}
}
