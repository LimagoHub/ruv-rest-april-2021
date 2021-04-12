package de.ruv.springschulung.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/personen")
@RequestScope
public class DemoController {
	
	
	@GetMapping(path = "/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> gruss() {
		return ResponseEntity.ok("Hallo Rest");
	}

//	@GetMapping(path = "/person", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	public ResponseEntity<PersonDTO> person() {
//		
//		return ResponseEntity.ok(PersonDTO.builder().id("1").vorname("John").nachname("Doe").build());
//	}
	
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonById(@PathVariable String id) {
		
		if("20".equals(id))
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(PersonDTO.builder().id(id).vorname("John").nachname("Doe").build());
	}

	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonByKeyValuePairs(@RequestParam(required = false) String vorname,@RequestParam(required = false) String nachname) {
		
		if(vorname == null) vorname = "*";
		if(nachname == null) nachname = "*";
		
	
		
		return ResponseEntity.ok(PersonDTO.builder().id("4711").vorname(vorname).nachname(nachname).build());
	}
	
	
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonByExample(@RequestBody PersonDTO example) {
		
		
		example.setNachname(example.getNachname().toUpperCase());
	
		
		return ResponseEntity.ok(PersonDTO.builder().id(example.getId()).vorname(example.getVorname()).nachname(example.getNachname()).build());
	}



}
