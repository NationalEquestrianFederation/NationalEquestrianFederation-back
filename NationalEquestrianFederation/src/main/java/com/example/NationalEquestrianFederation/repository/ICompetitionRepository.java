package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICompetitionRepository extends JpaRepository<Competition, Integer> {

    //SELECT

    @Query("SELECT c FROM Competition c WHERE c.id = ?1 ")
    Competition getById(Integer competitionId);

    @Query("SELECT c FROM Competition c WHERE ?1 BETWEEN c.startDate AND c.endDate")
    List<Competition> getCompetitionsByDate(String date);

}
