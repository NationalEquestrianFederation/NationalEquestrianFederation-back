package com.example.NationalEquestrianFederation.mapper;

import com.example.NationalEquestrianFederation.dto.RiderDto;
import com.example.NationalEquestrianFederation.model.Rider;
import com.example.NationalEquestrianFederation.model.enums.Gender;
import com.example.NationalEquestrianFederation.model.enums.Licence;

public class RiderMapper {

    public static Rider convertToRider(RiderDto dto) {
        Rider rider = new Rider();
        rider.setName(dto.getName());
        rider.setSurname(dto.getSurname());
        rider.setDateOfBirth(dto.getDateOfBirth());
        rider.setGender(Gender.valueOf(dto.getGender()));
        rider.setLicence(Licence.valueOf(dto.getLicence()));
        return rider;
    }

}
