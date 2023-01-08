package com.example.pharmacieapi;

import com.example.pharmacieapi.controllers.PharmacieDeGardeController;
import com.example.pharmacieapi.entity.PharmacieDeGarde;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.List;

@SpringBootApplication
public class PharmacieApiApplication implements Runnable {



	@Autowired
	PharmacieDeGardeController pharmacieDeGardeController;
	public static void main(String[] args) {
		SpringApplication.run(PharmacieApiApplication.class, args);
	}

	@Override
	public void run() {
		pharmacieDeGardeController = new PharmacieDeGardeController();
		try {
			for (PharmacieDeGarde p: pharmacieDeGardeController.getAllPharmaciesDeGardeByPharmacieId(2)
				 ) {
				System.out.println(p.getPharmacieDeGardePK().getPharmaciePK()+"");
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}



