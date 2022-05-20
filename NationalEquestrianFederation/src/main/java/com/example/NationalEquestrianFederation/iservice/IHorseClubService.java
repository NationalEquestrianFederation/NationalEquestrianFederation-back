package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.HorseClub;

import java.util.List;

public interface IHorseClubService {

    List<HorseClub> findAll(String name);

}
