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

/**
 * 
 * The controller of Bill service
 * 
 * @author PC
 *
 */

@RestController
public class BillController {

	// BillService instance
	@Autowired
	BillService billService;

	/*
	 * Mapping of the get request for all bills before the discount
	 * 
	 * It returns all bills and OK response, otherwise it returns NOT_FOUND response
	 */
	@GetMapping("/bills")
	public ResponseEntity<List<Bill>> getAllBills() {

		List<Bill> bills = billService.getAllBills();

		if (bills.isEmpty()) {

			return new ResponseEntity<List<Bill>>(bills, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

	/*
	 * Mapping of the get request for all bills after the discount
	 * 
	 * It returns all bills after discount and OK response, otherwise it returns
	 * NOT_FOUND response
	 */
	@GetMapping("/billsAfterDiscount")
	public ResponseEntity<List<Bill>> getAllBillsAfterDiscount() {

		List<Bill> bills = billService.getAllBillsAfterDiscount();

		if (bills == null) {

			return new ResponseEntity<List<Bill>>(bills, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

	/*
	 * Mapping of the get request for a specified bill
	 * 
	 * It returns the specified bill and OK response, otherwise it returns NOT_FOUND
	 * response
	 */
	@GetMapping("/bill/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") int billId) {

		Bill bill = billService.getBillById(billId);

		if (bill == null) {

			return new ResponseEntity<Bill>(bill, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}

	/*
	 * Mapping of the get request for a specified bill after the discount
	 * 
	 * It returns the specified bill after the discount and OK response, otherwise
	 * it returns NOT_FOUND response
	 */
	@GetMapping("/billAfterDiscount/{id}")
	public ResponseEntity<Bill> getBillByIdAfterDiscount(@PathVariable("id") int billId) {

		Bill bill = billService.getBillByIdAfterDiscount(billId);

		if (bill == null) {

			return new ResponseEntity<Bill>(bill, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}
}
