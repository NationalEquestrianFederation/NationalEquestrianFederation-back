package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.ICompetitionService;
import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.repository.ICompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionService implements ICompetitionService {

    private final ICompetitionRepository competitionRepository;

    @Override
    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public List<Competition> getCompetitionsByDate(String date) {
        return competitionRepository.getCompetitionsByDate(date);
    }
}
