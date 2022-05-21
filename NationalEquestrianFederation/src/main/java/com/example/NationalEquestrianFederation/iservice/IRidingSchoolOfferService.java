package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.RidingSchoolOffer;

import java.util.List;

public interface IRidingSchoolOfferService {

    List<RidingSchoolOffer> getRidingSchoolOffers(Integer horseClub);

    RidingSchoolOffer addRidingSchoolOffer(RidingSchoolOffer offer);

    void deleteRidingSchoolOffer(Integer offerId);

}
