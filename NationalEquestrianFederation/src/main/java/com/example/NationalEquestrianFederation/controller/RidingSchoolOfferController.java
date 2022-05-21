package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.IRidingSchoolOfferService;
import com.example.NationalEquestrianFederation.model.RidingSchoolOffer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ridingSchoolOffers", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class RidingSchoolOfferController {

    private final IRidingSchoolOfferService offerService;

    @GetMapping
    public ResponseEntity<List<RidingSchoolOffer>> getRidingSchoolOffers(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(offerService.getRidingSchoolOffers(horseClub), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RidingSchoolOffer> addRidingSchoolOffer(@RequestBody RidingSchoolOffer offer){
        return new ResponseEntity<>(offerService.addRidingSchoolOffer(offer), HttpStatus.CREATED);
    }

}
