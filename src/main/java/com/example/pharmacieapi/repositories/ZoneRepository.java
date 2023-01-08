package com.example.pharmacieapi.repositories;

import com.example.pharmacieapi.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	@Query("select z from Zone z where z.ville.id =:id")
	List<Zone> findAllZoneByVille(@Param("id") int id);

	@Query("select z.nom ,(select count(p) from Pharmacie p where p.zone.id=z.id and p.etat=1) from Zone z where z.ville.id=:id group by z.nom")
	List findNbrPharmacieZone(@Param("id") int id);

}
