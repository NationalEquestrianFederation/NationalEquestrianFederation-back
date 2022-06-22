package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.dto.LocationDto;
import com.example.NationalEquestrianFederation.model.HorseClub;

import java.util.List;
import java.util.Optional;

public interface IHorseClubService {

    List<HorseClub> findAll(String name);

    HorseClub findById(Integer horseClubId);

    HorseClub findByOwnerId(Integer ownerId);

    HorseClub addHorseClub(HorseClub horseClub);

    void editHorseClub(HorseClub horseClub);

    void editHorseClubLocation(LocationDto location);

}
