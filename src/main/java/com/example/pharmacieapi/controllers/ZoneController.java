package com.example.pharmacieapi.controllers;


import java.util.List;

import com.example.pharmacieapi.entity.Ville;
import com.example.pharmacieapi.entity.Zone;
import com.example.pharmacieapi.repositories.ZoneRepository;
import com.example.pharmacieapi.service.VilleService;
import com.example.pharmacieapi.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/zones")
@CrossOrigin("http://localhost:3000")
public class ZoneController {

	@Autowired
	private ZoneService service;

	@Autowired
	private VilleService vservice;

	@PostMapping("/add")
	public Zone save(@RequestParam("nom") String nom,
					 @RequestParam("ville_id") int ville_id) {
		Zone z = new Zone();
		Ville v = new Ville();
		v = vservice.findVilleById(ville_id);
		z.setNom(nom);
		z.setVille(v);
		return service.addZone(z);
	}

	@GetMapping("/all")
	public List<Zone> findAllZone(){

		return service.findAllZone();
	}

	@GetMapping("/zone/id={id}")
	public Zone findZoneById(@PathVariable int id){

		return service.findZoneById(id);
	}

	@GetMapping("/zone/ville={id}")
	public List<Zone> findAllZoneByVille(@PathVariable int id){

		return service.findAllZoneByVille(id);
	}

	@PutMapping("/updateZone/id={id}")
	public Zone updateZone(@RequestParam("nom") String nom,
						   @RequestParam("ville_id") int ville_id,@PathVariable int id){
		Zone z = new Zone();
		Ville v = new Ville();
		v = vservice.findVilleById(ville_id);
		z.setNom(nom);
		z.setVille(v);
		return service.updateZone(z,id);
	}

	@DeleteMapping("/deleteZone/id={id}")
	public String deleteZone(@PathVariable int id){

		return service.deleteZone(id);
	}

	@GetMapping("/NbrPharmacieZone/ville={id}")
	public List findNbrPharmacieZone(@PathVariable int id){
		return service.findNbrPharmacieZone(id);
	}
}