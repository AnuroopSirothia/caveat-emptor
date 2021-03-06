package com.anuroop.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
@RequestMapping("/hi")
public class HelloController {
	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Duniya") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value = "/usertest", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody User user) {
		System.out.println("DEBUG: " + user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}