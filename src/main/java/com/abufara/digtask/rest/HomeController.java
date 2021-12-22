package com.abufara.digtask.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * The controller of home page
 * 
 * @author PC
 *
 */
@RestController
public class HomeController {

	/*
	 * Mapping of the home page
	 * 
	 * It returns a string representing the time on server
	 */
	@GetMapping("/")
	public String sayHello() {

		return "Time on the server is " + LocalDateTime.now();
	}

	// handle any exception at runtime
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {

		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
