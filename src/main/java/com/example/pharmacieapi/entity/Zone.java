package com.example.pharmacieapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Zone")
@Table(name = "Zone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;

	@OneToMany(mappedBy = "zone",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Pharmacie> pharmacies;

	@ManyToOne
	@JoinColumn(name = "ville_id")
	private Ville ville;
}
