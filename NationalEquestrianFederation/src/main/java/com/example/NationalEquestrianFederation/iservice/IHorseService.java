package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.Horse;

import java.util.List;

public interface IHorseService {

    List<Horse> getHorses(Integer horseClub);

    Horse addHorse(Horse horse);

    void deleteHorse(Integer horseId);

}
