package com.anuroop.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {
	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Duniya") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}