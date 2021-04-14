package de.ruv.springschulung.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import de.ruv.springschulung.services.PersonService;
import de.ruv.springschulung.services.models.Person;

@RestController
@RequestMapping("/personen")
@RequestScope
public class PersonenController {
	
	private final PersonService service;
	private final PersonDTOMapper mapper;
	
	
	
	public PersonenController(PersonService service, PersonDTOMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}



//	@GetMapping(path = "/person", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	public ResponseEntity<PersonDTO> person() {
//		
//		return ResponseEntity.ok(PersonDTO.builder().id("1").vorname("John").nachname("Doe").build());
//	}
	
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonById(@PathVariable String id) throws Exception{
		return ResponseEntity.of(service.findePersonMitId(id).map(mapper::convert));
	}

//	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<PersonDTO> getPersonByKeyValuePairs(@RequestParam(required = false) String vorname,@RequestParam(required = false) String nachname) {
//
//		if(vorname == null) vorname = "*";
//		if(nachname == null) nachname = "*";
//		return ResponseEntity.ok(PersonDTO.builder().id("4711").vorname(vorname).nachname(nachname).build());
//	}
	
	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<PersonDTO>> getAllePersonen() throws Exception{

		return ResponseEntity.ok(mapper.convert(service.findeAllePersonen()));
	}
	
	
//	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<PersonDTO> getPersonByExample(@RequestBody PersonDTO example) {
//		
//		
//		example.setNachname(example.getNachname().toUpperCase());
//	
//		
//		return ResponseEntity.ok(PersonDTO.builder().id(example.getId()).vorname(example.getVorname()).nachname(example.getNachname()).build());
//	}
//

	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveOrUpdate(@RequestBody @Valid PersonDTO person) throws Exception { // Wenn idempotent!!!
		
		if(service.speichern(mapper.convert(person)))	
			return ResponseEntity.status(HttpStatus.OK).build();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> saveOrUpdatePost(@RequestBody PersonDTO person,  UriComponentsBuilder b) { // Wenn NICHT idempotent!!!
//		// NICHT idempotenter Serviceaufruf zum speichern
//		person.setId(UUID.randomUUID().toString());
//		System.out.println("Person: " + person + " wurde gespeichert");
//		UriComponents uriComponents = b.path("personen/{id}").buildAndExpand(person.getId());
//		return ResponseEntity.created(uriComponents.toUri()).build();
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersonById(@PathVariable String id) throws Exception{
		
		if(service.loeschePersonMitId(id))
			return ResponseEntity.ok().build();
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletePersonByDTO(@RequestBody PersonDTO person) throws Exception {
		return deletePersonById(person.getId());
	}
	

}
