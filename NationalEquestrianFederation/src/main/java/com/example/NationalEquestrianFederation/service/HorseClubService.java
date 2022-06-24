package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.dto.LocationDto;
import com.example.NationalEquestrianFederation.iservice.IHorseClubService;
import com.example.NationalEquestrianFederation.model.HorseClub;
import com.example.NationalEquestrianFederation.model.Location;
import com.example.NationalEquestrianFederation.repository.IHorseClubRepository;
import com.example.NationalEquestrianFederation.repository.ILocationRepository;
import com.example.NationalEquestrianFederation.repository.IOrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorseClubService implements IHorseClubService {

    private final IHorseClubRepository horseClubRepository;

    private final ILocationRepository locationRepository;

    private final IOrganizationRepository organizationRepository;

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
        Location location = new Location();
        location = locationRepository.save(location);
        horseClub.setLocation(location);
        return horseClubRepository.save(horseClub);
    }

    @Override
    public void editHorseClub(HorseClub horseClub) {
        organizationRepository.editOrganization(horseClub.getId(), horseClub.getName(), horseClub.getPhoneNumber(),
                horseClub.getEmail(), horseClub.getWebSite());
        horseClubRepository.editHorseClub(horseClub.getId(), horseClub.getDescription());
    }

    @Override
    public void editHorseClubLocation(LocationDto location) {
        HorseClub horseClub = horseClubRepository.getById(location.getHorseClubId());
        locationRepository.editHorseClubLocation(horseClub.getLocation().getId(), location.getAddress(),
                location.getCity(), location.getCountry(), location.getLongitude(), location.getLatitude());
    }

}
