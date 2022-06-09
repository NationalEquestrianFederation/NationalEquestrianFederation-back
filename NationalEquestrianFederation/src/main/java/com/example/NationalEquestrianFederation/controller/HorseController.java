package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.HorseDto;
import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.iservice.IHorseService;
import com.example.NationalEquestrianFederation.mapper.HorseMapper;
import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.model.HorseClub;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/horses", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class HorseController {

    private final IHorseService horseService;

    private final IHorseClubService horseClubService;

    @GetMapping
    public ResponseEntity<List<Horse>> getHorses(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(horseService.getHorses(horseClub), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Horse> addHorse(@RequestBody HorseDto horseDto) {
        HorseClub horseClub = horseClubService.findById(horseDto.getHorseClubId());
        Horse horse = HorseMapper.convertToHorse(horseDto);
        horse.setHorseClub(horseClub);
        return new ResponseEntity<>(horseService.addHorse(horse), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHorse(@PathVariable Integer id) {
        horseService.deleteHorse(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> editHorse(@RequestBody Horse horse) {
        horseService.editHorse(horse);
        return new ResponseEntity<>("Successfully edited", HttpStatus.OK);
    }

}
