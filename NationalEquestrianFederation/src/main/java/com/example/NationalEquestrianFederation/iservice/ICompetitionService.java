package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.Competition;

import java.util.List;

public interface ICompetitionService {

    List<Competition> getCompetitions();

    List<Competition> getCompetitionsByDate(String date);

}
