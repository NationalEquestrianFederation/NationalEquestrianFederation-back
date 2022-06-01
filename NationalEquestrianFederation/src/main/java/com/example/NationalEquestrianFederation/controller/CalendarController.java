package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.dto.DateDto;
import com.example.NationalEquestrianFederation.iservice.ICalendarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/calendar", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class CalendarController {

    private ICalendarService calendarService;

    @GetMapping
    public ResponseEntity<List<DateDto>> getCompetitions(@RequestParam Integer month, @RequestParam Integer year) {
        return new ResponseEntity<>(calendarService.getDatesOfMonth(month, year), HttpStatus.OK);
    }

}
