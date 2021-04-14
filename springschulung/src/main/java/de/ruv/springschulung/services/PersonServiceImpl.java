package de.ruv.springschulung.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.ruv.springschulung.repositories.PersonRepository;
import de.ruv.springschulung.services.models.Person;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = PersonServiceException.class, isolation = Isolation.READ_COMMITTED)
public class PersonServiceImpl implements PersonService {
	
	private final PersonRepository repo;
	private final PersonMapper mapper;

	public PersonServiceImpl(PersonRepository repo, final PersonMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional(rollbackFor = PersonServiceException.class, isolation = Isolation.READ_COMMITTED)
	public boolean speichern(Person person) throws PersonServiceException{
		
		try {
			return speichernImpl(person);
		} catch (RuntimeException e) {
			log.error("Upps", e);
			throw new PersonServiceException("Upps", e);
			
		}
	}

	private boolean speichernImpl(Person person) throws PersonServiceException {
		boolean retval = false;
		
		checkPerson(person);
		
		retval = repo.existsById(person.getId());
			
		repo.save(mapper.convert(person));
		
		return retval;
	}

	private void checkPerson(Person person) throws PersonServiceException {
		validatePerson(person);
		

		businessCheck(person);
	}

	private void businessCheck(Person person) throws PersonServiceException {
		if(person.getVorname().equals("Attila"))
			throw new PersonServiceException("Antipath");
	}

	private void validatePerson(Person person) throws PersonServiceException {
		if(person == null)
			throw new PersonServiceException("Person darf nicht null sein.");
		
		
		if(person.getVorname() == null || person.getVorname().length() < 2)
			throw new PersonServiceException("Vorname muss min 2 Zeichen enthalten.");
		
		if(person.getNachname() == null || person.getNachname().length() < 2)
			throw new PersonServiceException("Nachname muss min 2 Zeichen enthalten.");
	}

	@Override
	public Optional<Person> findePersonMitId(String id) throws PersonServiceException {
		
		try {
			return repo.findById(id).map(mapper::convert);
		} catch (Exception e) {
			throw new PersonServiceException(e);
		}
	}

	@Override
	public List<Person> findeAllePersonen() throws PersonServiceException{
		
		try {
			return mapper.convert(repo.findeAlle());
		} catch (Exception e) {
			throw new PersonServiceException(e);
		}
	}

	@Override
	public boolean loeschePersonMitId(String id) throws PersonServiceException {
		try {
			boolean exits = repo.existsById(id);
			if(exits)
				repo.deleteById(id);
			return exits;
		} catch (Exception e) {
			throw new PersonServiceException(e);
		}
	}
	
//	public void bulkspeichern(List<Person> personen) throws PersonServiceException{
//		
//			personen.forEach(this::speichern);
//		
//		
//	}
//
}
