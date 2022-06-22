package com.example.NationalEquestrianFederation.mapper;

import com.example.NationalEquestrianFederation.dto.HorseDto;
import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.model.enums.HorseGender;

public class HorseMapper {

    public static Horse convertToHorse(HorseDto dto) {
        Horse horse = new Horse();
        horse.setName(dto.getName());
        horse.setGender(HorseGender.valueOf(dto.getGender()));
        horse.setOwner(dto.getOwner());
        horse.setYearOfBirth(dto.getYearOfBirth());
        return horse;
    }

}
