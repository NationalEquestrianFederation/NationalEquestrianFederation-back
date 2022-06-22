package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.dto.LocationDto;
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
    public HorseClub findById(Integer horseClubId) {
        return horseClubRepository.getById(horseClubId);
    }

    @Override
    public HorseClub findByOwnerId(Integer ownerId) {
        return horseClubRepository.findByOwnerId(ownerId);
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

    @Override
    public void editHorseClubLocation(LocationDto location) {
        horseClubRepository.editHorseClubLocation(location.getHorseClubId(), location.getAddress(),
                location.getLongitude(), location.getLatitude());
    }

}
