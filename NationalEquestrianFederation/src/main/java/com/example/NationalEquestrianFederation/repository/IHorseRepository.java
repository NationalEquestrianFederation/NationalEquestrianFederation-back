package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.model.enums.HorseGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IHorseRepository extends JpaRepository<Horse, Integer> {

    //SELECT

    @Query("SELECT h FROM Horse h WHERE h.id = ?1 ")
    Horse getById(Integer horseId);

    @Query("SELECT h FROM Horse h WHERE (?1 = 0 OR h.horseClub = ?1) AND h.isDeleted = false ")
    List<Horse> findHorsesByHorseClub(Integer horseClub);

    @Query("SELECT h FROM Horse h WHERE h.horseClub.owner.id = ?1 ")
    List<Horse> findHorsesByHorseClubOwner(Integer ownerId);

    //UPDATE

    @Query("UPDATE Horse h SET h.isDeleted = true WHERE h.id = ?1")
    @Modifying
    @Transactional
    void deleteHorse(Integer horseId);

    @Query("UPDATE Horse h " +
            "SET h.name = ?2, h.yearOfBirth = ?3, h.owner = ?4, h.gender = ?5 " +
            "WHERE h.id = ?1")
    @Modifying
    @Transactional
    void editHorse(Integer horseId, String name, Integer yearOfBirth, String owner, HorseGender gender);

}
