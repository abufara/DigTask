package com.abufara.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abufara.datacenter.DataContainer;
import com.abufara.models.User;

@Service
public class UserService {

	public List<User> getAllUsers() {

		return DataContainer.getInstance().getUsers();
	}

	public User getUserById(int userId) {

		return DataContainer.getInstance().getUsers().stream().filter(user -> user.getUserId() == userId).findFirst()
				.orElse(null);
	}
}
