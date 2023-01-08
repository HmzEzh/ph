package com.example.pharmacieapi.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
public class PharmacieDeGarde {

	@EmbeddedId
	private PharmacieDeGardeRelation PharmacieDeGardeRelation = new PharmacieDeGardeRelation();
	private Date dateFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pharmaciePK",nullable = false, insertable = false, updatable = false)
	@MapsId("pharmaciePK")
	private Pharmacie pharmacie;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gardePK", nullable = false, insertable = false, updatable = false)
	@MapsId("gardePK")
	private Garde garde;



	public PharmacieDeGarde(PharmacieDeGardeRelation pharmacieDeGardeRelation, Date dateFin,Date dateDebut) {
		super();
		PharmacieDeGardeRelation = pharmacieDeGardeRelation;
		this.dateFin = dateFin;

	}

	public PharmacieDeGardeRelation getPharmacieDeGardePK() {
		return PharmacieDeGardeRelation;
	}

	public void setPharmacieDeGardePK(PharmacieDeGardeRelation pharmacieDeGardeRelation) {
		PharmacieDeGardeRelation = pharmacieDeGardeRelation;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}



	public com.example.pharmacieapi.entity.PharmacieDeGardeRelation getPharmacieDeGardeRelation() {
		return PharmacieDeGardeRelation;
	}

	public void setPharmacieDeGardeRelation(com.example.pharmacieapi.entity.PharmacieDeGardeRelation pharmacieDeGardeRelation) {
		PharmacieDeGardeRelation = pharmacieDeGardeRelation;
	}

	public PharmacieDeGarde() {
		super();
	}

}
