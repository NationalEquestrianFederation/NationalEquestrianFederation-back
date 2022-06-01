package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.Competition;
import com.example.NationalEquestrianFederation.model.Rider;

import java.util.List;

public interface IRiderService {

    List<Rider> getRiders(Integer horseClub);

    Rider addRider(Rider rider);

    void deleteRider(Integer riderId);

    void editRider(Rider rider);

    List<Competition> getRiderCompetitions(Integer riderId);

    void applyRiderForCompetition(Integer riderId, Integer competitionId);

}
