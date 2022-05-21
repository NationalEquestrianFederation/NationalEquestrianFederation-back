package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITrainerRepository extends JpaRepository<Trainer, Integer> {

    @Query("SELECT t FROM Trainer t WHERE (?1 = 0 OR t.horseClub = ?1) AND t.isDeleted = false")
    List<Trainer> findTrainersByHorseClub(Integer horseClub);
}
