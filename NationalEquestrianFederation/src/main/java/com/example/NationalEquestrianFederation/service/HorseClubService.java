package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.model.HorseClub;
import com.example.NationalEquestrianFederation.repository.IHorseClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorseClubService implements IHorseClubService {

    private final IHorseClubRepository horseClubRepository;

    @Override
    public List<HorseClub> findAll(String name) {
        return horseClubRepository.findAll(name);
    }

    @Override
    public HorseClub addHorseClub(HorseClub horseClub) {
        return horseClubRepository.save(horseClub);
    }
}
