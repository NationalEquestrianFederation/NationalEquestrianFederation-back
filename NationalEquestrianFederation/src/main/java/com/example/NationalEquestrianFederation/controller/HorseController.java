package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.IHorseService;
import com.example.NationalEquestrianFederation.model.Horse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/horses", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class HorseController {

    private final IHorseService horseService;

    @GetMapping
    public ResponseEntity<List<Horse>> getHorses(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(horseService.getHorses(horseClub), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Horse> addHorse(@RequestBody Horse horse) {
        return new ResponseEntity<>(horseService.addHorse(horse), HttpStatus.OK);
    }

}
