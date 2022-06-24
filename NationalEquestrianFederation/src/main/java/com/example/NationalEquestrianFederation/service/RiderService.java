package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.dto.NameDto;
import com.example.NationalEquestrianFederation.iservice.IRiderService;
import com.example.NationalEquestrianFederation.model.Rider;
import com.example.NationalEquestrianFederation.repository.IRiderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RiderService implements IRiderService {

    private final IRiderRepository riderRepository;

    @Override
    public Rider getById(Integer riderId) {
        return riderRepository.getById(riderId);
    }

    @Override
    public List<Rider> getRiders(Integer horseClub) {
        return riderRepository.findRidersByHorseClub(horseClub);
    }

    @Override
    public List<NameDto> getRiderNamesByHorseClubOwner(Integer ownerId) {
        List<Rider> riders = riderRepository.findRidersByHorseClubUser(ownerId);
        List<NameDto> riderNames = new ArrayList<>();
        for(Rider rider : riders) {
            String name = rider.getName() + " " + rider.getSurname();
            riderNames.add(new NameDto(rider.getId(), name));
        }
        return riderNames;
    }

    @Override
    public Rider addRider(Rider rider) {
        return riderRepository.save(rider);
    }

    @Override
    public void deleteRider(Integer riderId) {
        riderRepository.deleteRider(riderId);
    }

    @Override
    public void editRider(Rider rider) {
        riderRepository.editRider(rider.getId(), rider.getName(), rider.getSurname() , rider.getDateOfBirth(),
                rider.getGender(), rider.getLicence());
    }
}
