package de.ruv.springschulung.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/demo")
@RequestScope
public class DemoController {
	
	
	@GetMapping(path = "/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
	public String gruss() {
		return "Hallo Rest";
	}

	@GetMapping(path = "/person", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public PersonDTO person() {
		
		return PersonDTO.builder().id("1").vorname("John").nachname("Doe").build();
	}

}
