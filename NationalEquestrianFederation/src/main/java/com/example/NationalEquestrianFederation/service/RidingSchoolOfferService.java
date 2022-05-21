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

    @Override
    public RidingSchoolOffer addRidingSchoolOffer(RidingSchoolOffer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void deleteRidingSchoolOffer(Integer offerId) {
        offerRepository.deleteRidingSchoolOffer(offerId);
    }

    @Override
    public void editRidingSchoolOffer(RidingSchoolOffer offer) {
        offerRepository.editRidingSchoolOffer(offer.getId(), offer.getName(), offer.getPrice(), offer.getStartDate(),
                offer.getEndDate(), offer.getDescription());
    }
}
