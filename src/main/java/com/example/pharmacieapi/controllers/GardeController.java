package com.example.pharmacieapi.controllers;

import com.example.pharmacieapi.entity.Garde;
import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.Ville;
import com.example.pharmacieapi.service.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gardes")
@CrossOrigin("http://localhost:3000")
public class GardeController {

    @Autowired
    private GardeService service;

    @GetMapping("/all")
    public List<Garde> findAllGarde(){
        return service.findAllGardes();
    }

    @PostMapping("/add")
    public Garde save(@RequestBody Garde g) {
        return service.addGarde(g);
    }

    @GetMapping("/garde/id={id}")
    public Garde findGardeById(@PathVariable int id){

        return service.findGardeById(id);
    }
    @PutMapping("/updateGarde/id={id}")
    public Garde updateGarde(@RequestBody Garde g,@PathVariable int id){

        return service.updateGarde(g,id);
    }

    @DeleteMapping("/deleteGarde/id={id}")
    public String deleteGarde(@PathVariable int id){

        return service.deleteGarde(id);
    }

}
