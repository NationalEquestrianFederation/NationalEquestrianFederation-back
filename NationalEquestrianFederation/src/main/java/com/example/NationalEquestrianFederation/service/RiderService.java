package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IRiderService;
import com.example.NationalEquestrianFederation.model.Rider;
import com.example.NationalEquestrianFederation.repository.IRiderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RiderService implements IRiderService {

    private final IRiderRepository riderRepository;

    @Override
    public List<Rider> getRiders(Integer horseClub) {
        return riderRepository.findRidersByHorseClub(horseClub);
    }

    @Override
    public Rider addRider(Rider rider) {
        return riderRepository.save(rider);
    }

    @Override
    public void deleteRider(Integer riderId) {
        riderRepository.deleteRider(riderId);
    }
}
