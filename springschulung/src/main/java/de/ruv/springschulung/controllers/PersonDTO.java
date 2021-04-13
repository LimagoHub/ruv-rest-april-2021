package de.ruv.springschulung.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement  // Nur für XML
public class PersonDTO {
	
	@NotNull
	@Size(min = 36, max = 36)
	private String id;
	
	@NotNull
	@Size(min = 2)
	private String vorname;
	
	@NotNull
	@Size(min = 2)
	private String nachname;

}
