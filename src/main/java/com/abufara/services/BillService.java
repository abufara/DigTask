package com.abufara.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abufara.datacenter.DataContainer;
import com.abufara.models.Bill;
import com.abufara.utils.BillingUtil;

@Service
public class BillService {

	private List<Bill> billsAfterDiscount;

	public List<Bill> getAllBills() {

		return DataContainer.getInstance().getBills();
	}

	public List<Bill> getAllBillsAfterDiscount() {

		initializeBillsAfterDiscount();

		return billsAfterDiscount;
	}

	public Bill getBillById(int billId) {

		return DataContainer.getInstance().getBills().stream().filter(bill -> bill.getBillId() == billId).findFirst()
				.orElse(null);
	}

	public Bill getBillByIdAfterDiscount(int billId) {

		initializeBillsAfterDiscount();

		Bill billAfterDiscount = billsAfterDiscount.stream().filter(bill -> bill.getBillId() == billId).findFirst()
				.orElse(null);

		return billAfterDiscount;
	}

	public List<Bill> getBillsByUserId(int userId) {

		return DataContainer.getInstance().getBills().stream().filter(bill -> bill.getUser().getUserId() == userId)
				.toList();
	}

	private void initializeBillsAfterDiscount() {

		if (billsAfterDiscount == null) {

			billsAfterDiscount = new ArrayList<Bill>(DataContainer.getInstance().getBills());

			billsAfterDiscount = billsAfterDiscount.stream().map(bill -> {
				Bill newBill = new Bill(bill);
				newBill.setAmount(BillingUtil.getBillAmountAfterDiscount(bill));
				return newBill;
			}).toList();
		}
	}
}
