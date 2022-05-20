package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.IRiderService;
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
        return  new ResponseEntity<>(riderService.getRiders(horseClub), HttpStatus.OK);
    }

}
