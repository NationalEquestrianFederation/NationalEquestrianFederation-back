package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.CompetitionApplication;

import java.util.List;

public interface ICompetitionApplicationService {

    List<CompetitionApplication> getCompetitionApplications(Integer competitionId);

    CompetitionApplication applyForCompetition(CompetitionApplication application);

}
