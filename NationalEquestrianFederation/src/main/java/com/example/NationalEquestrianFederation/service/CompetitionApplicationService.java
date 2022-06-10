package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.ICompetitionApplicationService;
import com.example.NationalEquestrianFederation.model.CompetitionApplication;
import com.example.NationalEquestrianFederation.repository.ICompetitionApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionApplicationService implements ICompetitionApplicationService {

    private final ICompetitionApplicationRepository repository;

    @Override
    public List<CompetitionApplication> getCompetitionApplications(Integer competitionId) {
        return repository.findCompetitionApplications(competitionId);
    }

    @Override
    public CompetitionApplication applyForCompetition(CompetitionApplication application) {
        return repository.save(application);
    }

}
