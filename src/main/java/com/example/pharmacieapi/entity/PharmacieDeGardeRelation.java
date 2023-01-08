package com.example.pharmacieapi.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PharmacieDeGardeRelation implements Serializable {


    private int pharmaciePK;
	private int gardePK;
	private Date dateDebut;

	@Override
	public int hashCode() {
		return Objects.hash(pharmaciePK,gardePK);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PharmacieDeGardeRelation address = (PharmacieDeGardeRelation) o;
		return Objects.equals(pharmaciePK, address.pharmaciePK) &&

				Objects.equals(gardePK, address.gardePK);
	}

	public PharmacieDeGardeRelation(int pharmaciePK, int gardePK,Date dateDebut) {
		super();
		this.pharmaciePK = pharmaciePK;
		this.gardePK = gardePK;
		this.dateDebut=dateDebut;
	}


	public int getPharmaciePK() {
		return pharmaciePK;
	}

	public void setPharmaciePK(int pharmaciePK) {
		this.pharmaciePK = pharmaciePK;
	}

	public int getGardePK() {
		return gardePK;
	}

	public void setGardePK(int gardePK) {
		this.gardePK = gardePK;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public PharmacieDeGardeRelation() {

	}

}
