package de.ruv.springschulung.controllers;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchweinDTO {
	
	@NotNull
	@Size(min = 36, max = 36)
	private String id;
	
	@NotNull
	@Size(min = 1, max = 30)
	private String name;
	
	
	@DecimalMin("10")
	private int gewicht;
}
