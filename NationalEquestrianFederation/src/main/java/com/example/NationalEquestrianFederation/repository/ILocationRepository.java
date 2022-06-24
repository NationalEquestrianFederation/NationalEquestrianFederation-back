package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ILocationRepository extends JpaRepository<Location, Integer> {

    @Query("UPDATE Location l " +
            "SET l.address = ?2, l.city = ?3, l.country = ?4, l.longitude = ?5, l.latitude = ?6 " +
            "WHERE l.id = ?1")
    @Modifying
    @Transactional
    void editHorseClubLocation(Integer id, String address, String city, String country, double longitude, double latitude);

}
