package com.example.pharmacieapi.repositories;

import com.example.pharmacieapi.entity.Garde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardeRepository extends JpaRepository<Garde,Integer> {
}
