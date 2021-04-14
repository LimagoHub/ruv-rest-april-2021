package de.ruv.springschulung.services.models;

import lombok.AccessLevel;

import lombok.Builder;
import lombok.Data;

import lombok.Setter;

@Data
@Builder
public class Schwein {

	@Setter(value = AccessLevel.PRIVATE)
	private String id;

	private String name;

	@Setter(value = AccessLevel.PRIVATE)
	private int gewicht;

	public void fressen() {
		setGewicht(getGewicht() + 1);
	}
}
