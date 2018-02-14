package com.anuroop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
public class UserController {
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody User user) {
		System.out.println("DEBUG: " + user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}