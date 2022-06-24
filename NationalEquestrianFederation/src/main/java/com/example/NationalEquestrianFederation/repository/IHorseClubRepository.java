package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.HorseClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IHorseClubRepository extends JpaRepository<HorseClub, Integer> {

    //SELECT

    @Query("SELECT hc FROM HorseClub hc WHERE LOWER(hc.name) LIKE CONCAT('%',LOWER(?1),'%')")
    List<HorseClub> findAll(String name);

    @Query("SELECT hc FROM HorseClub hc WHERE hc.id = ?1 ")
    HorseClub getById(Integer horseId);

    @Query("SELECT hc FROM HorseClub hc WHERE hc.user.id = ?1 ")
    HorseClub findByOwnerId(Integer ownerId);

    //UPDATE

    @Query("UPDATE HorseClub hc " +
            "SET hc.description = ?2" +
            "WHERE hc.id = ?1")
    @Modifying
    @Transactional
    void editHorseClub(Integer id, String description);

}
