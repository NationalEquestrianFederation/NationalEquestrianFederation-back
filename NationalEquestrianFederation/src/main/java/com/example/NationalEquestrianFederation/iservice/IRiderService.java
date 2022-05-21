package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.Rider;

import java.util.List;

public interface IRiderService {

    List<Rider> getRiders(Integer horseClub);

    Rider addRider(Rider rider);

    void deleteRider(Integer riderId);

}
