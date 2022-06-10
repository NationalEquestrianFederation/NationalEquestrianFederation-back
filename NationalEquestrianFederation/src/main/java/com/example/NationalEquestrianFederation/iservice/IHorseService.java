package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.dto.NameDto;
import com.example.NationalEquestrianFederation.model.Horse;

import java.util.List;

public interface IHorseService {

    Horse getById(Integer horseId);

    List<Horse> getHorses(Integer horseClub);

    List<NameDto> getHorseNamesByHorseClubOwner(Integer ownerId);

    Horse addHorse(Horse horse);

    void deleteHorse(Integer horseId);

    void editHorse(Horse horse);

}
