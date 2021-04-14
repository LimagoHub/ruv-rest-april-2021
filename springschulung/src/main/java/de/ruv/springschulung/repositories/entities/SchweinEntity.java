package de.ruv.springschulung.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="tblschweine")
public class SchweinEntity {

	@Id
	@Column(length = 36, nullable = false)
	private String id;
	@Column(length = 30, nullable = false)
	private String name;
	@Column(nullable = false)
	private int gewicht;
}
