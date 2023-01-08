package com.example.pharmacieapi.service;

import com.example.pharmacieapi.entity.Zone;
import com.example.pharmacieapi.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repository;

    public Zone addZone(Zone z){
        return repository.save(z);
    }

    public List<Zone> findAllZone(){

        return repository.findAll();
    }

    public Zone  findZoneById(int id){

        return repository.findById(id).orElse(null);
    }

    public String deleteZone(int id){
        repository.deleteById(id);
        return "Zone "+id+" est supprimé !!";
    }

    public Zone updateZone(Zone z,int id){
        return repository.findById(id).map(
                zone -> {
                    zone.setNom(z.getNom());
                    zone.setVille(z.getVille());
                    return repository.save(zone);
                }
        ).orElse(null);
    }

    public List<Zone> findAllZoneByVille(int id) {
        return repository.findAllZoneByVille(id);
    }

    public List findNbrPharmacieZone(int id) {
        return repository.findNbrPharmacieZone(id);
    }
}
