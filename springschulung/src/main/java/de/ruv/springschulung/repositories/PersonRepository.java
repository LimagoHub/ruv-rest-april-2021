package de.ruv.springschulung.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.ruv.springschulung.repositories.entities.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, String> {
	
	List<PersonEntity> findByVorname(String vorname);
	List<PersonEntity> findByNachname(String nachname);
	List<PersonEntity> findByVornameAndNachnameOrderByNachnameAsc(String vorname, String nachname);
	List<PersonEntity> findByVornameOrNachnameOrderByNachnameAsc(String vorname, String nachname);
	
	List<PersonEntity> findeAlle();
}
