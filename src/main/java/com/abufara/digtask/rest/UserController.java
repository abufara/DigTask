package com.abufara.digtask.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abufara.models.User;
import com.abufara.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = userService.getAllUsers();

		if (users == null) {

			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {

		User user = userService.getUserById(userId);

		if (user == null) {

			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
