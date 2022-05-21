package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.ICompetitionService;
import com.example.NationalEquestrianFederation.model.Competition;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/competitions", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class CompetitionController {

    private final ICompetitionService competitionService;

    @GetMapping
    public ResponseEntity<List<Competition>> getCompetitions() {
        return new ResponseEntity<>(competitionService.getCompetitions(), HttpStatus.OK);
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<Competition>> getCompetitionsByDate(@PathVariable String date) {
        return new ResponseEntity<>(competitionService.getCompetitionsByDate(date), HttpStatus.OK);
    }

}
