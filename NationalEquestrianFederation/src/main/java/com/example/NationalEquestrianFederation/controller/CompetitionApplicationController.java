package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.CompetitionApplicationDto;
import com.example.NationalEquestrianFederation.iservice.ICompetitionApplicationService;
import com.example.NationalEquestrianFederation.iservice.ICompetitionService;
import com.example.NationalEquestrianFederation.iservice.IHorseService;
import com.example.NationalEquestrianFederation.iservice.IRiderService;
import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.model.CompetitionApplication;
import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.model.Rider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/competitionApplication", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class CompetitionApplicationController {

    private final IRiderService riderService;

    private final IHorseService horseService;

    private final ICompetitionService competitionService;

    private final ICompetitionApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<CompetitionApplication>> getApplications(@RequestParam Integer id) {
        return  new ResponseEntity<>(applicationService.getCompetitionApplications(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompetitionApplication> applyForCompetition(@RequestBody CompetitionApplicationDto applicationDto) {
        Rider rider = riderService.getById(applicationDto.getRiderId());
        Horse horse = horseService.getById(applicationDto.getHorseId());
        Competition competition = competitionService.getById(applicationDto.getCompetitionId());

        CompetitionApplication application = new CompetitionApplication(rider, horse, competition);
        return new ResponseEntity<>(applicationService.applyForCompetition(application), HttpStatus.CREATED);
    }

}
