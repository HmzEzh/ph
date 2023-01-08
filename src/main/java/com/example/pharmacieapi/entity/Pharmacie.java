package com.example.pharmacieapi.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Pharmacie")
@Table(name = "Pharmacie")
@Data
@AllArgsConstructor
public class Pharmacie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private Double lat;
	private Double log;
	private int etat;

	@ManyToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;

	@OneToMany(mappedBy = "pharmacie")
	@JsonIgnore
	private List<PharmacieDeGarde> gardes ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonIgnore

	private User user;
	public void addPharmacieDeGarde(PharmacieDeGarde garde){
		this.gardes.add(garde);
		garde.setPharmacie(this);
	}

	public Pharmacie() {
		this.gardes=new ArrayList<>();

	}
}
