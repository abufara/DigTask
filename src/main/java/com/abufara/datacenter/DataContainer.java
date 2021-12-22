package com.abufara.datacenter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.abufara.models.Bill;
import com.abufara.models.User;

/**
 * 
 * A Class Representing the Database Designed as a Singleton It populates data
 * the first time it is called and gives access to it
 * 
 * @author PC
 *
 */
public class DataContainer {

	// Singleton instance
	private static DataContainer dataContainer;

	// collections of the data
	private List<User> users;
	private List<Bill> bills;

	/*
	 * Singleton constructor it fills the collections of the data
	 */
	private DataContainer() {

		fillUsers();
		fillBills();
	}

	// To initialize the Singleton instance and return it
	public static DataContainer getInstance() {

		if (dataContainer == null) {

			dataContainer = new DataContainer();
		}

		return dataContainer;
	}

	// Populate users data
	private void fillUsers() {

		users = Stream.of(new User("Mohammad Abufara", "0790000000", true),
				new User("Ihsan Rahhal", "0791111111", false), new User("Raed Khashan", "0792222222", false))
				.collect(Collectors.toList());
	}

	// Populate bills data
	private void fillBills() {

		Random random = new Random();

		bills = users.stream()
				.map(user -> new Bill(user, 25 * random.nextInt(5) * user.getUserId(), LocalDateTime.now())).toList();
	}

	// get all users data
	public List<User> getUsers() {

		return users;
	}

	// get all bills data
	public List<Bill> getBills() {

		return bills;
	}
}
