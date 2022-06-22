package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.NameDto;
import com.example.NationalEquestrianFederation.dto.RiderDto;
import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.iservice.IRiderService;
import com.example.NationalEquestrianFederation.mapper.RiderMapper;
import com.example.NationalEquestrianFederation.model.HorseClub;
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

    private final IHorseClubService horseClubService;

    @GetMapping
    public ResponseEntity<List<Rider>> getRiders(@RequestParam Integer horseClub) {
        return new ResponseEntity<>(riderService.getRiders(horseClub), HttpStatus.OK);
    }

    @GetMapping("/riderNames")
    public ResponseEntity<List<NameDto>> getHorseNames(@RequestParam Integer owner) {
        return  new ResponseEntity<>(riderService.getRiderNamesByHorseClubOwner(owner), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rider> addRider(@RequestBody RiderDto riderDto) {
        Rider rider = RiderMapper.convertToRider(riderDto);
        HorseClub horseClub = horseClubService.findByOwnerId(riderDto.getOwnerId());
        rider.setHorseClub(horseClub);
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

}
