package com.example.NationalEquestrianFederation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorseDto {

    private Integer horseClubId;

    private String name;

    private String gender;

    private String owner;

    private Integer yearOfBirth;

}
