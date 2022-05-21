package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IHorseService;
import com.example.NationalEquestrianFederation.model.Horse;
import com.example.NationalEquestrianFederation.repository.IHorseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorseService implements IHorseService {

    private final IHorseRepository horseRepository;

    @Override
    public List<Horse> getHorses(Integer horseClub) {
        return horseRepository.findHorsesByHorseClub(horseClub);
    }

    @Override
    public Horse addHorse(Horse horse) {
        return horseRepository.save(horse);
    }
}
