package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.model.HorseClub;
import com.example.NationalEquestrianFederation.repository.IHorseClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HorseClubService implements IHorseClubService {

    private final IHorseClubRepository horseClubRepository;

    @Override
    public List<HorseClub> findAll(String name) {
        return horseClubRepository.findAll(name);
    }

    @Override
    public Optional<HorseClub> findById(Integer horseClubId) {
        return horseClubRepository.findById(horseClubId);
    }

    @Override
    public HorseClub addHorseClub(HorseClub horseClub) {
        return horseClubRepository.save(horseClub);
    }

    @Override
    public void editHorseClub(HorseClub horseClub) {
        horseClubRepository.editHorseClub(horseClub.getId(), horseClub.getName(), horseClub.getPhone(),
                horseClub.getAddress(), horseClub.getEmail(), horseClub.getDescription());
    }

}
