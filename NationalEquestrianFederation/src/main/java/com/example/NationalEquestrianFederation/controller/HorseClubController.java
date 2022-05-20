package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.model.HorseClub;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/horseClubs", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class HorseClubController {

    private final IHorseClubService horseClubService;

    @GetMapping
    public ResponseEntity<List<HorseClub>> getHorseClubs(@RequestParam String name) {
        return new ResponseEntity<>(horseClubService.findAll(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HorseClub> addHorseClub(@RequestBody HorseClub horseClub) {
        return new ResponseEntity<>(horseClubService.addHorseClub(horseClub), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> editHorseClub(@RequestBody HorseClub horseClub) {
        horseClubService.editHorseClub(horseClub);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

}
