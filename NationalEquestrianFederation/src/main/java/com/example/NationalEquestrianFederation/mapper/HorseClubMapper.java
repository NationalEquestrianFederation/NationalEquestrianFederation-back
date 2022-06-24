package com.example.NationalEquestrianFederation.mapper;


import com.example.NationalEquestrianFederation.dto.HorseClubDto;
import com.example.NationalEquestrianFederation.model.HorseClub;

public class HorseClubMapper {

    public static HorseClub convertToHorseClub(HorseClubDto dto) {
        HorseClub horseClub = new HorseClub();
        horseClub.setName(dto.getName());
        horseClub.setEmail(dto.getEmail());
        horseClub.setPhoneNumber(dto.getPhoneNumber());
        horseClub.setDescription(dto.getDescription());
        return horseClub;
    }

}
