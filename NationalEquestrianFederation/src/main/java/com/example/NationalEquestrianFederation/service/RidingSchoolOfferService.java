package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.IRidingSchoolOfferService;
import com.example.NationalEquestrianFederation.model.RidingSchoolOffer;
import com.example.NationalEquestrianFederation.repository.IRidingSchoolOfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RidingSchoolOfferService implements IRidingSchoolOfferService {

    private final IRidingSchoolOfferRepository offerRepository;

    @Override
    public List<RidingSchoolOffer> getRidingSchoolOffers(Integer horseClub) {
        return offerRepository.findOffersByHorseClub(horseClub);
    }
}
