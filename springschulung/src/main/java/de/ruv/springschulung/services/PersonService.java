package de.ruv.springschulung.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import de.ruv.springschulung.services.models.Person;

public interface PersonService {

	boolean speichern(Person person) throws PersonServiceException;
	Optional<Person> findePersonMitId(String id)  throws PersonServiceException;
	List<Person> findeAllePersonen()  throws PersonServiceException;;
	boolean loeschePersonMitId(String id)  throws PersonServiceException;

}