package com.aconsolaro.calculadora.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableController {

	private static final String template = "OK, %s!";
	private AtomicLong counter = new AtomicLong();
	
	@GetMapping("/available")
	private String available() {
		return String.format(template, counter.incrementAndGet());
	}
}
