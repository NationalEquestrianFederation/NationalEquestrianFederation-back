package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.HorseClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IHorseClubRepository extends JpaRepository<HorseClub, Integer> {

    @Query("SELECT hc FROM HorseClub hc WHERE LOWER(hc.name) LIKE CONCAT('%',LOWER(?1),'%')")
    List<HorseClub> findAll(String name);

    @Query("UPDATE HorseClub hc " +
            "SET hc.name = ?2, hc.phone = ?3, hc.address = ?4, hc.email = ?5, hc.description = ?6 " +
            "WHERE hc.id = ?1")
    @Modifying
    @Transactional
    void editHorseClub(Integer id, String name, String phone, String address, String email, String description);

}
