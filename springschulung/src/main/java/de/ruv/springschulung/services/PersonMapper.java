package de.ruv.springschulung.services;

import java.util.List;

import org.mapstruct.Mapper;

import de.ruv.springschulung.repositories.entities.PersonEntity;
import de.ruv.springschulung.services.models.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	Person convert(PersonEntity entity);
	PersonEntity convert(Person person);
	List<Person> convert(List<PersonEntity> entities);
}
