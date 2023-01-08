package com.example.pharmacieapi.service;


import com.example.pharmacieapi.entity.Garde;
import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.PharmacieDeGarde;
import com.example.pharmacieapi.repositories.PharmacieDeGardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieDeGardeService {
    @Autowired
    private PharmacieDeGardeRepository repository;

    public PharmacieDeGarde addPharmacieDeGarde(PharmacieDeGarde p){

    return repository.save(p);
    }
    public List<PharmacieDeGarde> getAllPharmaciesDeGarde(){
        return repository.findAll();
    }
    public List<PharmacieDeGarde> getAllPharmaciesDeGardeByPharmacie(Pharmacie pharmacie){
        return repository.findAllByPharmacie(pharmacie);
    }

    public List<PharmacieDeGarde> getPharmacieDeGardeHistorique(int id){
        return repository.findPharmacieGardeHistorique(id);
    }

    public List<PharmacieDeGarde> getAllPharmaciesDeGardeDispo() {
        return repository.findAllPharmacieDispo();
    }

    public List<PharmacieDeGarde> getAllPharmaciesDeGardeEnGarde() {
        return repository.findAllPharmacieEnGarde();
    }

    public List<PharmacieDeGarde> findAllPharmacieGardeByVille(int id) {
        return repository.findAllPharmacieGardeByVille(id);
    }

    public List<PharmacieDeGarde> findAllPharmacieGardeByZone(int id) {
        return repository.findAllPharmacieGardeByZone(id);
    }
    public List<PharmacieDeGarde> findAllPharmacieGardeEnGardeByGardeId(int id) {
        return repository.findAllPharmacieGardeEnGardeByGardeId(id);
    }

}
