package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.ITrainerService;
import com.example.NationalEquestrianFederation.model.Trainer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trainers", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class TrainerController {

    private final ITrainerService trainerService;

    @GetMapping
    public ResponseEntity<List<Trainer>> getTrainers(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(trainerService.getTrainers(horseClub), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
        return new ResponseEntity<>(trainerService.addTrainer(trainer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable Integer id) {
        trainerService.deletedTrainer(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> editTrainer(@RequestBody Trainer trainer) {
        trainerService.editTrainer(trainer);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

}
