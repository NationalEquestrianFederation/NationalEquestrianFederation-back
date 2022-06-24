package com.example.NationalEquestrianFederation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private Integer horseClubId;

    private String address;

    private String city;

    private String country;

    private double latitude;

    private double longitude;

}
