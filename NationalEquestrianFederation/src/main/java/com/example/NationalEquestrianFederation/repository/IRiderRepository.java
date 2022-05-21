package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IRiderRepository extends JpaRepository<Rider, Integer> {

    @Query("SELECT r FROM Rider r WHERE (?1 = 0 OR r.horseClub = ?1) AND r.isDeleted = false ")
    List<Rider> findRidersByHorseClub(Integer horseClub);

    @Query("UPDATE Rider r SET r.isDeleted = true WHERE r.id = ?1")
    @Modifying
    @Transactional
    void deleteRider(Integer riderId);

}
