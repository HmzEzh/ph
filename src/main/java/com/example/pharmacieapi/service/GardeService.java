package com.example.pharmacieapi.service;

import com.example.pharmacieapi.entity.Garde;
import com.example.pharmacieapi.entity.Ville;
import com.example.pharmacieapi.repositories.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardeService {
    @Autowired
    private GardeRepository repository;

    public List<Garde> findAllGardes(){

        return repository.findAll();
    }

    public Garde addGarde(Garde g) {
        return repository.save(g);
    }

    public Garde updateGarde(Garde g, int id) {
        return repository.findById(id).map(
                garde -> {
                    garde.setType(g.getType());
                    return repository.save(garde);
                }
        ).orElse(null);
    }

    public Garde findGardeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteGarde(int id) {
        repository.deleteById(id);
        return "Garde "+id+" est supprimé !!";
    }


}
