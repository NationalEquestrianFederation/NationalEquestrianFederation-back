package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Rider;
import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IRiderRepository extends JpaRepository<Rider, Integer> {

    //SELECT

    @Query("SELECT r FROM Rider r WHERE r.id = ?1 ")
    Rider getById(Integer riderId);

    @Query("SELECT r FROM Rider r WHERE (?1 = 0 OR r.horseClub = ?1) AND r.isDeleted = false ")
    List<Rider> findRidersByHorseClub(Integer horseClub);

    @Query("SELECT r FROM Rider r WHERE r.horseClub.owner.id = ?1 ")
    List<Rider> findRidersByHorseClubOwner(Integer ownerId);

    //UPDATE

    @Query("UPDATE Rider r SET r.isDeleted = true WHERE r.id = ?1")
    @Modifying
    @Transactional
    void deleteRider(Integer riderId);

    @Query("UPDATE Rider r " +
            "SET r.name = ?2, r.surname = ?3, r.dateOfBirth = ?4, r.gender = ?5, r.licence = ?6 " +
            "WHERE r.id = ?1")
    @Modifying
    @Transactional
    void editRider(Integer id, String name, String surname, String dateOfBirth, Gender gender, Licence licence);

}
