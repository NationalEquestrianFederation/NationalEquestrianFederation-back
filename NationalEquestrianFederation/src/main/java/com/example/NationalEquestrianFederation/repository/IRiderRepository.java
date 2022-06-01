package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.model.Rider;
import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;
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

    @Query("UPDATE Rider r " +
            "SET r.name = ?2, r.surname = ?3, r.dateOfBirth = ?4, r.gender = ?5, r.licence = ?6 " +
            "WHERE r.id = ?1")
    @Modifying
    @Transactional
    void editRider(Integer id, String name, String surname, String dateOfBirth, Gender gender, Licence licence);

    @Query("SELECT r.competitions FROM Rider r WHERE r.id = ?1 ")
    List<Competition> findRiderCompetitions(Integer riderId);


    /*@Query("INSERT INTO riders_competitions (rider_rider_id, competitions_competition_id) " +
                "SELECT (rider_rider_id, competitions_competition_id) " +
                "FROM riders JOIN competitions ON riders.rider_id = competitions.competition_id " +
            "VALUES (?1, ?2) ")*/
    @Query(value = "INSERT INTO riders_competitions(rider_rider_id, competitions_competition_id) " +
            "VALUES ((SELECT rider_id,competition_id FROM riders " +
            "         INNER JOIN competitions ON riders.rider_id = competitions.competition_id))", nativeQuery = true)
    @Modifying
    @Transactional
    void applyRiderForCompetition(Integer riderId, Integer competitionId);

    @Query("SELECT r FROM Rider r WHERE r.id = ?1")
    Rider findRiderById(Integer riderId);

    @Query("DELETE FROM Rider r WHERE r.id = ?1")
    @Modifying
    @Transactional
    void temporaryDeleteRider(Integer riderId);

}
