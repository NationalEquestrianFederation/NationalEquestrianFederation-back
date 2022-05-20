package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRiderRepository extends JpaRepository<Rider, Integer> {

    @Query("SELECT r FROM Rider r WHERE ?1 = 0 OR r.horseClub = ?1 ")
    List<Rider> findRidersByHorseClub(Integer horseClub);

}
