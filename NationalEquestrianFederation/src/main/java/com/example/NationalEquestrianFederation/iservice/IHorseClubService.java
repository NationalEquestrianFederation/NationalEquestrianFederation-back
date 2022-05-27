package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.HorseClub;

import java.util.List;
import java.util.Optional;

public interface IHorseClubService {

    List<HorseClub> findAll(String name);

    Optional<HorseClub> findById(Integer horseClubId);

    HorseClub addHorseClub(HorseClub horseClub);

    void editHorseClub(HorseClub horseClub);

}
