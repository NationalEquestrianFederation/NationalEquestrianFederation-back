package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.RiderCompetitionDto;
import com.example.NationalEquestrianFederation.iservice.IRiderService;
import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.model.Rider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/riders", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class RiderController {

    private final IRiderService riderService;

    @GetMapping
    public ResponseEntity<List<Rider>> getRiders(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(riderService.getRiders(horseClub), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rider> addRider(@RequestBody Rider rider) {
        return new ResponseEntity<>(riderService.addRider(rider), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRider(@PathVariable Integer id) {
        riderService.deleteRider(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> editRider(@RequestBody Rider rider) {
        riderService.editRider(rider);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

    @GetMapping("/competitions/{id}")
    public ResponseEntity<List<Competition>> getRiderCompetitions(@PathVariable Integer id) {
        return new ResponseEntity<>(riderService.getRiderCompetitions(id), HttpStatus.OK);
    }

    @PostMapping("/applyForCompetition")
    public ResponseEntity<String> applyForCompetition(@RequestBody RiderCompetitionDto dto) {
        riderService.applyRiderForCompetition(dto.getRiderId(), dto.getCompetitionId());
        return new ResponseEntity<>("Successfully applied", HttpStatus.OK);
    }

}
