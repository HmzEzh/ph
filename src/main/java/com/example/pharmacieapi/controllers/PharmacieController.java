package com.example.pharmacieapi.controllers;

import java.util.List;

import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.User;
import com.example.pharmacieapi.repositories.PharmacieRepository;
import com.example.pharmacieapi.repositories.UserRepository;
import com.example.pharmacieapi.service.PharmacieService;
import com.example.pharmacieapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pharmacies")
@CrossOrigin("http://localhost:3000")
public class PharmacieController {

	@Autowired
	private PharmacieService service;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	 private UserService userService;

	@PostMapping("/add/{user_id}")
	public Pharmacie save(@RequestBody Pharmacie p,@PathVariable int user_id) {
		p.setEtat(0);
		User user = userRepository.findById(user_id).get();
		p.setUser(user);
		return service.addPharmacie(p);
	}

	@GetMapping("/all")
	public List<Pharmacie> findAllPharmacie(){
		return service.findAllPharmacie();
	}

	@GetMapping("/allEnAttente")
	public List<Pharmacie> findAllPharmacieEnAttente(){
		return service.findAllPharmacieEnAttente();
	}

	@GetMapping("/allAccepte")
	public List<Pharmacie> findAllPharmacieAccepte(){
		return service.findAllPharmacieAccepte();
	}

	@GetMapping("/allRefus")
	public List<Pharmacie> findAllPharmacieRefus(){
		return service.findAllPharmacieRefus();
	}

	@GetMapping("/allDispoByVille/id={id}")
	public List<Pharmacie> findAllPharmacieDispoByVille(@PathVariable int id){
		return service.findAllPharmacieDispoByVille(id);
	}

	@GetMapping("/allDispoByZone/id={id}")
	public List<Pharmacie> findAllPharmacieDispoByZone(@PathVariable int id){
		return service.findAllPharmacieDispoByZone(id);
	}

	@GetMapping("/pharmacie/id={id}")
	public Pharmacie findPharmacieById(@PathVariable int id){
		return service.findPharmacieById(id);
	}

	@GetMapping("/pharmacie/user_id={id}")
	public Pharmacie findPharmacieByUserId(@PathVariable int id){

		System.out.println(id +"hahouwa ");
		User user = userService.getUserById(id);
		return service.findPharmacieByUser(user);}

	@GetMapping("/pharmacie/ville={id}")
	public List<Pharmacie> findPharmacieByVille(@PathVariable int id){
		return service.findAllPharmacieByVille(id);
	}

	@GetMapping("/pharmacie/zone={id}")
	public List<Pharmacie> findPharmacieByZone(@PathVariable int id){
		return service.findAllPharmacieByZone(id);
	}

	@PutMapping("/acceptePharmacie/id={id}")
	public Pharmacie acceptePharmacie(@PathVariable int id){

		return service.acceptePharmacie(id);
	}

	@PutMapping("/refusPharmacie/id={id}")
	public Pharmacie refusPharmacie(@PathVariable int id){

		return service.refusPharmacie(id);
	}

	@PutMapping("/updatePharmacie/id={id}")
	public Pharmacie updatePharmacie(@RequestBody Pharmacie p,@PathVariable int id){

		return service.updatePharmacie(p,id);
	}

	@DeleteMapping("/deletePharmacie/id={id}")
	public String deletePharmacie(@PathVariable int id){
		return service.deletePharmacie(id);
	}
	@GetMapping("/pharmacie/garde={id}")
	public List<Pharmacie> findAllPharmacieByGarde(@PathVariable int id){
		return service.findAllPharmacieByGarde(id);
	}

}