package com.abufara.digtask.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abufara.models.Bill;
import com.abufara.services.BillService;

@RestController
public class BillController {

	@Autowired
	BillService billService;

	@GetMapping("/bills")
	public ResponseEntity<List<Bill>> getAllBills() {

		List<Bill> bills = billService.getAllBills();

		if (bills.isEmpty()) {

			return new ResponseEntity<List<Bill>>(bills, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

	@GetMapping("/billsAfterDiscount")
	public ResponseEntity<List<Bill>> getAllBillsAfterDiscount() {

		List<Bill> bills = billService.getAllBillsAfterDiscount();

		if (bills == null) {

			return new ResponseEntity<List<Bill>>(bills, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

	@GetMapping("/bill/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") int billId) {

		Bill bill = billService.getBillById(billId);

		if (bill == null) {

			return new ResponseEntity<Bill>(bill, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}

	@GetMapping("/billAfterDiscount/{id}")
	public ResponseEntity<Bill> getBillByIdAfterDiscount(@PathVariable("id") int billId) {

		Bill bill = billService.getBillByIdAfterDiscount(billId);

		if (bill == null) {

			return new ResponseEntity<Bill>(bill, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}
}
