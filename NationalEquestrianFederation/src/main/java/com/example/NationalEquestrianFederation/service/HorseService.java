package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.dto.NameDto;
import com.example.NationalEquestrianFederation.iservice.IHorseService;
import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.repository.IHorseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HorseService implements IHorseService {

    private final IHorseRepository horseRepository;

    @Override
    public Horse getById(Integer horseId) {
        return horseRepository.getById(horseId);
    }

    @Override
    public List<Horse> getHorses(Integer horseClub) {
        return horseRepository.findHorsesByHorseClub(horseClub);
    }

    @Override
    public List<NameDto> getHorseNamesByHorseClubOwner(Integer ownerId) {
        List<Horse> horses = horseRepository.findHorsesByHorseClubUser(ownerId);
        List<NameDto> horseNames = new ArrayList<>();
        for(Horse horse : horses) {
            horseNames.add(new NameDto(horse.getId(), horse.getName()));
        }
        return horseNames;
    }

    @Override
    public Horse addHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    @Override
    public void deleteHorse(Integer horseId) {
        horseRepository.deleteHorse(horseId);
    }

    @Override
    public void editHorse(Horse horse) {
        horseRepository.editHorse(horse.getId(), horse.getName(), horse.getYearOfBirth(),
                horse.getOwner(), horse.getGender());
    }
}
