package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.HorseClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHorseClubRepository extends JpaRepository<HorseClub, Integer> {

    @Query("SELECT hc FROM HorseClub hc WHERE LOWER(hc.name) LIKE CONCAT('%',LOWER(?1),'%')")
    List<HorseClub> findAll(String name);

}
