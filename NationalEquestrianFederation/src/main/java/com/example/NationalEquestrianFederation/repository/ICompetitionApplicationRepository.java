package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.CompetitionApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICompetitionApplicationRepository extends JpaRepository<CompetitionApplication, Integer> {

    @Query("SELECT ca FROM CompetitionApplication ca WHERE ca.competition.id = ?1 ")
    List<CompetitionApplication> findCompetitionApplications(Integer competitionId);

}
