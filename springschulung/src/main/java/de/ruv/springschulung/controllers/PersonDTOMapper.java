package de.ruv.springschulung.controllers;

import java.util.List;

import org.mapstruct.Mapper;

import de.ruv.springschulung.services.models.Person;

@Mapper(componentModel = "spring")
public interface PersonDTOMapper {
	
	PersonDTO convert(Person person);
	
	Person convert(PersonDTO personDTO);
	
	List<PersonDTO> convert(List<Person> personen);
}
