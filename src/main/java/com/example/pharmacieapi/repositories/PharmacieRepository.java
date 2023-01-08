package com.example.pharmacieapi.repositories;

import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {

	@Query("select p from Pharmacie p where p.etat=0")
	List<Pharmacie> findAllPharmacieAttente();

	Pharmacie findPharmacieByUser(User user);

	@Query("select p from Pharmacie p where p.etat=1")
	List<Pharmacie> findAllPharmacieAccepte();

	@Query("select p from Pharmacie p where p.etat=2")
	List<Pharmacie> findAllPharmacieRefus();

	@Query("select p from Pharmacie p where p.zone.ville.id =:id and p.etat=1")
	List<Pharmacie> findAllPharmacieByVille(@Param("id") int id);

	@Query("select p from Pharmacie p where p.zone.id =:id and p.etat=1")
	List<Pharmacie> findAllPharmacieByZone(@Param("id") int id);


	@Query("select p from Pharmacie p where p.zone.ville.id =:id and p.etat=1 and p.id not in(select pg.PharmacieDeGardeRelation.pharmaciePK from PharmacieDeGarde pg where CURRENT_DATE BETWEEN pg.PharmacieDeGardeRelation.dateDebut and pg.dateFin or CURRENT_DATE <pg.PharmacieDeGardeRelation.dateDebut )")
	List<Pharmacie> findPharmcieDispoByVille(@Param("id") int id);

	@Query("select p from Pharmacie p where p.zone.id =:id and p.etat=1 and p.id not in(select pg.PharmacieDeGardeRelation.pharmaciePK from PharmacieDeGarde pg where CURRENT_DATE BETWEEN pg.PharmacieDeGardeRelation.dateDebut and pg.dateFin or CURRENT_DATE <pg.PharmacieDeGardeRelation.dateDebut )")
	List<Pharmacie> findPharmcieDispoByZone(@Param("id") int id);

}
