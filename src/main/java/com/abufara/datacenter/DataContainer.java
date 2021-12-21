package com.abufara.datacenter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.abufara.models.Bill;
import com.abufara.models.User;

public class DataContainer {

	private static DataContainer dataContainer;

	private List<User> users;
	private List<Bill> bills;

	private DataContainer() {

		fillUsers();
		fillBills();
	}

	public static DataContainer getInstance() {

		if (dataContainer == null) {

			dataContainer = new DataContainer();
		}

		return dataContainer;
	}

	private void fillUsers() {

		users = Stream.of(new User("Mohammad Abufara", "0790000000", true),
				new User("Ihsan Rahhal", "0791111111", false), new User("Raed Khashan", "0792222222", false))
				.collect(Collectors.toList());
	}

	private void fillBills() {

		Random random = new Random();

		bills = users.stream().map(user -> new Bill(user, 25 * random.nextInt(5) * user.getUserId(), LocalDateTime.now())).toList();
	}

	public List<User> getUsers() {

		return users;
	}

	public List<Bill> getBills() {

		return bills;
	}
}
