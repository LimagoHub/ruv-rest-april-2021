package de.ruv.springschulung.services;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import de.ruv.springschulung.services.models.Person;

public interface PersonService {

	boolean speichern(Person person) throws PersonServiceException;

}