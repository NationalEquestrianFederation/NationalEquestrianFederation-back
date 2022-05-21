package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IHorseRepository extends JpaRepository<Horse, Integer> {

    @Query("SELECT h FROM Horse h WHERE (?1 = 0 OR h.horseClub = ?1) AND h.isDeleted = false ")
    List<Horse> findHorsesByHorseClub(Integer horseClub);

    @Query("UPDATE Horse h SET h.isDeleted = true WHERE h.id = ?1")
    @Modifying
    @Transactional
    void deleteHorse(Integer horseId);

}
