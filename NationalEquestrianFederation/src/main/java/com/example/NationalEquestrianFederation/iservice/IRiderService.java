package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.dto.NameDto;
import com.example.NationalEquestrianFederation.model.Rider;

import java.util.List;

public interface IRiderService {

    Rider getById(Integer riderId);

    List<Rider> getRiders(Integer horseClub);

    List<NameDto> getRiderNamesByHorseClubOwner(Integer ownerId);

    Rider addRider(Rider rider);

    void deleteRider(Integer riderId);

    void editRider(Rider rider);

}
