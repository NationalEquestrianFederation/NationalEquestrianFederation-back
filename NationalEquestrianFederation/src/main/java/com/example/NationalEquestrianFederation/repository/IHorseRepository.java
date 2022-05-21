package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHorseRepository extends JpaRepository<Horse, Integer> {

    @Query("SELECT h FROM Horse h WHERE (?1 = 0 OR h.horseClub = ?1) AND h.isDeleted = false ")
    List<Horse> findHorsesByHorseClub(Integer horseClub);

}
