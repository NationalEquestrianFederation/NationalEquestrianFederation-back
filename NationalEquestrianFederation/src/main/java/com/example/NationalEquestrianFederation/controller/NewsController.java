package com.example.NationalEquestrianFederation.controller;

import com.example.NationalEquestrianFederation.iservice.INewsService;
import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.enums.NewsType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@AllArgsConstructor
public class NewsController {

    private final INewsService newsService;

    @GetMapping()
    public ResponseEntity<List<News>> getNationalFederationNews(@RequestParam String newsType) {
        NewsType type = NewsType.valueOf(newsType);
        return new ResponseEntity<>(newsService.findNewsByType(type), HttpStatus.OK);
    }

}
