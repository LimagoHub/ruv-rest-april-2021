package de.ruv.springschulung.services.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	

	private String id;
	
	
	private String vorname;
	
	
	private String nachname;
}
