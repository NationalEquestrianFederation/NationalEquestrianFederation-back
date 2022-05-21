package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Trainer;
import com.example.NationalEquestrianFederation.model.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ITrainerRepository extends JpaRepository<Trainer, Integer> {

    @Query("SELECT t FROM Trainer t WHERE (?1 = 0 OR t.horseClub = ?1) AND t.isDeleted = false")
    List<Trainer> findTrainersByHorseClub(Integer horseClub);

    @Query("UPDATE Trainer t SET t.isDeleted = true WHERE t.id = ?1 ")
    @Modifying
    @Transactional
    void deleteTrainer(Integer trainerId);

    @Query("UPDATE Trainer t " +
            "SET t.name = ?2, t.surname = ?3, t.dateOfBirth = ?4, t.gender = ?5 " +
            "WHERE t.id = ?1 ")
    @Modifying
    @Transactional
    void editTrainer(Integer trainerId, String name, String surname, String dateOfBirth, Gender gender);

}
