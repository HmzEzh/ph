package com.example.pharmacieapi.service;

import com.example.pharmacieapi.entity.Ville;
import com.example.pharmacieapi.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private VilleRepository repository;

    public Ville addVille(Ville v){
        return repository.save(v);
    }

    public List<Ville> findAllVille(){

        return repository.findAll();
    }

    public Ville  findVilleById(int id){

        return repository.findById(id).orElse(null);
    }

    public String deleteVille(int id){
        repository.deleteById(id);
        return "Ville "+id+" est supprimé !!";
    }

    public Ville updateVille(Ville v,int id){
        return repository.findById(id).map(
                ville -> {
                    ville.setNom(v.getNom());
                    return repository.save(ville);
                }
        ).orElse(null);
    }

    public List findNbrPharmacieVille() {
        return repository.findNbrPharmacieVille();
    }

    public List findNbrPharmacieEnGardeVille() {
        return repository.findNbrPharmacieGardeVille();
    }
}
