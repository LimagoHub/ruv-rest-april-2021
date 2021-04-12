package de.ruv.springschulung.controllers;

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
	
	private String id;
	private String vorname;
	private String nachname;

}
