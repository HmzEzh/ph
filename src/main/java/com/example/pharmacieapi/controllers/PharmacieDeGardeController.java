package com.example.pharmacieapi.controllers;

import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.PharmacieDeGarde;
import com.example.pharmacieapi.entity.User;
import com.example.pharmacieapi.repositories.UserRepository;
import com.example.pharmacieapi.service.PharmacieDeGardeService;
import com.example.pharmacieapi.service.PharmacieService;
import com.example.pharmacieapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pharmaciesDeGarde")
@CrossOrigin("http://localhost:3000")
public class PharmacieDeGardeController {

    @Autowired
    private PharmacieDeGardeService service;
    @Autowired
    private PharmacieService pharmacieService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/add/{debut}/{fin}")
    public PharmacieDeGarde save(@RequestBody PharmacieDeGarde p, @PathVariable String debut,@PathVariable String fin) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date utilDate1 = sdf.parse(debut);
        java.util.Date utilDate2 = sdf.parse(fin);

        // Convert the java.util.Date object to a java.sql.Date object
        long millis1 = utilDate1.getTime();
        long millis2 = utilDate2.getTime();

        java.sql.Date debutSql = new java.sql.Date(millis1);
        java.sql.Date finSql = new java.sql.Date(millis2);

        p.getPharmacieDeGardePK().setDateDebut(debutSql);
        p.setDateFin(finSql);
        System.out.println(p.getPharmacieDeGardePK().getDateDebut());
        System.out.println(p.getDateFin());
        System.out.println(p.getGarde().getIdGarde());
        System.out.println(p.getPharmacie().getId());

        return service.addPharmacieDeGarde(p);
    }
    @GetMapping("/all")
    public List<PharmacieDeGarde> getAllPharmaciesDeGarde() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieDeGarde> pharmacieDeGardes = new ArrayList<>();

        for (PharmacieDeGarde p: service.getAllPharmaciesDeGarde())
        {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(p.getPharmacieDeGardePK().getDateDebut()));
          java.util.Date utilDate2 = sdf.parse(String.valueOf(p.getDateFin()));

            // Convert the java.util.Date object to a java.sql.Date object
            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            p.getPharmacieDeGardePK().setDateDebut(debutSql);
            p.setDateFin(finSql);

            pharmacieDeGardes.add(p);
        }
        return pharmacieDeGardes ;
    }

    @GetMapping("/allDispo")
    public List<PharmacieDeGarde> getAllPharmaciesDeGardeDispo() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieDeGarde> pharmacieDeGardes = new ArrayList<>();

        for (PharmacieDeGarde p: service.getAllPharmaciesDeGardeDispo())
        {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(p.getPharmacieDeGardePK().getDateDebut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(p.getDateFin()));

            // Convert the java.util.Date object to a java.sql.Date object
            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            p.getPharmacieDeGardePK().setDateDebut(debutSql);
            p.setDateFin(finSql);

            pharmacieDeGardes.add(p);
        }
        return pharmacieDeGardes ;
    }

    @GetMapping("/allEnGarde")
    public List<PharmacieDeGarde> getAllPharmaciesDeGardeEnGarde() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieDeGarde> pharmacieDeGardes = new ArrayList<>();

        for (PharmacieDeGarde p: service.getAllPharmaciesDeGardeEnGarde())
        {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(p.getPharmacieDeGardePK().getDateDebut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(p.getDateFin()));

            // Convert the java.util.Date object to a java.sql.Date object
            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            p.getPharmacieDeGardePK().setDateDebut(debutSql);
            p.setDateFin(finSql);

            pharmacieDeGardes.add(p);
        }
        return pharmacieDeGardes ;
    }

    @GetMapping("/EnGarde/ville={id}")
    public List<PharmacieDeGarde> findPharmacieGardeByVille(@PathVariable int id){
        return service.findAllPharmacieGardeByVille(id);
    }

    @GetMapping("/EnGarde/zone={id}")
    public List<PharmacieDeGarde> findPharmacieGardeByZone(@PathVariable int id){
        return service.findAllPharmacieGardeByZone(id);
    }

    @GetMapping("/Historique/id={id}")
    public List<PharmacieDeGarde> findPharmacieGardeHistorique(@PathVariable int id){
        return service.getPharmacieDeGardeHistorique(id);
    }
    @GetMapping("/all/user_id={user_id}")
    public List<PharmacieDeGarde> getAllPharmaciesDeGardeByPharmacieId(@PathVariable int user_id) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<PharmacieDeGarde> pharmacieDeGardes = new ArrayList<>();

        User user = userService.getUserById(user_id);
        int pharmacie_id = user.getPharmacie().getId();
        Pharmacie pharmacie = pharmacieService.findPharmacieById(pharmacie_id);

        for (PharmacieDeGarde p: service.getAllPharmaciesDeGardeByPharmacie(pharmacie))
        {
            java.util.Date utilDate1 = sdf.parse(String.valueOf(p.getPharmacieDeGardePK().getDateDebut()));
            java.util.Date utilDate2 = sdf.parse(String.valueOf(p.getDateFin()));

            // Convert the java.util.Date object to a java.sql.Date object
            long millis1 = utilDate1.getTime();
            long millis2 = utilDate2.getTime();

            java.sql.Date debutSql = new java.sql.Date(millis1);
            java.sql.Date finSql = new java.sql.Date(millis2);

            p.getPharmacieDeGardePK().setDateDebut(debutSql);
            p.setDateFin(finSql);
            System.out.println(p.getPharmacieDeGardePK().getDateDebut() +"ha l3arr");
            pharmacieDeGardes.add(p);
        }
        return pharmacieDeGardes ;
    }

}
